package com.kolyadko_polovtseva.book_maze.validator;

import com.kolyadko_polovtseva.book_maze.entity.PublishHouse;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PublishHouseValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return PublishHouse.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PublishHouse publishHouse = (PublishHouse) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (publishHouse.getName().length() < 1 || publishHouse.getName().length() > 45) {
            errors.rejectValue("name", "Size.categoryForm.name");
        }
    }
}