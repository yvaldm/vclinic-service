package com.yvaldm.vclinic.service.impl;

import com.yvaldm.vclinic.config.TestEmbeddedConfig;
import com.yvaldm.vclinic.dao.jooq.Tables;
import com.yvaldm.vclinic.dao.jooq.tables.records.UserRegistrationRecord;
import com.yvaldm.vclinic.service.UserService;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@Import({TestEmbeddedConfig.class})
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@WithMockUser
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DSLContext dslContext;

    @Test
    public void shouldCreateUserRegistrationRequest() {

        // act
        userService.signup("some@mail.ru", "s3cr3t");

        // assert
        UserRegistrationRecord userRegistrationRecord = dslContext.selectFrom(Tables.USER_REGISTRATION)
            .where(Tables.USER_REGISTRATION.EMAIL.eq("some@mail.ru"))
            .fetchOne();

        assertThat(userRegistrationRecord.getCode()).isNotNull();
        assertThat(userRegistrationRecord.getPassword()).isNotNull();
    }
}