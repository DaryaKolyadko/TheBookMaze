package com.kolyadko_polovtseva.book_maze.restcontroller;

import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nadez on 12/3/2016.
 */
@RestController
public class CategoryRestController {
    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, value = "/categories")
    public ResponseEntity<List<Category>> findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/categories")
    public ResponseEntity<List<Category>> findAllPost() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
}
