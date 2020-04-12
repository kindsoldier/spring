/*
 *  * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 */

package org.unix7.spring;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Configuration
@ComponentScan("org.unix7.spring")
public class JdbcConfig {

    @Bean
    public DataSource dataSource() {

//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/spring");
//        dataSource.setUsername("spring");
//        dataSource.setPassword("12345");

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/spring");
        dataSourceBuilder.username("spring");
        dataSourceBuilder.password("12345");
        DataSource dataSource = dataSourceBuilder.build();
        System.out.println("*** JDBC ***");
        return dataSource;
    }
}
