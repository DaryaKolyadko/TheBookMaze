package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.entity.Author;
import com.kolyadko_polovtseva.book_maze.entity.PublishHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by DaryaKolyadko on 09.12.2016.
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    List<Author> findAll();
    List<Author> findByIdAuthorIn(List<Integer> idList);
}