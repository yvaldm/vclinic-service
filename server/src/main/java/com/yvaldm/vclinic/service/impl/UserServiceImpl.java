package com.yvaldm.vclinic.service.impl;

import com.google.common.hash.Hashing;
import com.yvaldm.vclinic.dao.UserRegistrationDao;
import com.yvaldm.vclinic.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @author valeryyakovlev
 */
public class UserServiceImpl implements UserService {

    private final UserRegistrationDao userRegistrationDao;

    private final static Random RANDOM = new Random();

    public UserServiceImpl(UserRegistrationDao userRegistrationDao) {
        this.userRegistrationDao = userRegistrationDao;
    }

    @Override
    @Transactional
    public void signup(String email, String password) {
        int code = RANDOM.nextInt(999999);
        String hash = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        userRegistrationDao.insert(email, hash, code);
    }
}
