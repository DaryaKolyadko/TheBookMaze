package com.kolyadko_polovtseva.book_maze.service.impl;

import com.kolyadko_polovtseva.book_maze.dao.RegisterRecordRepository;
import com.kolyadko_polovtseva.book_maze.entity.RegisterRecord;
import com.kolyadko_polovtseva.book_maze.service.RegisterRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nadez on 12/10/2016.
 */
@Component("registerRecordServiceImpl")
@Transactional
public class RegisterRecordServiceImpl implements RegisterRecordService {
    @Autowired
    private RegisterRecordRepository registerRecordRepository;

    @Override
    public RegisterRecord save(RegisterRecord registerRecord) {
        registerRecord = registerRecordRepository.save(registerRecord);
        return registerRecord;
    }
}