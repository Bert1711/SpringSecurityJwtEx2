package com.zaroyan.springsecurityjwtex2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Zaroyan
 */
@RestController
public class AdminController {

    @GetMapping("/user")
    public ResponseEntity<String> userAccess() {
        return ResponseEntity.ok("Content for USER");
    }

    @GetMapping("/moderator")
    public ResponseEntity<String> moderatorAccess() {
        return ResponseEntity.ok("Content for MODERATOR");
    }

    @GetMapping("/superadmin")
    public ResponseEntity<String> superAdminAccess() {
        return ResponseEntity.ok("Content for SUPER_ADMIN");
    }
    @GetMapping("/info")
    public String userData(Principal principal) {
        return principal.getName();
    }
}

