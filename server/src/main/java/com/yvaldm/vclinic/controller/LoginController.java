package com.yvaldm.vclinic.controller;

import com.yvaldm.vclinic.facebook.Facebook;
import com.yvaldm.vclinic.facebook.Profile;
import com.yvaldm.vclinic.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Controller responsible for login
 *
 * @author valery.yakovlev
 */
@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final Facebook facebook;
    private final UserService userService;

    public LoginController(Facebook facebook, UserService userService) {
        this.facebook = facebook;
        this.userService = userService;
    }

    @GetMapping("/")
    public void home() {

        logger.info("auth info: {}" + facebook.getProfile().getId(), facebook.getProfile().getName());
    }

    @GetMapping("/login")
    public void login() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationToken auth = (OAuth2AuthenticationToken) authentication;
        Profile profile = facebook.getProfile();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Object principal = authentication.getPrincipal();


        //userService.authenticate()


        System.out.println("fff");
    }
}
