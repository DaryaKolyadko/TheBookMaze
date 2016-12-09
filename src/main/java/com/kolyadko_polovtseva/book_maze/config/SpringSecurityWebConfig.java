package com.kolyadko_polovtseva.book_maze.config;

//import com.kolyadko_polovtseva.book_maze.handler.CustomSuccessHandler;

import com.kolyadko_polovtseva.book_maze.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by DaryaKolyadko on 26.11.2016.
 */
// springSecurityFilterChain
@Configuration
@EnableWebSecurity
//@EnableAspectJAutoProxy
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Order(1)
public class SpringSecurityWebConfig extends WebSecurityConfigurerAdapter {
//    CustomSuccessHandler customSuccessHandler;

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("clary").password("clary").roles("USER");
//    }

    private CustomUserDetailsService userDetailsService;

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired           //   @Qualifier("customUserDetailsService")
    public void setUserDetailsService(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//.antMatchers("/**").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/UserProfile/**").access("isAuthenticated()")
                .antMatchers("/LogIn").access("isAnonymous()")
                .antMatchers("/SignUp").access("isAnonymous()")
                .and().formLogin().loginPage("/LogIn").loginProcessingUrl("/j_spring_security_check")
                .defaultSuccessUrl("/About").failureUrl("/LogIn?error")
                .usernameParameter("inputLogin").passwordParameter("inputPassword")
                .and().logout().logoutSuccessUrl("/About").logoutUrl("/j_spring_security_logout")
                .and().csrf().disable();
//                .and().exceptionHandling().accessDeniedPage("/AccessDenied");
//                .and().exceptionHandling().authenticationEntryPoint("/LogIn");
    }
    //    @Autowired
//    public void setCustomSuccessHandler(CustomSuccessHandler customSuccessHandler) {
//        this.customSuccessHandler = customSuccessHandler;
//    }
}