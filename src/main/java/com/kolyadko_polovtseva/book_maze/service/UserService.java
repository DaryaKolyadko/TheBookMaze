package com.kolyadko_polovtseva.book_maze.service;

import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.exception.ServiceException;

import java.util.List;

/**
 * Created by DaryaKolyadko on 09.12.2016.
 */
public interface UserService {
    User findByLoginAndPassword(String login, String password);

    User findByLogin(String login);

    void save(User user, String role) throws ServiceException;

    void save(User user);

    List<User> findAll();
}