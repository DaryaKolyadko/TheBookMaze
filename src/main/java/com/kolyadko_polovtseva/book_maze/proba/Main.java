package com.kolyadko_polovtseva.book_maze.proba;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class Main {
    //
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        resp.getWriter().print("Hello from Java! =)");
//    }
//    @RequestMapping(name = "/quote", method = RequestMethod.GET)
//    public ModelAndView quote(Model model) {
//        RestTemplate restTemplate = new RestTemplate();
//        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//        model.addAttribute("quote", quote);
//        return new ModelAndView("../../index");
//    }
}