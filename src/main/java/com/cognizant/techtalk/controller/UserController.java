package com.cognizant.techtalk.controller;

import com.cognizant.techtalk.models.User;
import com.cognizant.techtalk.service.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String validateUser(@RequestBody String requestBody) {
        Gson gson = new Gson();
        User user = gson.fromJson(requestBody,User.class);
        logger.info("User data is : {}",user.toString());
        return userService.validateUser(user);

    }

    @PostMapping
    public String signupUser(@RequestBody String requestBody) {
        Gson gson = new Gson();
        User user = gson.fromJson(requestBody,User.class);
        logger.info("User data is : {}",user.toString());
        //userService.save(user);
        return userService.save(user);
    }
    @GetMapping("/regex")
    public String getRegex(){
        return userService.getRegex();
    }
}
