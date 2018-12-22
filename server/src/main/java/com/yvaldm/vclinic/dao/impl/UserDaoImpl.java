package com.yvaldm.vclinic.dao.impl;

import com.yvaldm.vclinic.dao.UserDao;
import org.jooq.DSLContext;

public class UserDaoImpl implements UserDao {

    private final DSLContext dslContext;

    public UserDaoImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public void insert(String email, String password) {
        //dslContext.insertInto(Tables.US)
    }
}
