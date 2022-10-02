package com.bigzheng.service;
import com.bigzheng.entity.Interest;
import java.util.List;

public interface InterestService {
    //获取最喜欢的前8个类型
    List<Interest> topSixInterest(Long userID);
}
