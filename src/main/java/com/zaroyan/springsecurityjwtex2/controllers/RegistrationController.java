package com.zaroyan.springsecurityjwtex2.controllers;

import com.zaroyan.springsecurityjwtex2.dto.UserDto;
import com.zaroyan.springsecurityjwtex2.services.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zaroyan
 */
@RestController
@RequestMapping("/public")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userRequest) {
        try {
            registrationService.register(userRequest);
            return ResponseEntity.ok("Пользователь успешно зарегистрирован.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Произошла ошибка при регистрации пользователя: " + e.getMessage());
        }
    }
}

