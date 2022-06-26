package com.teamwork.njugourmetbackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("meal")
public class Meal {
    @TableId(type = IdType.AUTO)
    Integer id;
    int price;
    String name;
    int address;
    int likes;
    Integer userid;
}
