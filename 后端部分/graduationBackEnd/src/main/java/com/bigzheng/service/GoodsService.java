package com.bigzheng.service;

import com.bigzheng.entity.Goods;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsService {

    //根据goodsID查询商品详细信息
    Goods getGoodsById(Long goodsID);

    //根据userID获取用户所有商品
    List<Goods> getAllGoods(Long userID);

    //根据userID获取用户所有商品
    List<Goods> getRecommendGoods(Goods goodsParameter);
}
