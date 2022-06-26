package com.teamwork.njugourmetbackend.service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teamwork.njugourmetbackend.controller.DTO.LoginResponse;
import com.teamwork.njugourmetbackend.controller.DTO.userLoginDto;
import com.teamwork.njugourmetbackend.entity.User;
import com.teamwork.njugourmetbackend.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Resource
    private UserMapper userMapper;

    public LoginResponse login(userLoginDto user) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        queryWrapper.eq("password",user.getPassword());
        User one=getOne(queryWrapper);
        LoginResponse loginResponse=new LoginResponse();
        if(one!=null){
            loginResponse.setPass(true);
            loginResponse.setId(one.getId());
        }else{
            loginResponse.setPass(false);
            loginResponse.setId(0);
        }
        return loginResponse;
    }

    public LoginResponse register(userLoginDto user) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        User one=getOne(queryWrapper);
        LoginResponse loginResponse=new LoginResponse();
        if(one!=null){
            loginResponse.setPass(false);
            loginResponse.setId(0);
        }else{
            User newuser = new User();
            newuser.setUsername(user.getUsername());
            newuser.setPassword(user.getPassword());
            userMapper.insert(newuser);
            loginResponse.setPass(true);
            loginResponse.setId(0);
        }
        return loginResponse;
    }

    public boolean updateUser(Integer userid, String name, String sex, String telephone) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",userid);
        User one=getOne(queryWrapper);
        if(one.getUsername().equals(name)){
            one.setSex(sex);
            one.setTelephone(telephone);
            userMapper.updateById(one);
            return true;
        }else{
            queryWrapper.eq("username",name);
            User second=getOne(queryWrapper);
            if(second!=null){
                return false;
            }else{
                one.setUsername(name);
                one.setSex(sex);
                one.setTelephone(telephone);
                userMapper.updateById(one);
                return true;
            }
        }
    }
}
