package com.zaroyan.springsecurityjwtex2.repositories;

import com.zaroyan.springsecurityjwtex2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Zaroyan
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String roleName);
}
