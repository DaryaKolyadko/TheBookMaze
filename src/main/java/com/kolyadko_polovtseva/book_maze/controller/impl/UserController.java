package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.controller.AbstractController;
import com.kolyadko_polovtseva.book_maze.util.CloudinaryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DaryaKolyadko on 29.11.2016.
 */
@Controller
public class UserController extends AbstractController {
    @RequestMapping(path = "UserProfile/{id}", method = RequestMethod.GET)
    public ModelAndView userProfile(Model model) {
        configureCloudinary(model);
        //TODO
        return new ModelAndView("userProfile");
    }

    @RequestMapping(path = "EditProfile/{id}", method = RequestMethod.GET)
    public ModelAndView editProfile(Model model) {
        //TODO
        return new ModelAndView("lala");
    }
}