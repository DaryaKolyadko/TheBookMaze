package com.kolyadko_polovtseva.book_maze.config;

//import com.kolyadko_polovtseva.book_maze.handler.CustomSuccessHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by DaryaKolyadko on 26.11.2016.
 */
// springSecurityFilterChain
@Configuration
@EnableWebSecurity
@ComponentScan("com.kolyadko_polovtseva.book_maze.*")
public class SpringSecurityWebConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetails;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//.antMatchers("/**").permitAll()
                .antMatchers("/PublishHouses/**").access("hasRole('ADMIN')")
                .antMatchers("/Authors/**").access("hasRole('ADMIN')")
                .antMatchers("/Catalogue/AddBook").access("hasRole('ADMIN')")
                .antMatchers("/Catalogue/AddCategory").access("hasRole('ADMIN')")
                .antMatchers("/Users/**").access("hasRole('ADMIN')")
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
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter,CsrfFilter.class);
    }

    //    @Autowired
//    public void setCustomSuccessHandler(CustomSuccessHandler customSuccessHandler) {
//        this.customSuccessHandler = customSuccessHandler;
//    }
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public ShaPasswordEncoder passwordEncoder() {
        return new ShaPasswordEncoder(512);
    }

    @Autowired
    @Qualifier("customUserDetailsService")
    public void setUserDetails(UserDetailsService userDetails) {
        this.userDetails = userDetails;
    }
}