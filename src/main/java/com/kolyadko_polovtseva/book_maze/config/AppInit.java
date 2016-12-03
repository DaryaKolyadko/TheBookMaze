package com.kolyadko_polovtseva.book_maze.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by DaryaKolyadko on 26.11.2016.
 */
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{BeanConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
//        return new Class<?>[]{
//                BeanConfig.class
//        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}