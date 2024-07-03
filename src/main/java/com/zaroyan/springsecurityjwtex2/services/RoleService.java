package com.zaroyan.springsecurityjwtex2.services;

import com.zaroyan.springsecurityjwtex2.entity.Role;
import com.zaroyan.springsecurityjwtex2.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author Zaroyan
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {
    private final RoleRepository roleRepository;

    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role save(String role) {
        Role roleEntity = new Role();
        roleEntity.setId(null);
        roleEntity.setName(role);

        return roleRepository.save(roleEntity);
    }

    public Role getUserRole(String roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new NoSuchElementException("Роль не найдена"));
    }
}

