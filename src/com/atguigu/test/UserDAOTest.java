package com.atguigu.test;

import com.atguigu.dao.UserDAO;
import com.atguigu.dao.impl.UserDAOImpl;
import com.atguigu.pojo.User;
import org.junit.Test;


/**
 * @author apple
 * @create 2021-04-17 下午9:34
 */
public class UserDAOTest {
    UserDAO userDAO = new UserDAOImpl();

    @Test
    public void queryUserByUsername() {
        if (userDAO.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDAO.queryUserByUsernameAndPassword("admin1","admin") == null) {
            System.out.println("用户名或密码错误，登录失败！");
        } else {
            System.out.println("登陆成功！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDAO.saveUser(new User(null, "ys", "123456", "ys@qq.com")));
    }
}