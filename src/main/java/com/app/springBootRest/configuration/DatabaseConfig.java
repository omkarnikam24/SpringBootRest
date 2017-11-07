package com.app.springBootRest.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration	
@EntityScan(basePackages = {"com.app.springBootRest"})
@EnableJpaRepositories(basePackages = {"com.app.springBootRest"})
public class DatabaseConfig {

  @Value("${spring.datasource.driver_class}")
  private String DB_DRIVER;
  
  @Value("${spring.datasource.password}")
  private String DB_PASSWORD;
  
  @Value("${spring.datasource.url}")
  private String DB_URL;
  
  @Value("${spring.datasource.username}")
  private String DB_USERNAME;

  @Value("${spring.jpa.properties.hibernate.dialect}")
  private String HIBERNATE_DIALECT;
  
  @Value("${spring.jpa.show-sql}")
  private String HIBERNATE_SHOW_SQL;
  
  @Value("${spring.jpa.hibernate.ddl-auto}")
  private String HIBERNATE_HBM2DDL_AUTO;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(DB_DRIVER);
    dataSource.setUrl(DB_URL);
    dataSource.setUsername(DB_USERNAME);
    dataSource.setPassword(DB_PASSWORD);
    return dataSource;
  }

  @Bean
  JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(entityManagerFactory);
      return transactionManager;
  }
}
