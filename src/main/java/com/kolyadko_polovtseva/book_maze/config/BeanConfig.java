package com.kolyadko_polovtseva.book_maze.config;

import com.kolyadko_polovtseva.book_maze.util.CloudinaryManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by DaryaKolyadko on 28.11.2016.
 */
@Configuration
public class BeanConfig {
    @Bean
    public CloudinaryManager cloudinaryManager() {
        return new CloudinaryManager();
    }
}