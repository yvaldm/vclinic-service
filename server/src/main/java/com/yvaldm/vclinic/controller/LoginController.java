package com.yvaldm.vclinic.controller;

import com.yvaldm.vclinic.facebook.Facebook;
import com.yvaldm.vclinic.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

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

//    @GetMapping("/")
//    public void home() {
//
//        logger.info("auth info: {}" + facebook.getProfile().getId(), facebook.getProfile().getName());
//    }
////
//    @GetMapping("/login")
//    public void login() {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        OAuth2AuthenticationToken auth = (OAuth2AuthenticationToken) authentication;
//        Profile profile = facebook.getProfile();
//
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        Object principal = authentication.getPrincipal();
//
//
//        //userService.authenticate()
//
//
//        System.out.println("fff");
//    }
}
