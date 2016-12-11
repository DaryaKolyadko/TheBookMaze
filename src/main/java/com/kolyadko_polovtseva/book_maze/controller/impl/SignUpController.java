package com.kolyadko_polovtseva.book_maze.controller.impl;

import com.kolyadko_polovtseva.book_maze.converter.UserDtoToUserConverter;
import com.kolyadko_polovtseva.book_maze.dao.UserRepository;
import com.kolyadko_polovtseva.book_maze.dao.UserRoleRepository;
import com.kolyadko_polovtseva.book_maze.dto.UserDto;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.entity.UserRole;
import com.kolyadko_polovtseva.book_maze.service.SecurityService;
import com.kolyadko_polovtseva.book_maze.service.UserService;
import com.kolyadko_polovtseva.book_maze.service.impl.SecurityServiceImpl;
import com.kolyadko_polovtseva.book_maze.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by DaryaKolyadko on 29.11.2016.
 */
@Controller
public class SignUpController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("securityServiceImpl")
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserDtoToUserConverter converter;

    @Autowired
    UserRepository ur;

    @Autowired
    UserRoleRepository roleRep;

    @RequestMapping(value = "/SignUp", method = RequestMethod.GET)
    public String showSignUp(Model model) {
        model.addAttribute("userForm", new UserDto());
        return "signUp";
    }

    @RequestMapping(value = "/SignUp", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("userForm") UserDto userForm,
                         BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "signUp";
        }

        User newUser = converter.convertFromDto(userForm);
        userService.save(newUser, "USER");
        securityService.autoLogin(userForm.getLogin(), userForm.getPassword());
        return "../../index";
    }
}