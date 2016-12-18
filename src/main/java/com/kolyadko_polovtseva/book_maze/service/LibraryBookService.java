package com.kolyadko_polovtseva.book_maze.service;

import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;

import java.util.List;
import java.util.Set;

/**
 * Created by DaryaKolyadko on 12.12.2016.
 */
public interface LibraryBookService {
    LibraryBook findAvailableFor(Book book);
    List<LibraryBook> findAll();
    List<LibraryBook> findByIdList(List<Integer> idList);
}