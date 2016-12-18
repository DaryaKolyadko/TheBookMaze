package com.kolyadko_polovtseva.book_maze.service;

import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import com.kolyadko_polovtseva.book_maze.entity.RegisterRecord;
import com.kolyadko_polovtseva.book_maze.entity.User;

import java.util.List;

/**
 * Created by nadez on 12/10/2016.
 */
public interface RegisterRecordService {
    RegisterRecord save(RegisterRecord registerRecord);
    List<RegisterRecord> findByUser(User user);
    boolean isLibraryBookReserved(LibraryBook libraryBookId);
}