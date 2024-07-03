package com.zaroyan.springsecurityjwtex2.controllers;
import com.zaroyan.springsecurityjwtex2.dto.JwtRequest;
import com.zaroyan.springsecurityjwtex2.dto.RegistrationUserDto;
import com.zaroyan.springsecurityjwtex2.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Zaroyan
 */


@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        return authService.createNewUser(registrationUserDto);
    }
}
