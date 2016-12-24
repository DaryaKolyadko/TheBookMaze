package com.kolyadko_polovtseva.book_maze.service.impl;

import com.kolyadko_polovtseva.book_maze.dao.PublishHouseRepository;
import com.kolyadko_polovtseva.book_maze.entity.PublishHouse;
import com.kolyadko_polovtseva.book_maze.service.PublishHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nadez on 12/4/2016.
 */
@Transactional
@Service("publishHouseServiceImpl")
public class PublishHouseServiceImpl implements PublishHouseService {
    @Autowired
    private PublishHouseRepository publishHouseRepository;

    @Override
    public PublishHouse findById(Integer id) {
        return publishHouseRepository.findOne(id);
    }

    @Override
    public List<PublishHouse> findAll() {
        return publishHouseRepository.findAll();
    }

    @Override
    public void save(PublishHouse publishHouse) {
        publishHouseRepository.save(publishHouse);
    }

    @Override
    public void deleteById(Integer id) {
        publishHouseRepository.delete(id);
    }
}