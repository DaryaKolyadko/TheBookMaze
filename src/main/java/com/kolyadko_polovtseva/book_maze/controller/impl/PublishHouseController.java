package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.controller.AbstractController;
import com.kolyadko_polovtseva.book_maze.entity.Author;
import com.kolyadko_polovtseva.book_maze.entity.PublishHouse;
import com.kolyadko_polovtseva.book_maze.service.AuthorService;
import com.kolyadko_polovtseva.book_maze.service.PublishHouseService;
import com.kolyadko_polovtseva.book_maze.validator.AuthorValidator;
import com.kolyadko_polovtseva.book_maze.validator.PublishHouseValidator;
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
public class PublishHouseController extends AbstractController {
    @Autowired
    @Qualifier("publishHouseServiceImpl")
    private PublishHouseService publishHouseService;

    @Autowired
    private PublishHouseValidator publishHouseValidator;

    @RequestMapping(value = "/PublishHouses", method = RequestMethod.GET)
    public String showPublishHouses(Model model) {
        model.addAttribute("publishHouses", publishHouseService.findAll());
        return "publishHousesList";
    }

    @RequestMapping(value = "/PublishHouses/AddPublishHouse", method = RequestMethod.GET)
    public String showAddPublishHouse(Model model) {
        model.addAttribute("publishHouseForm", new PublishHouse());
        return "addPublishHouse";
    }

    @RequestMapping(value = "/PublishHouses/AddPublishHouse", method = RequestMethod.POST)
    public String addPublishHouse(@ModelAttribute("publishHouseForm") PublishHouse publishHouse,
                            BindingResult bindingResult, Model model) {
        publishHouseValidator.validate(publishHouse, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addPublishHouse";
        }

        publishHouseService.save(publishHouse);
        return "redirect:/PublishHouses";
    }

    @RequestMapping(value = "/PublishHouses/DeletePublishHouse/{idPublishHouse}", method = RequestMethod.POST)
    public String deleteAuthor(@PathVariable Integer idPublishHouse, Model model) {
        publishHouseService.deleteById(idPublishHouse);
        return "redirect:/PublishHouses";
    }

    @RequestMapping(value = "/PublishHouses/EditPublishHouse/{idPublishHouse}", method = RequestMethod.GET)
    public String showEditPublishHouse(@PathVariable Integer idPublishHouse, Model model) {
        model.addAttribute("publishHouseForm", publishHouseService.findById(idPublishHouse));
        return "editPublishHouse";
    }

    @RequestMapping(value = "/PublishHouses/EditPublishHouse", method = RequestMethod.POST)
    public String editPublishHouse(@ModelAttribute("publishHouseForm") PublishHouse publishHouse,
                             BindingResult bindingResult, Model model) {
        publishHouseValidator.validate(publishHouse, bindingResult);

        if (bindingResult.hasErrors()) {
            return "editPublishHouse";
        }

        PublishHouse previous = publishHouseService.findById(publishHouse.getIdPublishHouse());
        previous.setName(publishHouse.getName());
        publishHouseService.save(previous);
        return "redirect:/PublishHouses";
    }
}