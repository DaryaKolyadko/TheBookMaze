package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.dao.LibraryBookRepository;
import com.kolyadko_polovtseva.book_maze.dao.RegisterRecordRepository;
import com.kolyadko_polovtseva.book_maze.dao.UserRepository;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import com.kolyadko_polovtseva.book_maze.entity.RegisterRecord;
import com.kolyadko_polovtseva.book_maze.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DaryaKolyadko on 29.11.2016.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/LogIn", method = RequestMethod.GET)
    public ModelAndView showLogin() {

        return new ModelAndView("login");
    }

    @RequestMapping(value = "/LogIn", method = RequestMethod.POST)
    public ModelAndView login(Model model) {
        //TODO
        return new ModelAndView("lala");
    }

    @RequestMapping(value = "/LogOut", method = RequestMethod.GET)
    public ModelAndView logOut() {
        //TODO
        return new ModelAndView("../../index");
    }
}