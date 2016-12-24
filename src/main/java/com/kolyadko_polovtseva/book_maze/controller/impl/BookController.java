package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.controller.AbstractController;
import com.kolyadko_polovtseva.book_maze.converter.BookDtoToBookConverter;
import com.kolyadko_polovtseva.book_maze.dto.BookDto;
import com.kolyadko_polovtseva.book_maze.dto.ReserveBookDto;
import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import com.kolyadko_polovtseva.book_maze.entity.RegisterRecord;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.service.*;
import com.kolyadko_polovtseva.book_maze.util.DateUtil;
import com.kolyadko_polovtseva.book_maze.validator.BookValidator;
import com.kolyadko_polovtseva.book_maze.validator.ReserveBookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Date;
import java.util.List;

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

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("authorServiceImpl")
    private AuthorService authorService;

    @Autowired
    @Qualifier("publishHouseServiceImpl")
    private PublishHouseService publishHouseService;

    @Autowired
    @Qualifier("registerRecordServiceImpl")
    private RegisterRecordService registerRecordService;

    @Autowired
    private ReserveBookValidator reserveBookValidator;

    @Autowired
    private BookValidator bookValidator;

    @Autowired
    private BookDtoToBookConverter bookDtoToBookConverter;

    @Autowired
    @Qualifier("libraryBookServiceImpl")
    private LibraryBookService libraryBookService;

    @RequestMapping(value = "/Catalogue/Category/{category}/Book/{book}", method = RequestMethod.GET)
    public String getBook(Model model, @PathVariable Integer category,
                          @PathVariable Integer book, Principal principal) {
        configureCloudinary(model);
        Book currentBook = bookService.findBookByCategoryIdAndBookId(category, book);
        model.addAttribute("book", currentBook);
        LibraryBook libraryBook = libraryBookService.findAvailableFor(currentBook);

        if (libraryBook != null) {
            model.addAttribute("libraryBook", new ReserveBookDto(libraryBook.getIdLibraryBook()));
        }

        if (principal != null) {
            model.addAttribute("profile", userService.findByLogin(principal.getName()));
        }

        boolean available = registerRecordService.isLibraryBookAvailable(libraryBook);
        model.addAttribute("available", available);
        return "bookProfile";
    }

    @RequestMapping(value = "/UserProfile/{login}/Reserved", method = RequestMethod.GET)
    public String getReservedBooks(Model model, @PathVariable String login) {
        configureCloudinary(model);
        User user = userService.findByLogin(login);
        List<RegisterRecord> reserved = registerRecordService.findByUser(user);
        model.addAttribute("reservedList", reserved);
        model.addAttribute("profile", user);
        return "reservedBookList";
    }

    @RequestMapping(value = "/Catalogue/Category/{category}/Book/{book}/Reserve", method = RequestMethod.POST)
    public String reserveBook(Model model, @ModelAttribute("libraryBook")
            ReserveBookDto reserveBook, BindingResult bindingResult, Principal principal) {
        reserveBookValidator.validate(reserveBook, bindingResult);

        if (bindingResult.hasErrors()) {
            return "../../index";
        }

        configureCloudinary(model);
        User user = userService.findByLogin(principal.getName());
        LibraryBook libraryBook = bookService.findLibraryBook(reserveBook.getLibraryBookId());
        RegisterRecord registerRecord = new RegisterRecord();
        registerRecord.setUser(user);
        registerRecord.setLibraryBook(libraryBook);
        registerRecord.setReserveDate(new Date());
        registerRecord.setReturnDeadline(DateUtil.addDays(new Date(), BookService.RESERVE_PERIOD));
        registerRecord.setWasReturned(false);
        registerRecord = registerRecordService.save(registerRecord);

        if (registerRecord.getIdRegister() != null) {
            return "redirect:/UserProfile/" + user.getLogin() + "/Reserved";
        }

        bindingResult.rejectValue("error", "ReservationError");
        model.addAttribute("book", libraryBook.getBook());
        return "bookProfile";
    }

    @RequestMapping(value = "/Catalogue/AddBook", method = RequestMethod.GET)
    public ModelAndView showAddBook(Model model) {
        configureCloudinary(model);
        model.addAttribute("bookForm", new BookDto());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("publishHouses", publishHouseService.findAll());
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("libraryBooks", libraryBookService.findAll());
        return new ModelAndView("addBook");
    }

    @RequestMapping(value = "/Catalogue/AddBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("bookForm") BookDto bookDto,
                          BindingResult bindingResult, Model model) {
        bookValidator.validate(bookDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("publishHouses", publishHouseService.findAll());
            model.addAttribute("authors", authorService.findAll());
            model.addAttribute("libraryBooks", libraryBookService.findAll());
            return "addBook";
        }

        Book book = bookDtoToBookConverter.convertFromDto(bookDto);
        bookService.save(book);
        return "redirect:/Catalogue";
    }
}