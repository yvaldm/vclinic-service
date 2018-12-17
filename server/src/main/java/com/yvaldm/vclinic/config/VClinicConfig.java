package com.yvaldm.vclinic.config;

import com.yvaldm.vclinic.service.UserService;
import com.yvaldm.vclinic.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * VClinic Application Configuration
 *
 * @author valeryyakovlev
 */
@Configuration
@EnableWebSecurity
public class VClinicConfig {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
