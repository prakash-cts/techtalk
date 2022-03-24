package com.cognizant.techtalk.controller;

import com.cognizant.techtalk.models.User;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @GetMapping
    public String getUser() {
        return "User is tech talk admin1";
    }
    @PostMapping("/1")
    public void signupUser1() {
//        Gson gson = new Gson();
//        User user = gson.fromJson(requestBody,User.class);
        logger.info("User data is : {}","hello");
    }
    @PostMapping
    public String signupUser(@RequestBody String requestBody) {
        Gson gson = new Gson();
        User user = gson.fromJson(requestBody,User.class);
        logger.info("User data is : {}",user.toString());
        return "valid";
    }
}
