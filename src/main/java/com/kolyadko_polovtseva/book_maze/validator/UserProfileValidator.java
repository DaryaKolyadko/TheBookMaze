package com.kolyadko_polovtseva.book_maze.validator;

import com.kolyadko_polovtseva.book_maze.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserProfileValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        if (user.getFirstName().length() < 1 || user.getFirstName().length() > 45) {
            errors.rejectValue("firstName", "Size.userForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        if (user.getFirstName().length() < 1 || user.getFirstName().length() > 45) {
            errors.rejectValue("lastName", "Size.userForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthDate", "NotEmpty");
    }
}