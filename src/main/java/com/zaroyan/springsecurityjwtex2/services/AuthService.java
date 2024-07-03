package com.zaroyan.springsecurityjwtex2.services;

import com.zaroyan.springsecurityjwtex2.dto.JwtRequest;
import com.zaroyan.springsecurityjwtex2.dto.JwtResponse;
import com.zaroyan.springsecurityjwtex2.dto.RegistrationUserDto;
import com.zaroyan.springsecurityjwtex2.dto.UserDto;
import com.zaroyan.springsecurityjwtex2.entity.User;
import com.zaroyan.springsecurityjwtex2.exceptions.AppError;
import com.zaroyan.springsecurityjwtex2.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author Zaroyan
 */
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserDetailsServiceImpl userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> createAuthToken(JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> createNewUser( RegistrationUserDto registrationUserDto) {

        if (userService.findByUsername(registrationUserDto.getUsername()).isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        User user = userService.createNewUser(registrationUserDto);
        return ResponseEntity.ok(new UserDto(user.getId(), user.getUsername()));
    }
}
