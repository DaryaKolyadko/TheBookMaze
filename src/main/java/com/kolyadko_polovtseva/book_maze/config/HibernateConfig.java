package com.kolyadko_polovtseva.book_maze.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@PropertySource(value = {"classpath:db.properties"})
public class HibernateConfig {
    private static final String DRIVER = "jdbc.driver";
    private static final String URL = "jdbc.url";
    private static final String USERNAME = "jdbc.username";
    private static final String PASSWORD = "jdbc.password";

    private Environment env;

    @Bean
    public BasicDataSource basicDataSource() {
        BasicDataSource boneCPDataSource = new BasicDataSource();
        boneCPDataSource.setDriverClassName(env.getProperty(DRIVER));
        boneCPDataSource.setUrl(env.getProperty(URL));
        boneCPDataSource.setUsername(env.getProperty(USERNAME));
        boneCPDataSource.setPassword(env.getProperty(PASSWORD));
//        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
        boneCPDataSource.setMaxIdle(420);
//        boneCPDataSource.setMaxConnectionsPerPartition(30);
//        boneCPDataSource.setMinConnectionsPerPartition(10);
//        boneCPDataSource.setPartitionCount(3);
//        boneCPDataSource.setAcquireIncrement(5);
//        boneCPDataSource.setStatementsCacheSize(100);
//        boneCPDataSource.setReleaseHelperThreads(3);

        return boneCPDataSource;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(BasicDataSource dataSource) {
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
//        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
//        properties.setProperty("hibernate.cache.use_query_cache", "true");
//        properties.setProperty("hibernate.generate_statistics", "true");
        factory.setJpaProperties(properties);
        factory.afterPropertiesSet();
        return factory.getObject();
        //TODO move to properties
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        JpaDialect jpaDialect = new HibernateJpaDialect();
        txManager.setEntityManagerFactory(entityManagerFactory);
        txManager.setJpaDialect(jpaDialect);
        return txManager;
    }


    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }
}