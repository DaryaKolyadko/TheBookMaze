package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.entity.RegisterRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DaryaKolyadko on 09.12.2016.
 */
@Repository
public interface RegisterRecordRepository extends CrudRepository<RegisterRecord, Integer> {
}