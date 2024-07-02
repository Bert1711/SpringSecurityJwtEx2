package com.zaroyan.springsecurityjwtex2.controllers;

/**
 * @author Zaroyan
 */
import com.zaroyan.springsecurityjwtex2.dto.AuthenticationRequest;
import com.zaroyan.springsecurityjwtex2.dto.AuthenticationResponse;
import com.zaroyan.springsecurityjwtex2.security.JwtUtil;
import com.zaroyan.springsecurityjwtex2.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );


            String jwt = jwtUtil.generateToken((UserDetails) authentication.getPrincipal());
            AuthenticationResponse authResponse = new AuthenticationResponse(jwt);

            return ResponseEntity.ok(authResponse);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
