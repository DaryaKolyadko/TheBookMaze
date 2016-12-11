package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.controller.AbstractController;
import com.kolyadko_polovtseva.book_maze.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DaryaKolyadko on 28.11.2016.
 */
@Controller
public class CatalogueController extends AbstractController {
    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @RequestMapping(value = "/Catalogue", method = RequestMethod.GET)
    public ModelAndView getCatalogue(Model model) {
        configureCloudinary(model);
        model.addAttribute("categories", categoryService.findAll());
        return new ModelAndView("catalogue");
    }
}