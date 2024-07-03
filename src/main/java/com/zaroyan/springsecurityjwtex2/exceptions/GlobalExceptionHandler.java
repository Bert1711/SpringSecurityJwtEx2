package com.zaroyan.springsecurityjwtex2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Zaroyan
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        return new ResponseEntity<>("Доступ запрещен", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>("Пользователь не найден", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Внутренняя ошибка сервера", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

