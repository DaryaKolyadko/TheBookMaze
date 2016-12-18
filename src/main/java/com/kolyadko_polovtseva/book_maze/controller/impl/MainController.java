package com.kolyadko_polovtseva.book_maze.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DaryaKolyadko on 27.11.2016.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/About", method = RequestMethod.GET)
    public String showAbout(Model model) {
        return "../../index";
    }
}