package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author apple
 * @create 2021-05-17 下午10:53
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "数据结构预算法", 2, new BigDecimal(100), new BigDecimal(200)));

        OrderService orderService = new OrderServiceImpl();
        System.out.println("订单号是：" + orderService.createOrder(cart, 1));
    }
}