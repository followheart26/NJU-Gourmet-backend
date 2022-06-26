package com.teamwork.njugourmetbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teamwork.njugourmetbackend.controller.DTO.LoginResponse;
import com.teamwork.njugourmetbackend.controller.DTO.userLoginDto;
import com.teamwork.njugourmetbackend.entity.User;
import com.teamwork.njugourmetbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody userLoginDto user){
        return userService.login(user);
    }

    @PostMapping("/register")
    public LoginResponse register(@RequestBody userLoginDto user){
        return userService.register(user);
    }

    @GetMapping("/getuser")
    public User getuser(@RequestParam Integer userid){
        return userService.getById(userid);
    }

    @GetMapping ("/update")
    public boolean updateUser(@RequestParam Integer userid,@RequestParam String name,@RequestParam String sex,@RequestParam String telephone){
        return userService.updateUser(userid,name,sex,telephone);
    }


}
