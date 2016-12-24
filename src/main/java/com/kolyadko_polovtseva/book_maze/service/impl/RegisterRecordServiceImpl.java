package com.kolyadko_polovtseva.book_maze.service.impl;

import com.kolyadko_polovtseva.book_maze.dao.RegisterRecordRepository;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import com.kolyadko_polovtseva.book_maze.entity.RegisterRecord;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.service.RegisterRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nadez on 12/10/2016.
 */
//@Transactional
@Service("registerRecordServiceImpl")
public class RegisterRecordServiceImpl implements RegisterRecordService {
    @Autowired
    private RegisterRecordRepository registerRecordRepository;

//    @Autowired
//    private LibraryBookRepository libraryBookRepository;

    @Override
    public RegisterRecord save(RegisterRecord registerRecord) {
        registerRecord = registerRecordRepository.save(registerRecord);
        return registerRecord;
    }

    @Override
    public List<RegisterRecord> findByUser(User user) {
        return registerRecordRepository.findRegisterRecordsByUser(user);
    }

    @Override
    public boolean isLibraryBookAvailable(LibraryBook libraryBook) {
        RegisterRecord record = registerRecordRepository.findLastByLibraryBook(libraryBook);
        return record == null ? true : record.getWasReturned();
    }
}