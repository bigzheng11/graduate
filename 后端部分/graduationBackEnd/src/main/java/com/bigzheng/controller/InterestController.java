package com.bigzheng.controller;
import com.bigzheng.common.R;
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
    @Autowired
    private MessageService messageService;

    //获取最喜欢的前8个类型
    @GetMapping("/topSixInterest/{userID}")
    public List<Goods>  topSixInterest(@PathVariable Long userID){
        //获取用户兴趣列表
        List<Interest> interestList=interestService.topSixInterest(userID);
        System.out.println("======================================");
        System.out.println("获得的兴趣列表"+interestList);
        System.out.println("======================================");
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
            goodsParameter.setGoodsClassify(interestList.get(i).getGoodsClassify());
            goodsParameter.setN(n);
            goodsParameter.setLoginUserID(userID);
            List<Goods> RecommendGoodsListTemp= goodsService.getRecommendGoods(goodsParameter);
            //商品添加图片和视频
            for (int j = 0; j < RecommendGoodsListTemp.size(); j++) {
                List<Picture> pictureList = pictureService.getAllPicture(RecommendGoodsListTemp.get(j).getGoodsID());
                RecommendGoodsListTemp.get(j).setPicList(pictureList);

                Video video = videoService.getAllvideo(RecommendGoodsListTemp.get(j).getGoodsID());
                RecommendGoodsListTemp.get(j).setVideo(video);

                User user = userService.getUserByUserId(RecommendGoodsListTemp.get(j).getUserID());
                RecommendGoodsListTemp.get(j).setUser(user);

                List<Message> messageList = messageService.getAllMessage(RecommendGoodsListTemp.get(j).getGoodsID());
                for (int k = 0; k < messageList.size(); k++) {
                        User user2 = userService.getUserByUserId(messageList.get(k).getUserID());
                    messageList.get(k).setUser(user2);
                }
                RecommendGoodsListTemp.get(j).setMessagesList(messageList);
            }
            //添加进returnList中
           returnList.addAll(RecommendGoodsListTemp);
        }
        //returnList乱序
        Collections.shuffle(returnList);
        return returnList;
    }

    //「更新」激励加分-根据userID和goodsClassify,对grade更新
    @PostMapping("/update")
    public R updateGrade(Interest interest) {
        interestService.updateGrade(interest);
        return R.ok();
    }

    //获取最喜欢的前8个类型
    @GetMapping("/backstage/{userID}")
    public List<Interest>  backstageSelectByUserID(@PathVariable Long userID){
      List<Interest>  interestList=interestService.topSixInterest(userID);
      return interestList;


    }


}

