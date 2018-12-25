package com.yvaldm.vclinic.config;

import com.yvaldm.vclinic.dao.UserDao;
import com.yvaldm.vclinic.service.impl.UserDetailsServiceImpl;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
            .disable();

        http.authorizeRequests()
            .antMatchers("/user/signup", "/user/signup/confirm", "/login", "/login_process")
            .permitAll()
            .and()
            .formLogin()
            //.loginPage("/login.html")
            .loginProcessingUrl("/login_process")
            .defaultSuccessUrl("http://localhost:4200/home")
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .logout()
            .permitAll();
    }

    @Bean
    public UserDetailsService userDetailsService(UserDao userDao) {
        return new UserDetailsServiceImpl(userDao);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
