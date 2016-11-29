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
public class SignUpController {
    @RequestMapping(path = "SignUp", method = RequestMethod.GET)
    public ModelAndView showSignUp() {
        return new ModelAndView("signUp");
    }

    @RequestMapping(path = "SignUp", method = RequestMethod.POST)
    public ModelAndView signUp(Model model)  {
        //TODO
        return new ModelAndView("lala");
    }
}