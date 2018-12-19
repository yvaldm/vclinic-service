package com.yvaldm.vclinic.config;

import com.yvaldm.vclinic.service.UserService;
import com.yvaldm.vclinic.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * VClinic Application Configuration
 *
 * @author valeryyakovlev
 */
@Configuration
public class VClinicConfig {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
