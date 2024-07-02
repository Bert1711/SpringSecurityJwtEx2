package com.zaroyan.springsecurityjwtex2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Zaroyan
 */
@Data
@AllArgsConstructor
public class AuthenticationResponse {
    private String jwt;
}
