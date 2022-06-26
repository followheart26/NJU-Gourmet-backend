package com.teamwork.njugourmetbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teamwork.njugourmetbackend.entity.Like;
import com.teamwork.njugourmetbackend.entity.Meal;
import com.teamwork.njugourmetbackend.mapper.LikeMapper;
import com.teamwork.njugourmetbackend.mapper.MealMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MealService extends ServiceImpl<MealMapper, Meal> {
    @Resource
    private MealMapper mealMapper;


    public boolean deletemeal(Integer mealid, Integer userid) {
        QueryWrapper<Meal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",mealid);
        Meal one=getOne(queryWrapper);
        if(one.getUserid()!=userid){
            return false;
        }else{
            mealMapper.deleteById(mealid);
            return true;
        }
    }

    public boolean addmeal(String name, Integer price, Integer address,Integer userid) {
        QueryWrapper<Meal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",name);
        queryWrapper.eq("address",address);
        Meal one=getOne(queryWrapper);
        if(one!=null){
            return false;
        }else{
            Meal meal=new Meal();
            meal.setName(name);
            meal.setAddress(address);
            meal.setPrice(price);
            meal.setUserid(userid);
            meal.setLikes(0);
            mealMapper.insert(meal);
            return true;
        }
    }

    public void addlike(Integer mealid) {
        QueryWrapper<Meal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",mealid);
        Meal one=getOne(queryWrapper);
        one.setLikes(one.getLikes()+1);
        mealMapper.updateById(one);
    }
}
