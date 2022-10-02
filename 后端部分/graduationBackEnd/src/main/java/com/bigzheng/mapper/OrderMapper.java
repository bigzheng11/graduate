package com.bigzheng.mapper;

import com.bigzheng.common.R;
import com.bigzheng.entity.Address;
import com.bigzheng.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    //「all-list」查询userID所有历史订单
    @Select("SELECT * from `order` where userID = #{userID}")
    List<Order> getAllOrder(Long userID);

     //「添加」 添加数量,商品ID,用户ID,到历史订单
     @Insert("insert into `order` values (null ,#{userID},#{goodsID},#{quantity})")
     @Options(useGeneratedKeys = true,keyProperty = "orderID")
     int addOrder(Order order) ;


}
