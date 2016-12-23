package com.kolyadko_polovtseva.book_maze.service;

import com.kolyadko_polovtseva.book_maze.entity.Author;
import com.kolyadko_polovtseva.book_maze.entity.PublishHouse;

import java.util.List;
import java.util.Set;

/**
 * Created by DaryaKolyadko on 12.12.2016.
 */
public interface AuthorService {
    Author findById(Integer id);

    void deleteById(Integer id);

    List<Author> findAll();

    List<Author> findByIdList(List<Integer> idList);

    void save(Author author);
}