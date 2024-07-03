package com.zaroyan.springsecurityjwtex2.exceptions;

/**
 * @author Zaroyan
 */
public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message);
    }
}
