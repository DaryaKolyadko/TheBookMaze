package com.kolyadko_polovtseva.book_maze.service;

/**
 * Created by DaryaKolyadko on 11.12.2016.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}