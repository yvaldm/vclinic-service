package com.yvaldm.vclinic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvaldm.vclinic.api.SignupRequest;
import com.yvaldm.vclinic.config.TestEmbeddedConfig;
import com.yvaldm.vclinic.dao.jooq.Tables;
import com.yvaldm.vclinic.dao.jooq.tables.records.UserRegistrationRecord;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Import({TestEmbeddedConfig.class})
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@WithMockUser
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DSLContext dslContext;

    @Test
    public void shouldCreateRegistrationApplication() throws Exception {

        // arrange
        String body = objectMapper.writeValueAsString(new SignupRequest("sample@mail.ru", "qwerty"));

        // act
        mvc.perform(post("/user/signup")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(body))
            .andExpect(status().isOk());

        // assert
        UserRegistrationRecord rec = dslContext.selectFrom(Tables.USER_REGISTRATION)
            .where(Tables.USER_REGISTRATION.EMAIL.eq("sample@mail.ru"))
            .fetchOne();
        assertThat(rec.getCode()).isNotNull();
    }
//
//    @Test
//    public void shouldConfirmRegistration() throws Exception {
//
//
//    }
}