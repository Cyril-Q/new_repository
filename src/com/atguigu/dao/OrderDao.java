package com.atguigu.dao;

import com.atguigu.pojo.Order;

/**
 * @author apple
 * @create 2021-05-17 下午8:54
 */
public interface OrderDao {
    public int saveOrder(Order order);
}
