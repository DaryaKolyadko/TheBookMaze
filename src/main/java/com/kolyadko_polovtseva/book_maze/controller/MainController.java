package com.kolyadko_polovtseva.book_maze.controller;

import com.kolyadko_polovtseva.book_maze.proba.Quote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DaryaKolyadko on 27.11.2016.
 */
@Controller
public class MainController {

    @RequestMapping(path= "/about", method = RequestMethod.GET)
    public ModelAndView quote(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        model.addAttribute("quote", quote);
        return new ModelAndView("../../index");
    }
}