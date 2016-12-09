package com.kolyadko_polovtseva.book_maze.config;

//import com.kolyadko_polovtseva.book_maze.handler.CustomSuccessHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
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
public class SpringSecurityWebConfig extends WebSecurityConfigurerAdapter {
//    CustomSuccessHandler customSuccessHandler;

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("clary").password("clary").roles("USER");
//    }

    private UserDetailsService userDetailsService;

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

    @Autowired
    @Qualifier("customUserDetailsService")
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    //    @Autowired
//    public void setCustomSuccessHandler(CustomSuccessHandler customSuccessHandler) {
//        this.customSuccessHandler = customSuccessHandler;
//    }
}