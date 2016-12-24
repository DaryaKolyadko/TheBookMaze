package com.kolyadko_polovtseva.book_maze.validator;

import com.kolyadko_polovtseva.book_maze.dto.UserDto;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto user = (UserDto) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty");
        if (user.getLogin().length() < 1 || user.getLogin().length() > 45) {
            errors.rejectValue("login", "Size.userForm.login");
        }
        if (userService.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.userForm.login");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        if (user.getFirstName().length() < 1 || user.getFirstName().length() > 45) {
            errors.rejectValue("firstName", "Size.userForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        if (user.getFirstName().length() < 1 || user.getFirstName().length() > 45) {
            errors.rejectValue("lastName", "Size.userForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 1 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty");
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthDate", "NotEmpty");

        if (user.getLibraryId().length() > 10) {
            errors.rejectValue("libraryId", "Size.userForm.libraryId");
        }
    }
}