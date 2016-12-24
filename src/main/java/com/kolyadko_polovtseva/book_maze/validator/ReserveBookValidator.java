package com.kolyadko_polovtseva.book_maze.validator;

import com.kolyadko_polovtseva.book_maze.dto.ReserveBookDto;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.service.BookService;
import com.kolyadko_polovtseva.book_maze.service.impl.RegisterRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ReserveBookValidator implements Validator {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @Autowired
    @Qualifier("registerRecordServiceImpl")
    private RegisterRecordServiceImpl registerRecordService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ReserveBookDto bookDto = (ReserveBookDto) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "libraryBookId", "NoSuchLibBook");

        if (bookDto.getLibraryBookId() != null) {
            LibraryBook libraryBook = bookService.findLibraryBook(bookDto.getLibraryBookId());

            if (libraryBook == null) {
                errors.rejectValue("libraryBookId", "NoSuchLibBook");
            } else if (!registerRecordService.isLibraryBookAvailable(libraryBook)) {
                errors.rejectValue("libraryBookId", "AlreadyReserved");
            }
        }
    }
}