package com.kolyadko_polovtseva.book_maze.restcontroller;

import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import com.kolyadko_polovtseva.book_maze.entity.RegisterRecord;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.service.BookService;
import com.kolyadko_polovtseva.book_maze.service.RegisterRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by nadez on 12/4/2016.
 */
@RestController
public class BookRestController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @Autowired
    @Qualifier("registerRecordServiceImpl")
    private RegisterRecordService registerRecordService;


    @RequestMapping(method = RequestMethod.POST, value = "/books/category")
    public ResponseEntity<List<Book>> findByCategoryPOST(@RequestParam(value = "category") Integer categoryId) {
        return new ResponseEntity<>(bookService.findByCategory(categoryId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books/category")
    public ResponseEntity<List<Book>> findByCategory(@RequestParam(value = "category") Integer categoryId) {
        return new ResponseEntity<>(bookService.findByCategory(categoryId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/books/reserved")
    public ResponseEntity<RegisterRecord> reserveBook(@RequestParam(value = "book") String bookId,
                                                      @RequestParam(value = "userId") String login,
                                                      @RequestParam(value = "token", defaultValue = "") String token) {
        User user = new User();
        user.setLogin(login);
//        Book book = bookService.find(bookId);
        LibraryBook libraryBook = bookService.findLibraryBook(bookId);
        if (libraryBook == null) {
            return new ResponseEntity<>(new RegisterRecord(), HttpStatus.FORBIDDEN);
        }

        RegisterRecord registerRecord = new RegisterRecord();
        registerRecord.setUser(user);
        registerRecord.setLibraryBook(libraryBook);
        registerRecord.setReserveDate(new Date());
        registerRecord.setReturnDeadline(new Date());
        registerRecord = registerRecordService.save(registerRecord);
        if (registerRecord.getIdRegister() != null) {
            return new ResponseEntity<>(registerRecord, HttpStatus.OK);
        }
        return new ResponseEntity<>(new RegisterRecord(), HttpStatus.BAD_REQUEST);
    }

//    public ResponseEntity<Book> createBook(@RequestParam(value = "bookName") String bookName) {
//
//    }

}
