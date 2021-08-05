package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
 * @author apple
 * @create 2021-05-17 下午10:23
 */
public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
