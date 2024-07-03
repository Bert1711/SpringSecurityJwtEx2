package com.zaroyan.springsecurityjwtex2.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author Zaroyan
 */
@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
}
