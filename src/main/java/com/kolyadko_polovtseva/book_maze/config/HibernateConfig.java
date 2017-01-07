package com.kolyadko_polovtseva.book_maze.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

/**
 * Created by DaryaKolyadko on 03.12.2016.
 */

@Configuration
@EnableTransactionManagement
@ImportResource("classpath:/core-app-context.xml")
@PropertySource(value = {"classpath:db.properties"})
public class HibernateConfig {
//    private static final String DRIVER = "jdbc.driver";
//    private static final String URL = "jdbc.url";
//    private static final String USERNAME = "jdbc.username";
//    private static final String PASSWORD = "jdbc.password";
//
//    private Environment env;
//
//    @Bean
//    public DriverManagerDataSource basicDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty(DRIVER));
//        dataSource.setUrl(env.getProperty(URL));
//        dataSource.setUsername(env.getProperty(USERNAME));
//        dataSource.setPassword(env.getProperty(PASSWORD));
////        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
////        boneCPDataSource.setMaxIdle(420);
////        boneCPDataSource.
////        boneCPDataSource.setMaxConnectionsPerPartition(30);
////        boneCPDataSource.setMinConnectionsPerPartition(10);
////        boneCPDataSource.setPartitionCount(3);
////        boneCPDataSource.setAcquireIncrement(5);
////        boneCPDataSource.setStatementsCacheSize(100);
////        boneCPDataSource.setReleaseHelperThreads(3);
//        return dataSource;
//    }

//    @Bean
//    public HibernateExceptionTranslator hibernateExceptionTranslator() {
//        return new HibernateExceptionTranslator();
//    }
//
    @Bean
    @Qualifier("entityManagerFactory")
    public EntityManagerFactory entityManagerFactory(@Qualifier("dataSource") DriverManagerDataSource dataSource) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");//env.getProperty(HIBERNATE_DIALECT));
        vendorAdapter.setDatabase(Database.MYSQL);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.kolyadko_polovtseva.book_maze.entity");
        factory.setDataSource(dataSource);
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.connection.characterEncoding", "UTF-8");
//        properties.setProperty("hibernate.connection.CharSet", "utf8");
        properties.setProperty("hibernate.connection.useUnicode", "yes");
//        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
//        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
//        properties.setProperty("hibernate.cache.use_query_cache", "true");
//        properties.setProperty("hibernate.generate_statistics", "true");
        factory.setJpaProperties(properties);
        factory.afterPropertiesSet();
        return factory.getObject();
        //TODO move to properties
    }

//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        JpaDialect jpaDialect = new HibernateJpaDialect();
//        txManager.setEntityManagerFactory(entityManagerFactory);
//        txManager.setJpaDialect(jpaDialect);
//        return txManager;
//    }

//
//    @Autowired
//    public void setEnv(Environment env) {
//        this.env = env;
//    }
}