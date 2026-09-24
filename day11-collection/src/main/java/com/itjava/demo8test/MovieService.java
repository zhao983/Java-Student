package com.itjava.demo8test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    private static Scanner sc = new Scanner(System.in);
    //需要准备一个集合容器，存放所有的电影
    private static List<Movie> movies = new ArrayList<>();

    static {
        movies.add(new Movie("抓娃娃", 5.6, "某凡，沈腾", 60));
        movies.add(new Movie("抓娃娃2", 4.6, "某凡，沈腾", 60));
        movies.add(new Movie("霸王别姬", 8.6, "张国荣", 60));
    }

    public void start() {

        operation();
    }

    //需要展示一个页面
    private void show() {
        System.out.println("电影信息操作系统");
        System.out.println("1.上架电影");
        System.out.println("2.查询电影");
        System.out.println("3.下架某部电影");
        System.out.println("4.下架某个主演参演的全部电影");
        System.out.println("5.展示全部电影");
        System.out.println("6.修改某部电影信息");
        System.out.println("7.退出");
        System.out.println("请输入您要进行的操作:");
    }

    //选择操作实现
    private void operation() {
        while (true) {
            show();
            String i = sc.next();
            //需要设计选择的实现
            switch (i) {
                case "1":
                    //1.上架电影
                    addMovie();  //独立功能独立成方法
                    break;
                case "2":
                    //2.查询电影
                    queryMovie();
                    break;
                case "3":
                    //3.下架某部电影
                    deleteMovie();
                    break;
                case "4":
                    //4.下架某个主演参演的全部电影
                    deleteActorMovie();
                    break;
                case "5":
                    //5.展示全部电影
                    showAllMovie();
                    break;
                case "6":
                    //6.修改某部电影信息
                    changeMovie();
                    break;
                case "7":
                    return;
                default:
                    System.out.println("输入有误！");
            }
        }
    }

    //1.上架电影
    private void addMovie() {
        //要把输入的东西包装成一个对象
        Movie movie = newMovie();
        //把输入的电影信息加到集合中去
        movies.add(movie);
        System.out.println("上架完成");
    }

    //2.查询电影
    private void queryMovie() {
        System.out.println("请输入要查询的电影名称:");
        String name = sc.next();
        // 记录是否找到电影，默认没有找到
        boolean found = false;

        for (Movie movie : movies) {
            if (movie.getName().contains(name)) {
                System.out.println(movie);

                // 找到电影，修改标记
                found = true;
            }
        }

        // 遍历结束后，如果仍然没有找到电影
        if (!found) {
            System.out.println("没有该电影");
        }
    }


    //3.下架某部电影
    private void deleteMovie() {
        System.out.println("请输入要下架的电影名称:");
        String name = sc.next();

        boolean found = false;
        //要下架就用迭代器遍历或者之前的索引减一或者倒序删除
        Iterator<Movie> movieIterator = movies.iterator();
        while (movieIterator.hasNext()) {
            Movie movie = movieIterator.next();
            if (movie.getName().equals(name)) {
                movieIterator.remove();
                // 找到电影，修改标记
                found = true;
            }
        }

        // 遍历结束后，如果仍然没有找到电影
        if (!found) {
            System.out.println("没有该电影");
        }
    }

    //4.下架某个主演参演的全部电影
    private void deleteActorMovie() {

        boolean found = false;
        System.out.println("请输入要下架的主演的名称:");
        String name = sc.next();
        //要下架就用迭代器遍历或者之前的索引减一或者倒序删除
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getActors().contains(name)) {
                movies.remove(movie);
                i--;

                // 找到电影，修改标记
                found = true;
            }

        }

        // 遍历结束后，如果仍然没有找到电影
        if (!found) {
            System.out.println("没有该电影");
        } else {
            System.out.println("下架成功");

        }

    }

    //5.展示全部电影
    private void showAllMovie() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    //6.修改某部电影信息
    private void changeMovie() {
        boolean found = false;
        System.out.println("请输入要修改的电影名称:");
        String name = sc.next();

        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getName().equals(name)) {
                Movie m = newMovie();
                movies.set(i,m);
                // 找到电影，修改标记
                found = true;
            }

        }

        // 遍历结束后，如果仍然没有找到电影
        if (!found) {
            System.out.println("没有该电影");
        } else {
            System.out.println("修改成功");

        }
    }

    //创建新的电影对象
    private Movie newMovie(){
        Movie movie = new Movie();
        System.out.println("请输入电影名字:");
        movie.setName(sc.next());
        System.out.println("请输入电影评分:");
        movie.setScore(sc.nextDouble());
        System.out.println("请输入电影主演:");
        movie.setActors(sc.next());
        System.out.println("请输入电影票价:");
        movie.setPrice(sc.nextDouble());
        return movie;
    }

}
