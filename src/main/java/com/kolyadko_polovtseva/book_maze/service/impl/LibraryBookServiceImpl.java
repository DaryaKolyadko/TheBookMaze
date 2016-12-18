package com.kolyadko_polovtseva.book_maze.service.impl;

import com.kolyadko_polovtseva.book_maze.dao.LibraryBookRepository;
import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import com.kolyadko_polovtseva.book_maze.service.LibraryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by DaryaKolyadko on 12.12.2016.
 */
@Service("libraryBookServiceImpl")
public class LibraryBookServiceImpl implements LibraryBookService {
    @Autowired
    LibraryBookRepository libraryBookRepository;

    @Override
    public LibraryBook findAvailableFor(Book book) {
        // todo
        return libraryBookRepository.findLibraryBookByBook(book);
    }

    @Override
    public List<LibraryBook> findAll() {
        return libraryBookRepository.findAll();
    }

    @Override
    public List<LibraryBook> findByIdList(List<Integer> idList) {
        return libraryBookRepository.findByIdLibraryBookIn(idList);
    }
}