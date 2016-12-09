package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DaryaKolyadko on 09.12.2016.
 */
@Repository//("userDao")
public interface UserDao extends CrudRepository<User, String> {
    User findUserByLoginAndPassword(String login, String password);
}