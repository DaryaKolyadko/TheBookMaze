package com.kolyadko_polovtseva.book_maze.service;

import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;

import java.util.List;
import java.util.Set;

/**
 * Created by nadez on 12/3/2016.
 */
public interface BookService {
    Integer RESERVE_PERIOD = 10;

    List<Book> findByCategory(Category category);

    Set<Book> findByCategory(Integer categoryId);

    Book find(Integer bookId);

    LibraryBook findLibraryBook(Integer bookId);

    LibraryBook findLibraryBook(Book book);

    Book findBookByCategoryIdAndBookId(Integer categoryId, Integer bookId);

    void save(Book book);
}