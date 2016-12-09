package com.kolyadko_polovtseva.book_maze.service;

import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DaryaKolyadko on 08.12.2016.
 */
@Service//("customUserDetailsService")
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
//@EnableAspectJAutoProxy
public class CustomUserDetailsService implements UserDetailsService {
    private UserServiceImpl userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findUserByLogin(login);
        System.out.println("User : " + user);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        System.out.println("UserRole : " + user.getUserRole().getRoleName());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getUserRole().getRoleName()));
        System.out.print("authorities :" + authorities);
        return authorities;
    }

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}