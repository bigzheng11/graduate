package com.bigzheng.service;

import com.bigzheng.entity.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GoodsService {

    //根据goodsID查询商品详细信息
    Goods getGoodsById(Long goodsID);

    //根据userID获取用户所有商品
    List<Goods> getAllGoods(Long userID);

    //根据userID获取用户所有商品
    List<Goods> getRecommendGoods(Goods goodsParameter);

    //新建订单模板
    int addGoodsModel(Long userID);

    //查询刚增加的goodsID
    String selectNewId();

    //「更新」更新模板订单
    int updataModel(Goods goods);

    // 「☢ -后台」查询所有商品
    List<Goods> backstageSelectAll();

    // 「☢ -后台」根据goodsID删除商品
    int backstageDeleteById(Long goodsID) ;

    // 「☢ -后台」根据goodsID更新商品信息
    int backstageUpdataById(Goods goods);
}
