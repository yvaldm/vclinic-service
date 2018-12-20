package com.yvaldm.vclinic.config;

import com.yvaldm.vclinic.dao.UserRegistrationDao;
import com.yvaldm.vclinic.dao.impl.UserRegistrationDaoImpl;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Data access configuration
 *
 * @author valeryyakovlev
 */
@Configuration
public class DataAccessConfig {

    @Bean
    public UserRegistrationDao userRegistrationDao(DSLContext dslContext) {
        return new UserRegistrationDaoImpl(dslContext);
    }

}
