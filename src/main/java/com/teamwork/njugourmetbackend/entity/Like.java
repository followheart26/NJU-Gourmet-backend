package com.teamwork.njugourmetbackend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("likes")
public class Like {
    Integer mealid;
    Integer userid;
}
