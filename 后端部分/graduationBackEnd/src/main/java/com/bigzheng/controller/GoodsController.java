package com.bigzheng.controller;
import com.bigzheng.entity.Goods;
import com.bigzheng.entity.Picture;
import com.bigzheng.entity.Video;
import com.bigzheng.service.GoodsService;
import com.bigzheng.service.PictureService;
import com.bigzheng.service.VideoService;
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

    //通过goodsId订单编号 获得订单的详细信息
    @GetMapping("/getById/{goodsID}")
    public Goods getGoodsById(@PathVariable Long goodsID){
        Goods goods = goodsService.getGoodsById(goodsID);
        List<Picture> pictureList = pictureService.getAllPicture(goodsID);
        Video video = videoService.getAllvideo(goodsID);
        goods.setPicList(pictureList);
        goods.setVideo(video);
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




}