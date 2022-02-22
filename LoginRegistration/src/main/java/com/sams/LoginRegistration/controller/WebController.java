package com.sams.LoginRegistration.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class WebController {
   @GetMapping
     String index(Model model) {
       model.addAttribute("HI","Hello world");
        return "index";
    }
}
