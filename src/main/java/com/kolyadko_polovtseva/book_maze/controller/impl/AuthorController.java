package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.controller.AbstractController;
import com.kolyadko_polovtseva.book_maze.entity.Author;
import com.kolyadko_polovtseva.book_maze.service.AuthorService;
import com.kolyadko_polovtseva.book_maze.validator.AuthorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DaryaKolyadko on 28.11.2016.
 */
@Controller
public class AuthorController extends AbstractController {
    @Autowired
    @Qualifier("authorServiceImpl")
    private AuthorService authorService;

    @Autowired
    private AuthorValidator authorValidator;

    @RequestMapping(value = "/Authors", method = RequestMethod.GET)
    public String showAuthors(Model model) {
        configureCloudinary(model);
        model.addAttribute("authors", authorService.findAll());
        return "authorsList";
    }

    @RequestMapping(value = "/Authors/DeleteAuthor/{idAuthor}", method = RequestMethod.POST)
    public String deleteAuthor(@PathVariable Integer idAuthor, Model model) {
        authorService.deleteById(idAuthor);
        return "redirect:/Authors";
    }

    @RequestMapping(value = "/Authors/AddAuthor", method = RequestMethod.GET)
    public String showAddAuthor(Model model) {
        model.addAttribute("authorForm", new Author());
        return "addAuthor";
    }

    @RequestMapping(value = "/Authors/AddAuthor", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute("authorForm") Author author,
                            BindingResult bindingResult, Model model) {
        authorValidator.validate(author, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addAuthor";
        }

        authorService.save(author);
        return "redirect:/Authors";
    }

    @RequestMapping(value = "/Authors/EditAuthor/{idAuthor}", method = RequestMethod.GET)
    public String showEditAuthor(@PathVariable Integer idAuthor, Model model) {
        model.addAttribute("authorForm", authorService.findById(idAuthor));
        return "editAuthor";
    }

    @RequestMapping(value = "/Authors/EditAuthor", method = RequestMethod.POST)
    public String editAuthor(@ModelAttribute("authorForm") Author author,
                            BindingResult bindingResult, Model model) {
        authorValidator.validate(author, bindingResult);

        if (bindingResult.hasErrors()) {
            return "editAuthor";
        }

        authorService.save(author);
        return "redirect:/Authors";
    }
}