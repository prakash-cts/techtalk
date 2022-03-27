package com.cognizant.techtalk.controller;

import com.cognizant.techtalk.models.User;
import com.cognizant.techtalk.service.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.File;

@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Value("${techtalk.token}")
    private String token;

    @Autowired
    private UserService userService;

    @GetMapping
    public String login() {
        return "User is tech talk admin";
    }
    @GetMapping("token")
    public String getToken() {
        return token;
    }

    @GetMapping(value = "/file",produces = "application/zip")
    public String downloadFile() {
        File file = new File("/Users/m_868065/Documents/input.json");
        return "User is tech talk admin";
    }

}
