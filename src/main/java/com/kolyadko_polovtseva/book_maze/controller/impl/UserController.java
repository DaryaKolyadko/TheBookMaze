package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.controller.AbstractController;
import com.kolyadko_polovtseva.book_maze.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DaryaKolyadko on 29.11.2016.
 */
@Controller
public class UserController extends AbstractController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/UserProfile/{login}", method = RequestMethod.GET)
    public ModelAndView userProfile(Model model, @PathVariable String login) {
        configureCloudinary(model);
        model.addAttribute("profile", userService.findByLogin(login));
        return new ModelAndView("userProfile");
    }

    @RequestMapping(value = "/EditProfile/{id}", method = RequestMethod.GET)
    public ModelAndView editProfile(Model model) {
        //TODO
        return new ModelAndView("lala");
    }
}