package com.cognizant.techtalk.controller;

import com.cognizant.techtalk.models.User;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Value("${techtalk.token}")
    private String token;
    @GetMapping
    public String login() {
        return "User is tech talk admin";
    }
    @GetMapping("token")
    public String getToken() {
        return token;
    }

}
