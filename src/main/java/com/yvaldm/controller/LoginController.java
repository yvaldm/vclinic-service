package com.yvaldm.controller;

import com.yvaldm.util.social.facebook.Facebook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final Facebook facebook;

    @Autowired
    public LoginController(Facebook facebook) {
        this.facebook = facebook;
    }

    @GetMapping("/")
    public void home() {

        logger.info("auth info: {}" + facebook.getProfile().getId(), facebook.getProfile().getName());
    }
}
