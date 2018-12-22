package com.yvaldm.vclinic.dao;

import com.yvaldm.vclinic.entity.UserRegistration;

import java.util.Optional;

/**
 * User registration data access object interface
 *
 * @author valeryyakovlev
 */
public interface UserRegistrationDao {

    void insert(String email, String pwdHash, int code);

    Optional<UserRegistration> findByEmail(String email);
}
