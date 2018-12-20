package com.yvaldm.vclinic.dao;

/**
 * User registration data access object interface
 *
 * @author valeryyakovlev
 */
public interface UserRegistrationDao {

    void insert(String email, String pwdHash, int code);
}
