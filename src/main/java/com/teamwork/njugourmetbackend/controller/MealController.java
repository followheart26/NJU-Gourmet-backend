package com.teamwork.njugourmetbackend.controller;

import com.teamwork.njugourmetbackend.service.MealService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.transform.Result;

@RestController
@RequestMapping("/meal")
public class MealController {
    @Resource
    private MealService mealService;

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam String name,
                           @RequestParam(defaultValue = ) String address,
                           ){

    }
}
