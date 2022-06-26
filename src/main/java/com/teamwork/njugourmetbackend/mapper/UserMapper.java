package com.teamwork.njugourmetbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teamwork.njugourmetbackend.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> getAll();
}
