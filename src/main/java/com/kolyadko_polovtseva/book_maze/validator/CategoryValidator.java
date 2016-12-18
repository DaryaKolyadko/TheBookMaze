package com.kolyadko_polovtseva.book_maze.validator;

import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CategoryValidator implements Validator {
    @Autowired
    private CategoryService categoryService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Category.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Category category = (Category) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (category.getName().length() < 1 || category.getName().length() > 45) {
            errors.rejectValue("name", "Size.categoryForm.name");
        }

        if (categoryService.findByName(category.getName()) != null) {
            errors.rejectValue("name", "Duplicate.categoryForm.name");
        }
    }
}