package com.zaroyan.springsecurityjwtex2.repositories;

import com.zaroyan.springsecurityjwtex2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Zaroyan
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
