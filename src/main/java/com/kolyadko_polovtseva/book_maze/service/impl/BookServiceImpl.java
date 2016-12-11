package com.kolyadko_polovtseva.book_maze.service.impl;

import com.kolyadko_polovtseva.book_maze.dao.BookRepository;
import com.kolyadko_polovtseva.book_maze.dao.CategoryRepository;
import com.kolyadko_polovtseva.book_maze.dao.LibraryBookRepository;
import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import com.kolyadko_polovtseva.book_maze.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nadez on 12/4/2016.
 */
@Transactional
@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryBookRepository libraryBookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Book> findByCategory(Category category) {
        return bookRepository.findBooksByCategory(category);
    }

    @Override
    public List<Book> findByCategory(Integer categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        return bookRepository.findBooksByCategory(category);
    }

    @Override
    public Book find(Integer bookId) {
        return bookRepository.findOne(bookId);
    }

    @Override
    public LibraryBook findLibraryBook(String bookId) {
        return libraryBookRepository.findOne(bookId);
    }

    @Override
    public LibraryBook findLibraryBook(Book book) {
        return libraryBookRepository.findLibraryBookByBook(book);
    }

    @Override
    public Book findBookByCategoryAndBookId(Category category, Integer bookId) {
        return bookRepository.findByCategoryAndIdBook(category, bookId);
    }
}