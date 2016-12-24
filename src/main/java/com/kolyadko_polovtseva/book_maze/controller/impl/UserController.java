package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.controller.AbstractController;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.service.UserService;
import com.kolyadko_polovtseva.book_maze.validator.UserProfileValidator;
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
 * Created by DaryaKolyadko on 29.11.2016.
 */
@Controller
public class UserController extends AbstractController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    private UserProfileValidator validator;

    @RequestMapping(value = "/UserProfile/{login}", method = RequestMethod.GET)
    public String userProfile(Model model, @PathVariable String login) {
        configureCloudinary(model);
        model.addAttribute("profile", userService.findByLogin(login));
        return "userProfile";
    }

    @RequestMapping(value = "/UserProfile/Edit/{login}", method = RequestMethod.GET)
    public String showEditProfile(Model model, @PathVariable String login) {
        User user = userService.findByLogin(login);
        model.addAttribute("profile", user);
        return "editUserProfile";
    }

    @RequestMapping(value = "/UserProfile/Edit", method = RequestMethod.POST)
    public String editProfile(Model model, @ModelAttribute("userForm") User user, BindingResult bindingResult) {
        validator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "editUserProfile";
        }

        User previous = userService.findByLogin(user.getLogin());
        previous.setFirstName(user.getFirstName());
        previous.setLastName(user.getLastName());
        previous.setLibraryId(user.getLibraryId());
        previous.setBirthDate(user.getBirthDate());
        previous.setImageUrl(user.getImageUrl());
        userService.save(previous);
        return "redirect:/UserProfile/" + user.getLogin();
    }

    @RequestMapping(value = "/Users", method = RequestMethod.GET)
    public String showUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }
}