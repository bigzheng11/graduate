package com.bigzheng.controller;
import com.bigzheng.entity.*;
import com.bigzheng.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;


    //通过goodsId订单编号 获得订单的详细信息
    @GetMapping("/getById/{goodsID}")
    public Goods getGoodsById(@PathVariable Long goodsID){
        //商品信息
        Goods goods = goodsService.getGoodsById(goodsID);
        //图片信息
        List<Picture> pictureList = pictureService.getAllPicture(goodsID);
        //视频信息
        Video video = videoService.getAllvideo(goodsID);
        //商品评论-用户信息
        List<Message> messageList = messageService.getAllMessage(goodsID);
        for (int i = 0; i < messageList.size(); i++) {
            User user2 = userService.getUserByUserId(messageList.get(i).getUserID());
            messageList.get(i).setUser(user2);
        }
        //卖家信息
        User user = userService.getUserByUserId(goods.getUserID());

        goods.setPicList(pictureList);
        goods.setVideo(video);
        goods.setUser(user);
        goods.setMessagesList(messageList);
        System.out.println("============================================");
        System.out.println(goods);
        System.out.println("============================================");
        return goods;
    }

    //根据userID获取用户所有商品
    @GetMapping("/getall/{userID}")
    public List<Goods> getAllGoods(@PathVariable Long userID){
        List<Goods> goodsList=goodsService.getAllGoods(userID);
        for (int i = 0; i < goodsList.size(); i++) {
            List<Picture> pictureList = pictureService.getAllPicture(goodsList.get(i).getGoodsID());
            goodsList.get(i).setPicList(pictureList);
        }
        return goodsList;
    }

    //新建订单模板
    @GetMapping("/addmodel/{userID}")
    public String addGoodsModel(@PathVariable Long userID){

        String test=goodsService.selectNewId();
        System.out.println(test);
        return test;
    }




}