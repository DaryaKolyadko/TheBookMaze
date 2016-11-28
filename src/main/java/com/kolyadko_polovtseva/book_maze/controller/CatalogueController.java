package com.kolyadko_polovtseva.book_maze.controller;

import com.kolyadko_polovtseva.book_maze.util.CloudinaryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DaryaKolyadko on 28.11.2016.
 */
@Controller
public class CatalogueController {
    private CloudinaryManager cloudinaryManager;

    @RequestMapping(path = "/catalogue", method = RequestMethod.GET)
    public ModelAndView getCatalogue(Model model) {
        model.addAttribute("Singleton", cloudinaryManager.getSingletonManager());
        return new ModelAndView("catalogue");
    }

    @Autowired
    public void setCloudinaryManager(CloudinaryManager cloudinaryManager) {
        this.cloudinaryManager = cloudinaryManager;
    }
}