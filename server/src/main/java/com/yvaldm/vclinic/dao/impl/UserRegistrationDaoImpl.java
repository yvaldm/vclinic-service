package com.yvaldm.vclinic.dao.impl;

import com.yvaldm.vclinic.dao.UserRegistrationDao;
import com.yvaldm.vclinic.dao.jooq.Tables;
import com.yvaldm.vclinic.entity.UserRegistration;
import org.jooq.DSLContext;

import java.util.Optional;

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

    @Override
    public Optional<UserRegistration> findByEmail(String email) {

        return dslContext.selectFrom(Tables.USER_REGISTRATION)
            .where(Tables.USER_REGISTRATION.EMAIL.eq(email))
            .fetchOptionalInto(UserRegistration.class);
    }

    @Override
    public void delete(long id) {

        dslContext.deleteFrom(Tables.USER_REGISTRATION)
            .where(Tables.USER_REGISTRATION.ID.eq(id))
            .execute();
    }
}
