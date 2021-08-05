package com.atguigu.dao.impl;

import com.atguigu.dao.UserDAO;
import com.atguigu.pojo.User;

/**
 * @author apple
 * @create 2021-04-17 下午9:15
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username,`password`,email from t_user where username = ?";
        return queryForOne(sql,User.class,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,`password`,email from t_user where username = ? and password = ?";
        return queryForOne(sql,User.class,username,password);

    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,`password`,email) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
