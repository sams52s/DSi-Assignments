package com.sams.registration.controller;

import com.sams.registration.model.user.AppUser;
import com.sams.registration.model.user.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {
    private final UserRepository userRepository;

    public PublicRestApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }

    @GetMapping("users")
    public List<AppUser> users(){
        return this.userRepository.findAll();
    }

}
