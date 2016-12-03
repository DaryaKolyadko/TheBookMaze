package com.kolyadko_polovtseva.book_maze.config;

import com.kolyadko_polovtseva.book_maze.util.CloudinaryManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;

/**
 * Created by DaryaKolyadko on 28.11.2016.
 */
//@EnableWebMvc
@Configuration
//@Import({ SecurityConfig.class })
@ComponentScan({"com.kolyadko_polovtseva.book_maze.*"})
public class BeanConfig {
    @Bean
    public CloudinaryManager cloudinaryManager() {
        return new CloudinaryManager();
    }

//    @Bean
//    public RedirectStrategy redirectStrategy() {
//        return new DefaultRedirectStrategy();
//    }
}