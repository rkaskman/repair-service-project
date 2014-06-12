package com.ttu.roman;

import org.junit.runner.RunWith;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.activation.DataSource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebAppConfiguration
@ContextConfiguration
@Configuration
@ComponentScan
public class TestContext {

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        return  Persistence.createEntityManagerFactory("userPersistenceUnit");
    }

    @Bean
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());

        return transactionManager;
    }

    //not used in tests
    @Bean
    public javax.sql.DataSource dataSource() {
        return new PGSimpleDataSource();
    }

}
