package com.atguigu.test;

import java.lang.reflect.Method;

/**
 * @author apple
 * @create 2021-04-23 下午9:30
 */
public class UserServletTest {
    public void login() {
        System.out.println("login()方法调用了");
    }
    public void regist() {
        System.out.println("regist()方法调用了");
    }
    public void updateUserName() {
        System.out.println("updateUserName()方法调用了");
    }
    public void updateUserPassword() {
        System.out.println("updateUserPassword()方法调用了");
    }

    public static void main(String[] args) {
        String action = "regist";
        try {
            //通过方法获取反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            //调用目标方法
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
