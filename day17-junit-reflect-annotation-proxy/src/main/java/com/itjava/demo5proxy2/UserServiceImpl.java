package com.itjava.demo5proxy2;

/**
 * 用户业务实现类（面向接口编程）
 */
public class UserServiceImpl implements UserService {

    @Override
    public void login(String loginName, String passWord) throws Exception {
//        long start = System.currentTimeMillis();  //有了代理后就不需要这样的重复代码,实现类也能更专注于自己原本的任务

        if ("admin".equals(loginName) && "123456".equals(passWord)) {
            System.out.println("您登录成功，欢迎光临本系统~");
        } else {
            System.out.println("您登录失败，用户名或密码错误~");
        }
        Thread.sleep(1000);
//        long end = System.currentTimeMillis();
//        System.out.println("login方法耗时：" + (end - start) / 1000.0 + "秒");
    }

    @Override
    public void deleteUsers() throws Exception {
//        long start = System.currentTimeMillis();

        System.out.println("成功删除了1万个用户~");
        Thread.sleep(1500);

//        long end = System.currentTimeMillis();
//        System.out.println("selectUsers方法耗时：" + (end - start) / 1000.0 + "秒");
    }

    @Override
    public String[] selectUsers() throws Exception {
//        long start = System.currentTimeMillis();

        System.out.println("查询出了3个用户");
        String[] names = {"张全蛋", "李二狗", "牛爱花"};
        Thread.sleep(500);

//        long end = System.currentTimeMillis();
//        System.out.println("selectUsers方法耗时：" + (end - start) / 1000.0 + "秒");
        return names;
    }
}
