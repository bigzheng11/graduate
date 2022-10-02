package com.bigzheng.controller;
import com.bigzheng.entity.Interest;
import com.bigzheng.service.GoodsService;
import com.bigzheng.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Recommend")
public class RecommendMainController {
    @Autowired
    private InterestService interestService;
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/topSixInterest/{userID}")
    public List<Interest> topSixInterest(@PathVariable Long userID){
        List<Interest> interestList=interestService.topSixInterest(userID);
        return interestList;
    }

}