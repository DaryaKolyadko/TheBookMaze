package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.controller.AbstractController;
import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.service.BookService;
import com.kolyadko_polovtseva.book_maze.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DaryaKolyadko on 28.11.2016.
 */
@Controller
public class BookController extends AbstractController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @RequestMapping(value = "/Catalogue/Category/{category}/Book/{book}", method = RequestMethod.GET)
    public ModelAndView getBook(Model model, @PathVariable Integer category,
                                     @PathVariable Integer book) {
        configureCloudinary(model);
        Book currentBook = bookService.findBookByCategoryAndBookId(categoryService.findById(category), book);
        model.addAttribute("book", currentBook);
        return new ModelAndView("bookProfile");
    }

    @RequestMapping(value = "/UserProfile/{login}/Reserved", method = RequestMethod.GET)
    public ModelAndView getReservedBooks(Model model, @PathVariable String login) {
        configureCloudinary(model);
        //TODO
        return new ModelAndView("bookList");
    }

    @RequestMapping(value = "/Catalogue/Category/{category}/Book/{book}/Reserve", method = RequestMethod.POST)
    public ModelAndView reserveBook(Model model, @PathVariable Integer category,
                                    @PathVariable Integer book) {
        configureCloudinary(model);
        //TODO
        return new ModelAndView("bookProfile");
    }


    @RequestMapping(value = "/admin/Book/Add", method = RequestMethod.GET)
    public ModelAndView showAddBook(Model model) {
        configureCloudinary(model);
        //TODO
        return new ModelAndView("bookProfile");
    }

    @RequestMapping(value = "/admin/Book/Add", method = RequestMethod.POST)
    public ModelAndView addBook(Model model) {
        configureCloudinary(model);
        //TODO
        return new ModelAndView("bookProfile");
    }
}