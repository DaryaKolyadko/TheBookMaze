package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DaryaKolyadko on 09.12.2016.
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    List<Author> findAll();

    List<Author> findByIdAuthorIn(List<Integer> idList);
}