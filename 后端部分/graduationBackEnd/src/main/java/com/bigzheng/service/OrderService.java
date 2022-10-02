package com.bigzheng.service;
import com.bigzheng.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import java.util.List;
public interface OrderService {
    //「all-list」查询userID所有历史订单
    List<Order> getAllOrder(Long userID);

    //「添加」 添加数量,商品ID,用户ID,到历史订单
    int addOrder(Order order) ;


}
