package com.yvaldm.vclinic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for login
 *
 * @author valery.yakovlev
 */
@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

//    private final Facebook facebook;

    @GetMapping("/")
    public void home() {

//        logger.info("auth info: {}" + facebook.getProfile().getId(), facebook.getProfile().getName());

        System.out.println("test");
    }
}
