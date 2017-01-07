//package com.kolyadko_polovtseva.book_maze.main;
//
//import com.kolyadko_polovtseva.book_maze.search.LuceneUtil;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
///**
// * Created by nadez on 11/24/2016.
// */
//
//@SpringBootApplication
////@EnableAutoConfiguration
//@EnableWebMvc
//@ComponentScan("com.kolyadko_polovtseva.book_maze")
//@EnableJpaRepositories("com.kolyadko_polovtseva.book_maze.dao")
//@EntityScan("com.kolyadko_polovtseva.book_maze.entity")
//public class Main extends SpringBootServletInitializer {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Main.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(Main.class, args);
//        new LuceneUtil().prepare();
//    }
//}