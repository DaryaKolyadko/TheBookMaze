package com.kolyadko_polovtseva.book_maze.service.impl;

import com.kolyadko_polovtseva.book_maze.dao.UserRoleRepository;
import com.kolyadko_polovtseva.book_maze.entity.UserRole;
import com.kolyadko_polovtseva.book_maze.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by nadez on 11/27/2016.
 */
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole find(String roleName) {
        return userRoleRepository.findUserRoleByRoleName(roleName);
    }
}