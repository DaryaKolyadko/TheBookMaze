package com.kolyadko_polovtseva.book_maze.config;

import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@Transactional
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private UserService userService;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findByLogin(login);

        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }

        System.out.println("User : " + user.getLogin());
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
    @Qualifier("userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}