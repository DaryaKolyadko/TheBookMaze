package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.controller.AbstractController;
import com.kolyadko_polovtseva.book_maze.dto.SearchQueryDto;
import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.search.LuceneIndexBuilder;
import com.kolyadko_polovtseva.book_maze.search.LuceneSearch;
import com.kolyadko_polovtseva.book_maze.service.BookService;
import com.kolyadko_polovtseva.book_maze.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DaryaKolyadko on 28.11.2016.
 */
@Controller
public class SearchController extends AbstractController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @RequestMapping(value = "/Search", method = RequestMethod.GET)
    public String showSearch(Model model) {
        model.addAttribute("searchForm", new SearchQueryDto());
        model.addAttribute("categories", categoryService.findAll());
        return "search";
    }

    @RequestMapping(value = "/SearchAction", method = RequestMethod.POST)
    public String search(@ModelAttribute("searchForm") SearchQueryDto searchQueryDto,
                         BindingResult bindingResult, Model model) {
        configureCloudinary(model);
        Iterable<Book> result = bookService.search(searchQueryDto);
        model.addAttribute("books", result);
        model.addAttribute("searchQuery", searchQueryDto);
        return "searchResult";
    }
}