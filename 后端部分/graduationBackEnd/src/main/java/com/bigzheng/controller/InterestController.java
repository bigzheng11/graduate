package com.bigzheng.controller;
import com.bigzheng.entity.*;
import com.bigzheng.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/interest")
public class InterestController {

    @Autowired
    private InterestService interestService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private UserService userService;

    //获取最喜欢的前8个类型
    @GetMapping("/topSixInterest/{userID}")
    public List<Goods>  topSixInterest(@PathVariable Long userID){
        //获取用户兴趣列表
        List<Interest> interestList=interestService.topSixInterest(userID);
        //计算总分
        int totalScore=0;
        for (int i = 0; i < interestList.size(); i++) {
            totalScore+=interestList.get(i).getGrade();
        }

        //依照「分类」和「占比」搜索
        List<Goods> returnList = new ArrayList<Goods>();
        for (int i = 0; i <interestList.size() ; i++) {
            int n;
            //搜索「指定个数」,指定分类的商品
            n = Math.round((float)interestList.get(i).getGrade()/(float)totalScore*10);
            Goods goodsParameter=new Goods();
            goodsParameter.setGoodsClassify(interestList.get(i).getGoodsclassify());
            goodsParameter.setN(n);
            List<Goods> RecommendGoodsListTemp= goodsService.getRecommendGoods(goodsParameter);
            //商品添加图片和视频
            for (int j = 0; j < RecommendGoodsListTemp.size(); j++) {
                List<Picture> pictureList = pictureService.getAllPicture(RecommendGoodsListTemp.get(j).getGoodsID());
                RecommendGoodsListTemp.get(j).setPicList(pictureList);

                Video video = videoService.getAllvideo(RecommendGoodsListTemp.get(j).getGoodsID());
                RecommendGoodsListTemp.get(j).setVideo(video);

                User user = userService.getUserByUserId(RecommendGoodsListTemp.get(j).getUserID());
                RecommendGoodsListTemp.get(j).setUser(user);
            }
            //添加进returnList中
           returnList.addAll(RecommendGoodsListTemp);
        }
        //returnList乱序
        Collections.shuffle(returnList);
        return returnList;
    }
}

