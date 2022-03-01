package com.sams.sso.ssoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String hello(){
        return "index";
    }
    @GetMapping("/restricted")
    public String restricted(){
        return "logged in \n yo bro";
    }
}
