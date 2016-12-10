package com.kolyadko_polovtseva.book_maze.service;

import com.kolyadko_polovtseva.book_maze.entity.UserRole;

/**
 * Created by nadez on 11/27/2016.
 */
public interface UserRoleService {
    UserRole find(String roleName);
}
