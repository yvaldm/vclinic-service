package com.yvaldm.vclinic.dao.impl;

import com.yvaldm.vclinic.dao.UserDao;
import com.yvaldm.vclinic.dao.jooq.Tables;
import org.jooq.DSLContext;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private final DSLContext dslContext;

    public UserDaoImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public void insert(String email, String password) {
        dslContext.insertInto(Tables.USER_BASIC)
            .set(Tables.USER_BASIC.EMAIL, email)
            .set(Tables.USER_BASIC.PASSWORD, password)
            .execute();
    }

    @Override
    public Optional<User> find(String email) {

        return dslContext.selectFrom(Tables.USER_BASIC)
            .where(Tables.USER_BASIC.EMAIL.eq(email))
            .fetchOptional(u -> new User(u.getEmail(), u.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE"))));
    }
}
