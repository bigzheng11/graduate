package com.bigzheng.service.Impl;

import com.bigzheng.entity.Order;
import com.bigzheng.mapper.OrderMapper;
import com.bigzheng.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2022-09-26 11:06:54
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    //「all-list」查询userID所有历史订单
    @Override
    public List<Order> getAllOrder(Long userID) {
        return orderMapper.getAllOrder(userID);
    }

    //「添加」 添加数量,商品ID,用户ID,到历史订单
    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }
}
