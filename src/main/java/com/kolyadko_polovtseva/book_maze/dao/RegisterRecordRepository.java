package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import com.kolyadko_polovtseva.book_maze.entity.RegisterRecord;
import com.kolyadko_polovtseva.book_maze.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DaryaKolyadko on 09.12.2016.
 */
@Repository
public interface RegisterRecordRepository extends CrudRepository<RegisterRecord, Integer> {
    List<RegisterRecord> findRegisterRecordsByUser(User user);

    RegisterRecord findLastByLibraryBook(LibraryBook libraryBook);
//    RegisterRecord findLastByLibraryBook(LibraryBook libraryBook);
}