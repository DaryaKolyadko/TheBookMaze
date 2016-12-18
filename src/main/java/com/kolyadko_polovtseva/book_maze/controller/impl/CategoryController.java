package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.controller.AbstractController;
import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.service.CategoryService;
import com.kolyadko_polovtseva.book_maze.util.CloudinaryManager;
import com.kolyadko_polovtseva.book_maze.validator.CategoryValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DaryaKolyadko on 28.11.2016.
 */
@Controller
public class CategoryController extends AbstractController {
    private static final Logger LOG = LogManager.getLogger(CategoryController.class);

    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @Autowired
    private CategoryValidator categoryValidator;

    @Autowired
    private CloudinaryManager cloudinaryManager;

    @RequestMapping(value = "/Catalogue/Category/{idCategory}", method = RequestMethod.GET)
    public String getCategory(Model model, @PathVariable Integer idCategory) {
        configureCloudinary(model);
        Category category = categoryService.findById(idCategory);
        model.addAttribute("category", category);
        return "bookList";
    }

    @RequestMapping(value = "/Catalogue/AddCategory", method = RequestMethod.GET)
    public String showAddCategory(Model model) {
        configureCloudinary(model);
        model.addAttribute("categoryForm", new Category());
        return "addCategory";
    }

    @RequestMapping(value = "/Catalogue/AddCategory", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("categoryForm") Category category,
                              BindingResult bindingResult, Model model) {
        configureCloudinary(model);
        categoryValidator.validate(category, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addCategory";
        }

//        category.setImageUrl("mebeforeyou_tepcwx.jpg");
        category.setImageUrl(category.getImageUrl());
//        try {
//            File image = new File(category.getImageUrl());
//            Map result = cloudinaryManager.getCloudinary().uploader().upload("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSZId01rfLgcXAnxZ0ZfxabBdAAfluOs2U5gonLxtTO7WQKZv55ZA", ObjectUtils.emptyMap());
//            result = cloudinaryManager.getCloudinary().uploader().upload(image, ObjectUtils.emptyMap());
//            category.setImageUrl(result.get("public_id").toString() + result.get("format"));
//        } catch (IOException e) {
//            LOG.warn("Problems with image upload");
//        }

        categoryService.save(category);
        return "redirect:/Catalogue";
    }
}