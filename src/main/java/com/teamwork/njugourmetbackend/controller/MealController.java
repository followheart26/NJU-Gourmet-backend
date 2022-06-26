package com.teamwork.njugourmetbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.teamwork.njugourmetbackend.entity.Meal;
import com.teamwork.njugourmetbackend.service.LikeService;
import com.teamwork.njugourmetbackend.service.MealService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.transform.Result;

@RestController
@RequestMapping("/meal")
public class MealController {
    @Resource
    private MealService mealService;

    @Resource
    private LikeService likeService;

    @GetMapping("/page")
    public IPage<Meal> findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam String address
                           ){
        IPage<Meal> page=new Page<>(pageNum,pageSize);
        QueryWrapper<Meal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("address",address);
        IPage<Meal> page1 = mealService.page(page, queryWrapper);
        return page1;

    }

    @GetMapping("/search")
    public IPage<Meal> searchPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam String address,
                                  @RequestParam String name
    ){
        IPage<Meal> page=new Page<>(pageNum,pageSize);
        QueryWrapper<Meal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("address",address);
        queryWrapper.like("name",name);
        IPage<Meal> page1 = mealService.page(page, queryWrapper);
        return page1;

    }

    @GetMapping("/deletemeal")
    public boolean deletemeal(@RequestParam Integer mealid,@RequestParam Integer userid){
        return mealService.deletemeal(mealid,userid);
    }

    @GetMapping ("/add")
    public boolean addmeal(@RequestParam String name,@RequestParam Integer price,@RequestParam Integer address,@RequestParam Integer userid){
        return mealService.addmeal(name,price,address,userid);
    }

    @GetMapping("/like")
    public boolean like(@RequestParam Integer mealid,@RequestParam Integer userid){
        if( likeService.like(mealid,userid)){
            mealService.addlike(mealid);
            return true;
        }else{
            return false;
        }
    }
}
