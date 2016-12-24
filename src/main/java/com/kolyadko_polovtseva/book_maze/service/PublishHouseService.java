package com.kolyadko_polovtseva.book_maze.service;

import com.kolyadko_polovtseva.book_maze.entity.PublishHouse;

import java.util.List;

/**
 * Created by DaryaKolyadko on 12.12.2016.
 */
public interface PublishHouseService {
    PublishHouse findById(Integer id);

    List<PublishHouse> findAll();

    void save(PublishHouse publishHouse);

    void deleteById(Integer id);
}