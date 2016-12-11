package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.controller.AbstractController;
import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

/**
 * Created by DaryaKolyadko on 28.11.2016.
 */
@Controller
public class CategoryController extends AbstractController {
    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @RequestMapping(value = "/Catalogue/Category/{idCategory}", method = RequestMethod.GET)
    public ModelAndView getCatalogue(Model model, @PathVariable Integer idCategory) {
        configureCloudinary(model);
        Category category = categoryService.findById(idCategory);
        model.addAttribute("category", category);
        return new ModelAndView("bookList");
    }
}