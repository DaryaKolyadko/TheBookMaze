package com.kolyadko_polovtseva.book_maze.service;

import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;

import java.util.List;

/**
 * Created by nadez on 12/3/2016.
 */
public interface BookService {

    List<Book> findByCategory(Category category);
    List<Book> findByCategory(Integer categoryId);
    Book find(Integer bookId);
    LibraryBook findLibraryBook(String bookId);
    LibraryBook findLibraryBook(Book book);

}
