package com.kolyadko_polovtseva.book_maze.service.impl;

import com.kolyadko_polovtseva.book_maze.dao.AuthorRepository;
import com.kolyadko_polovtseva.book_maze.entity.Author;
import com.kolyadko_polovtseva.book_maze.entity.PublishHouse;
import com.kolyadko_polovtseva.book_maze.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by nadez on 12/4/2016.
 */
@Transactional
@Service("authorServiceImpl")
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author findById(Integer id) {
        return authorRepository.findOne(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> findByIdList(List<Integer> idList) {
        return authorRepository.findByIdAuthorIn(idList);
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }
}