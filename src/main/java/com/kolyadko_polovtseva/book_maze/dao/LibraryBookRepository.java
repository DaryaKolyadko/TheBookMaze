package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DaryaKolyadko on 09.12.2016.
 */
@Repository
public interface LibraryBookRepository extends CrudRepository<LibraryBook, String> {
//    List<Li> findBooksByCategory(Category category);
}