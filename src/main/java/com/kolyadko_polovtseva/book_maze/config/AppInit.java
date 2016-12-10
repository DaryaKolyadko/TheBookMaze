package com.kolyadko_polovtseva.book_maze.config;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

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
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new DelegatingFilterProxy("springSecurityFilterChain"),
                new OpenEntityManagerInViewFilter()};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}