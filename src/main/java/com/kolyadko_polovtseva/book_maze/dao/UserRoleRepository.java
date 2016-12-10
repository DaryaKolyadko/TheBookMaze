package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.entity.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nadez on 12/3/2016.
 */

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
    UserRole findUserRoleByRoleName(String roleName);
}