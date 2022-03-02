package com.sams.hostelmsapp.hostelmsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Template {
    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }
    @GetMapping("home")
    public String getHomeView(){
        return "home";
    }
}

