package com.bigzheng.service;
import com.bigzheng.entity.Interest;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface InterestService {
    //获取最喜欢的前8个类型
    List<Interest> topSixInterest(Long userID);

    //「更新」激励加分-根据userID和goodsClassify,对grade更新
    int updateGrade(Interest interest);
}
