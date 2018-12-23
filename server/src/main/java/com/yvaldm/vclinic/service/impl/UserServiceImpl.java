package com.yvaldm.vclinic.service.impl;

import com.yvaldm.vclinic.dao.UserDao;
import com.yvaldm.vclinic.dao.UserRegistrationDao;
import com.yvaldm.vclinic.entity.UserRegistration;
import com.yvaldm.vclinic.exceptions.NotFoundException;
import com.yvaldm.vclinic.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

/**
 * @author valeryyakovlev
 */
public class UserServiceImpl implements UserService {

    private final static Random RANDOM = new Random();

    private final UserRegistrationDao userRegistrationDao;
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRegistrationDao userRegistrationDao, UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userRegistrationDao = userRegistrationDao;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signup(String email, String password) {
        int code = RANDOM.nextInt(999999);
        String hash = passwordEncoder.encode(password);
        userRegistrationDao.insert(email, hash, code);
    }

    @Override
    public void confirm(String email, int code) {

        UserRegistration userRegistration = userRegistrationDao
            .findByEmail(email)
            .orElseThrow(NotFoundException::userRegistrationNotFound);

        if (userRegistration.getCode() == code) {
            userDao.insert(userRegistration.getEmail(), userRegistration.getPassword());
            userRegistrationDao.delete(userRegistration.getId());
        } else {
            throw new RuntimeException("Incorrect code");
        }
    }
}
