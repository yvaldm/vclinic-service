package com.yvaldm.vclinic.dao.impl;

import com.yvaldm.vclinic.dao.UserRegistrationDao;
import com.yvaldm.vclinic.dao.jooq.Tables;
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

        dslContext.insertInto(Tables.USER_REGISTRATION)
            .set(Tables.USER_REGISTRATION.CODE, code)
            .set(Tables.USER_REGISTRATION.EMAIL, email)
            .set(Tables.USER_REGISTRATION.PASSWORD, pwdHash)
            .execute();
    }
}
