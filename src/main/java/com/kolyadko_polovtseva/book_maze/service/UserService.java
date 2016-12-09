package com.kolyadko_polovtseva.book_maze.service;

import com.kolyadko_polovtseva.book_maze.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by DaryaKolyadko on 09.12.2016.
 */
public interface UserService {
    User findUserByLoginAndPassword(String login, String password);
    User findUserByLogin(String login);
}