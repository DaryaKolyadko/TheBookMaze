package com.kolyadko_polovtseva.book_maze.service.impl;

import com.kolyadko_polovtseva.book_maze.dao.UserRepository;
import com.kolyadko_polovtseva.book_maze.dao.UserRoleRepository;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.entity.UserRole;
import com.kolyadko_polovtseva.book_maze.exception.ServiceException;
import com.kolyadko_polovtseva.book_maze.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DaryaKolyadko on 09.12.2016.
 */
@Transactional
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return userRepository.findUserByLoginAndPassword(login, password);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findOne(login);
    }

    @Override
    public void save(User user, String role) throws ServiceException {
        UserRole userRole = userRoleRepository.findUserRoleByRoleName(role);
        user.setUserRole(userRole);
        user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
        userRepository.save(user);
    }
}