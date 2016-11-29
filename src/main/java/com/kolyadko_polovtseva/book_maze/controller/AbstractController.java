package com.kolyadko_polovtseva.book_maze.controller;

import com.kolyadko_polovtseva.book_maze.util.CloudinaryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * Created by DaryaKolyadko on 29.11.2016.
 */
@Component
public abstract class AbstractController {
    private static final String CLOUDINARY_ATTR = "Singleton";

    private CloudinaryManager cloudinaryManager;

    protected void configureCloudinary(Model model) {
        model.addAttribute(CLOUDINARY_ATTR, cloudinaryManager.getSingletonManager());
    }

    @Autowired
    private void setCloudinaryManager(CloudinaryManager cloudinaryManager) {
        this.cloudinaryManager = cloudinaryManager;
    }
}