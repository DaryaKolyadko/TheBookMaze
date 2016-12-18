package com.kolyadko_polovtseva.book_maze.validator;

import com.kolyadko_polovtseva.book_maze.dto.BookDto;
import com.kolyadko_polovtseva.book_maze.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {
    @Autowired
    private BookService bookService;

    @Override
    public boolean supports(Class<?> aClass) {
        return BookDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        BookDto book = (BookDto) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (book.getName().length() < 1 || book.getName().length() > 60) {
            errors.rejectValue("name", "Size.bookForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryId", "NotEmpty");
        if (!StringUtils.isNumeric(book.getCategoryId())) {
            errors.rejectValue("categoryId", "Choose.category");
        }

        if (book.getAuthorIdSet() == null || book.getAuthorIdSet().isEmpty()) {
            errors.rejectValue("authorIdSet", "Choose.author");
        } else {
            for (String id : book.getAuthorIdSet()) {
                if (!StringUtils.isNumeric(id)) {
                    errors.rejectValue("authorIdSet", "Choose.author");
                }
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
        if (book.getDescription().length() < 1 || book.getDescription().length() > 850) {
            errors.rejectValue("description", "Size.bookForm.description");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pageNum", "NotEmpty");
        if (!StringUtils.isNumeric(book.getPageNum())) {
            errors.rejectValue("pageNum", "Check.input");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishYear", "NotEmpty");
        if (book.getPublishYear().replace(" ", "").length() != 4 ||
                !StringUtils.isNumeric(book.getPublishYear())) {
            errors.rejectValue("publishYear", "Check.input");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishHouseId", "NotEmpty");
        if (!StringUtils.isNumeric(book.getPublishHouseId())) {
            errors.rejectValue("publishHouseId", "Choose.publishHouse");
        }

        if (book.getLibraryBookIdSet() != null && !book.getLibraryBookIdSet().isEmpty()) {
            for (String id : book.getLibraryBookIdSet()) {
                if (!StringUtils.isNumeric(id)) {
                    errors.rejectValue("libraryBookIdSet", "Check.input");
                }
            }
        }
    }
}