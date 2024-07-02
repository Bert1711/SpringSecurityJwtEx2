package com.zaroyan.springsecurityjwtex2.services;

import com.zaroyan.springsecurityjwtex2.dto.UserDto;
import com.zaroyan.springsecurityjwtex2.entity.User;
import com.zaroyan.springsecurityjwtex2.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * @author Zaroyan
 */

@Service
@Slf4j
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public String register(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        log.info("Пользователь успешно зарегистрирован.");
        return "Пользователь успешно зарегистрирован.";
    }
}
