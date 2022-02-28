package com.sams.registration.controller;

import com.sams.registration.model.registration.RegistrationRequest;
import com.sams.registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

/*
    @GetMapping({"/", "index"})
    public String getIndex(Model model){
        return "index";
    }
*/

    private final RegistrationService registrationService;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
}

