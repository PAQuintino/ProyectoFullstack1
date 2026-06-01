package com.tienda.pedido_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseConfig {
    @Bean 
    public SpringLiquibase liquibase (DataSource dataSource){
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/db.changelog.sql");
        liquibase.setShouldRun(true);
        return liquibase;
    }
}
