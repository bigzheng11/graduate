package com.bigzheng.controller;
import com.bigzheng.common.R;
import com.bigzheng.entity.Goods;
import com.bigzheng.entity.Order;
import com.bigzheng.entity.Picture;
import com.bigzheng.service.GoodsService;
import com.bigzheng.service.OrderService;
import com.bigzheng.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PictureService pictureService;

    //「all-list」查询userID所有历史订单
    @GetMapping("/getall/{userID}")
    public R allOrder(@PathVariable Long userID){
        List<Order> orderList = orderService.getAllOrder(userID);
        for (int i = 0; i < orderList.size(); i++) {
            List<Picture> pictureList = pictureService.getAllPicture(orderList.get(i).getGoodsID());
            orderList.get(i).setPicList(pictureList);
            Goods goods = goodsService.getGoodsById(orderList.get(i).getGoodsID());
            orderList.get(i).setGoodsName(goods.getGoodsName());
        }
        return  R.ok().data("orderList",orderList);
    }

    //「添加」 添加数量,商品ID,用户ID,到历史订单
    @PostMapping("/add")
    public R addOrder(Order order) {
        orderService.addOrder(order);
        return R.ok();
        //返回addressID
    }



}

