package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DaryaKolyadko on 28.11.2016.
 */
@Controller
public class SearchController extends AbstractController {
    @RequestMapping(path = "Search", method = RequestMethod.GET)
    public ModelAndView showSearch() {
        return new ModelAndView("search");
    }

    @RequestMapping(path = "Search", method = RequestMethod.POST)
    public ModelAndView search(Model model) {
        //TODO params
        return new ModelAndView("bookList");
    }
}