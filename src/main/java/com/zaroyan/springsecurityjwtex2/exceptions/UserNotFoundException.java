package com.zaroyan.springsecurityjwtex2.exceptions;

/**
 * @author Zaroyan
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
