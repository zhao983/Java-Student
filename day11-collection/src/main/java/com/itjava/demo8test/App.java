package com.itjava.demo8test;
/*综合小案例：电影信息管理模块
    需求
    开发一个电影信息管理模块，用户可以上架电影，查询电影下架某部电影，以及下架某个主演参演的全部电影。
    分析
    每部电影都是一个电影对象，设计电影类。
    需要定义一个电影操作类，其对象专门用于处理电影数据的业务。
    操作类中需要定义一个集合存放全部的电影对象*/

public class App {
    public static void main(String[] args) {
        MovieService movieService = new MovieService();
        movieService.start();

    }
}
