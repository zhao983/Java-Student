package com.itjava.demo8test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    //写入一些电影的基本信息
    private String name;  //名字
    private double score;  //评分
    private String actors;  //主演
    private double price;  //票价
}
