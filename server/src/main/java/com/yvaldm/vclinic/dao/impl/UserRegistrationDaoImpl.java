package com.yvaldm.vclinic.dao.impl;

import com.yvaldm.vclinic.dao.UserRegistrationDao;
import org.jooq.DSLContext;

/**
 * Implementation of user registration data access object
 *
 * @author valeryyakovlev
 */
public class UserRegistrationDaoImpl implements UserRegistrationDao {

    private final DSLContext dslContext;

    public UserRegistrationDaoImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public void insert(String email, String pwdHash, int code) {

    }
}
