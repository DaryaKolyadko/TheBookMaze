package com.kolyadko_polovtseva.book_maze.service.impl;

import com.kolyadko_polovtseva.book_maze.dao.CategoryRepository;
import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.exception.ServiceException;
import com.kolyadko_polovtseva.book_maze.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nadez on 12/3/2016.
 */
@Transactional
@Component("categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public void save(Category category) throws ServiceException {
        Category check = categoryRepository.findByName(category.getName());

        if (check == null) {
            categoryRepository.save(category);
        } else {
            throw new ServiceException("Category with such name already exists.");
        }
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.delete(id);
    }
}