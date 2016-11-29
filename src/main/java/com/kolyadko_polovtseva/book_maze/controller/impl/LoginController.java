package com.kolyadko_polovtseva.book_maze.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DaryaKolyadko on 29.11.2016.
 */
@Controller
public class LoginController {
    @RequestMapping(path = "LogIn", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        return new ModelAndView("login");
    }

    @RequestMapping(path = "LogIn", method = RequestMethod.POST)
    public ModelAndView login(Model model) {
        //TODO
        return new ModelAndView("lala");
    }

    @RequestMapping(path = "LogOut", method = RequestMethod.GET)
    public ModelAndView logOut() {
        //TODO
        return new ModelAndView("../../index");
    }
}