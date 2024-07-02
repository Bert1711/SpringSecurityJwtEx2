package com.zaroyan.springsecurityjwtex2.dto;

import lombok.Data;

/**
 * @author Zaroyan
 */
@Data
public class LoginRequest {
    private String username;
    private String password;
}
