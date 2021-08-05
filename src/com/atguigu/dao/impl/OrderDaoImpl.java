package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

/**
 * @author apple
 * @create 2021-05-17 下午8:56
 */
public class OrderDaoImpl extends BaseDAO implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,`status`,user_id) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreatTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
