package com.teamwork.njugourmetbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teamwork.njugourmetbackend.entity.Like;
import com.teamwork.njugourmetbackend.mapper.LikeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class LikeService extends ServiceImpl<LikeMapper, Like> {
    @Resource
    private LikeMapper likeMapper;
    public boolean like(Integer mealid, Integer userid) {
        QueryWrapper<Like> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("mealid",mealid);
        queryWrapper.eq("userid",userid);
        Like one=getOne(queryWrapper);
        if(one!=null){
            return false;
        }else{
            Like like=new Like();
            like.setMealid(mealid);
            like.setUserid(userid);
            likeMapper.insert(like);
            return true;
        }
    }
}
