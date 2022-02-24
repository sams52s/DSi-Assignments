package com.sams.registration.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class AppController {

    // Login form
    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }
    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        return "registration";
    }
}
