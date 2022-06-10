package com.teamwork.njugourmetbackend.service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teamwork.njugourmetbackend.entity.User;
import com.teamwork.njugourmetbackend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
