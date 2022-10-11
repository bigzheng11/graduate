package com.bigzheng.controller;
import com.bigzheng.entity.*;
import com.bigzheng.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        //新建模板表
        int num=goodsService.addGoodsModel(userID);
        if (num==1){
            //查询新建模板表的goodsID
            String goodsIDNew=goodsService.selectNewId();
            return goodsIDNew;
        }else {
            return "更新失败";
        }
    }

    //更新模板
    @PostMapping("/updatamodel")
    public String updataModel(Goods goods){
        int result=goodsService.updataModel(goods);
        System.out.println("======================");
        System.out.println(result);
        System.out.println("======================");
        return "成功";
    }

    // 「☢ -后台」查询所有商品
    @GetMapping("/backstageselectall")
    public List<Goods> backstageSelectAll() {
        List<Goods> goodsList = goodsService.backstageSelectAll();
        return goodsList;
    }

    // 「☢ -后台」根据goodsID修改deleteTag为0
    @GetMapping("/backstageDeleteById/{goodsID}")
    public int backstageDeleteById(@PathVariable Long goodsID) {
        int i  = goodsService.backstageDeleteById(goodsID);
        return i;
    }

    // 「☢ -后台」根据goodsID更新商品信息
    @PostMapping("/backstageUpdataById")
    public int backstageUpdataById(@RequestBody Goods goods) {
        System.out.println("=================接收到的参数===============");
        System.out.println(goods);
        System.out.println("================接收到的参数================");
        int i  = goodsService.backstageUpdataById(goods);
        System.out.println("=================更新===============");
        System.out.println(i);
        System.out.println("================更新================");
        return i;
    }

}