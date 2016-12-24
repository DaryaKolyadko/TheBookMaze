package com.kolyadko_polovtseva.book_maze.service;

import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.exception.ServiceException;

import java.util.List;

/**
 * Created by nadez on 12/3/2016.
 */
public interface CategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    Category findByName(String name);

    void save(Category category) throws ServiceException;

    void deleteById(Integer id);
}