package com.kolyadko_polovtseva.book_maze.config;

import com.kolyadko_polovtseva.book_maze.service.UserDetailsServiceImpl;
import com.kolyadko_polovtseva.book_maze.util.CloudinaryManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by DaryaKolyadko on 28.11.2016.
 */
@Configuration
@ComponentScan({"com.kolyadko_polovtseva.book_maze.*"})
@EnableJpaRepositories(basePackages = "com.kolyadko_polovtseva.book_maze.dao")
public class BeanConfig {
    @Bean
    public CloudinaryManager cloudinaryManager() {
        return new CloudinaryManager();
    }

    @Bean
    public UserDetailsServiceImpl customUserDetailsService() {
        return new UserDetailsServiceImpl();
    }


//    @Bean
//    public ShaPasswordEncoder passwordEncoder(){
//        return new ShaPasswordEncoder(256);
//    }
//    @Bean
//    public RedirectStrategy redirectStrategy() {
//        return new DefaultRedirectStrategy();
//    }
}