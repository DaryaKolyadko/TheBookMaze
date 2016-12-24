package com.kolyadko_polovtseva.book_maze.service.impl;

import com.kolyadko_polovtseva.book_maze.dao.BookRepository;
import com.kolyadko_polovtseva.book_maze.dao.CategoryRepository;
import com.kolyadko_polovtseva.book_maze.dao.LibraryBookRepository;
import com.kolyadko_polovtseva.book_maze.dto.SearchQueryDto;
import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import com.kolyadko_polovtseva.book_maze.search.LuceneIndexBuilder;
import com.kolyadko_polovtseva.book_maze.search.LuceneSearch;
import com.kolyadko_polovtseva.book_maze.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by nadez on 12/4/2016.
 */
@Transactional
@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private LibraryBookRepository libraryBookRepository;
    private CategoryRepository categoryRepository;
    private LuceneIndexBuilder indexBuilder;

    private static boolean firstLaunch = true;

    public BookServiceImpl(BookRepository bookRepository, LibraryBookRepository libraryBookRepository,
                           CategoryRepository categoryRepository, LuceneIndexBuilder indexBuilder) {
        this.bookRepository = bookRepository;
        this.libraryBookRepository = libraryBookRepository;
        this.categoryRepository = categoryRepository;
        this.indexBuilder = indexBuilder;
    }

    @Override
    public List<Book> findByCategory(Category category) {
        return bookRepository.findBooksByCategory(category);
    }

    @Override
    public Set<Book> findByCategory(Integer categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        return category.getBooks();
    }

    @Override
    public Book find(Integer bookId) {
        return bookRepository.findOne(bookId);
    }

    @Override
    public LibraryBook findLibraryBook(Integer bookId) {
        return libraryBookRepository.findOne(bookId);
    }

    @Override
    public LibraryBook findLibraryBook(Book book) {
        return libraryBookRepository.findLibraryBookByBook(book);
    }

    @Override
    public Book findBookByCategoryIdAndBookId(Integer categoryId, Integer bookId) {
        return bookRepository.findByCategoryIdCategoryAndIdBook(categoryId, bookId);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Iterable<Book> search(SearchQueryDto query) {
        if (firstLaunch) {
            indexBuilder.buildIndex(findAll());
            firstLaunch = false;
        }

        Set<Integer> ids = LuceneSearch.search(query);

        if (ids.isEmpty()) {
            return new ArrayList<>();
        }

        return bookRepository.findAll(ids);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.delete(id);
    }
}