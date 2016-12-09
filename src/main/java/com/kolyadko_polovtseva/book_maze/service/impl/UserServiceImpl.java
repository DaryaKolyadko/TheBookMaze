package com.kolyadko_polovtseva.book_maze.service.impl;

import com.kolyadko_polovtseva.book_maze.dao.UserDao;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DaryaKolyadko on 09.12.2016.
 */
@Component//("userService")
@Transactional
//@EnableAspectJAutoProxy
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        return userDao.findUserByLoginAndPassword(login, password);
    }

    @Override
    public User findUserByLogin(String login) {
        return userDao.findOne(login);
    }

    @Autowired
    //@Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}