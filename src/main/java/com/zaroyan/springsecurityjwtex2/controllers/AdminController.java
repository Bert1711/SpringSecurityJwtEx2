package com.zaroyan.springsecurityjwtex2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zaroyan
 */
@RestController
@RequestMapping("/api")
public class AdminController {

    @PreAuthorize("hasRole('MODERATOR')")
    @GetMapping("/moderator")
    public ResponseEntity<String> moderatorAccess() {
        return ResponseEntity.ok("Content for MODERATOR");
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @GetMapping("/superadmin")
    public ResponseEntity<String> superAdminAccess() {
        return ResponseEntity.ok("Content for SUPER_ADMIN");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public ResponseEntity<String> userAccess() {
        return ResponseEntity.ok("Content for USER");
    }
}

