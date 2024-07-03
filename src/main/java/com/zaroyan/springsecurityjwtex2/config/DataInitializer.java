package com.zaroyan.springsecurityjwtex2.config;

import com.zaroyan.springsecurityjwtex2.entity.Role;
import com.zaroyan.springsecurityjwtex2.entity.User;
import com.zaroyan.springsecurityjwtex2.repositories.RoleRepository;
import com.zaroyan.springsecurityjwtex2.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zaroyan
 */


@Configuration
public class DataInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        List<String> roleNames = Arrays.asList("USER", "MODERATOR", "SUPER_ADMIN");
        for (String roleName : roleNames) {
            if (!roleRepository.findByName(roleName).isPresent()) {
                Role role = new Role();
                role.setName(roleName);
                roleRepository.save(role);
            }
        }

    }

}
