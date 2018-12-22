package com.yvaldm.vclinic.service.impl;

import com.google.common.hash.Hashing;
import com.yvaldm.vclinic.dao.UserDao;
import com.yvaldm.vclinic.dao.UserRegistrationDao;
import com.yvaldm.vclinic.entity.UserRegistration;
import com.yvaldm.vclinic.exceptions.NotFoundException;
import com.yvaldm.vclinic.service.UserService;

import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @author valeryyakovlev
 */
public class UserServiceImpl implements UserService {

    private final UserRegistrationDao userRegistrationDao;
    private final UserDao userDao;

    private final static Random RANDOM = new Random();

    public UserServiceImpl(UserRegistrationDao userRegistrationDao, UserDao userDao) {
        this.userRegistrationDao = userRegistrationDao;
        this.userDao = userDao;
    }

    @Override
    public void signup(String email, String password) {
        int code = RANDOM.nextInt(999999);
        String hash = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
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
