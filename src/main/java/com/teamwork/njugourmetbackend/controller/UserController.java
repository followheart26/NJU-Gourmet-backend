package com.teamwork.njugourmetbackend.controller;

import com.teamwork.njugourmetbackend.entity.User;
import com.teamwork.njugourmetbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public boolean login(@RequestBody User user){
        return false;
    }

}
