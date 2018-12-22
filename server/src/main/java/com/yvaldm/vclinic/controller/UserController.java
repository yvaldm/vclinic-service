package com.yvaldm.vclinic.controller;

import com.yvaldm.vclinic.api.SignupRequest;
import com.yvaldm.vclinic.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller for registration of new users
 *
 * @author valeryyakovlev
 */
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/signup")
    public void signup(@RequestBody @Valid SignupRequest request) {
        userService.signup(request.getEmail(), request.getPassword());
    }

    @GetMapping("/user/signup/confirm")
    public void confirm(@RequestParam String email, @RequestParam int code) {
        userService.confirm(email, code);
    }
}
