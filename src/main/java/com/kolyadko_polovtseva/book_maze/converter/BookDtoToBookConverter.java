package com.kolyadko_polovtseva.book_maze.converter;

import com.kolyadko_polovtseva.book_maze.dto.BookDto;
import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.service.AuthorService;
import com.kolyadko_polovtseva.book_maze.service.CategoryService;
import com.kolyadko_polovtseva.book_maze.service.LibraryBookService;
import com.kolyadko_polovtseva.book_maze.service.PublishHouseService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DaryaKolyadko on 10.12.2016.
 */
@Component
public class BookDtoToBookConverter {
    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @Autowired
    @Qualifier("publishHouseServiceImpl")
    private PublishHouseService publishHouseService;

    @Autowired
    @Qualifier("authorServiceImpl")
    private AuthorService authorService;

    @Autowired
    @Qualifier("libraryBookServiceImpl")
    private LibraryBookService libraryBookService;

    public Book convertFromDto(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setCategory(categoryService.findById(Integer.parseInt(bookDto.getCategoryId())));
        book.setImageUrl(bookDto.getImageUrl());
        List<Integer> authors = new ArrayList<>();
        bookDto.getAuthorIdSet().forEach(id->authors.add(NumberUtils.toInt(id)));
        book.setAuthors(new HashSet<>(authorService.findByIdList(authors)));
        book.setDescription(bookDto.getDescription());
        book.setEbookUrl(book.getEbookUrl());
        book.setPublishYear(Integer.parseInt(bookDto.getPublishYear()));
        book.setPageNum(Integer.parseInt(bookDto.getPageNum()));
        List<Integer> libraryBooks = new ArrayList<>();
        bookDto.getAuthorIdSet().forEach(id->libraryBooks.add(NumberUtils.toInt(id)));
        book.setLibraryBooks(new HashSet<>(libraryBookService.findByIdList(libraryBooks)));
        book.setPublishHouse(publishHouseService.findById(Integer.parseInt(bookDto.getPublishHouseId())));
        return book;
    }
}