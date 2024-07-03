package com.zaroyan.springsecurityjwtex2.dto;

import lombok.Data;

/**
 * @author Zaroyan
 */
@Data
public class RegistrationUserDto {
    private String username;
    private String password;
    private String role;
}
