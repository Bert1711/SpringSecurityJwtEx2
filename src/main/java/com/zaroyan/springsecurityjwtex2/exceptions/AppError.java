package com.zaroyan.springsecurityjwtex2.exceptions;

import lombok.Data;

import java.util.Date;

/**
 * @author Zaroyan
 */
@Data
public class AppError {
    private int status;
    private String message;
    private Date timestamp;

    public AppError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
