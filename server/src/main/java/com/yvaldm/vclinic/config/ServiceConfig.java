package com.yvaldm.vclinic.config;

import com.yvaldm.vclinic.dao.UserDao;
import com.yvaldm.vclinic.dao.UserRegistrationDao;
import com.yvaldm.vclinic.service.UserService;
import com.yvaldm.vclinic.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * VClinic Application Configuration
 *
 * @author valeryyakovlev
 */
@Configuration
public class ServiceConfig {

    @Bean
    public UserService userService(UserRegistrationDao userRegistrationDao, UserDao userDao,
                                   PasswordEncoder passwordEncoder) {
        return new UserServiceImpl(userRegistrationDao, userDao, passwordEncoder);
    }
}
