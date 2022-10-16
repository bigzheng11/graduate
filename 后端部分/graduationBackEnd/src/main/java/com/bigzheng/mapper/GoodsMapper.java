package com.bigzheng.mapper;

import com.bigzheng.entity.Address;
import com.bigzheng.entity.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper{

    //根据goodsID查询商品详细信息
    @Select("SELECT * from goods where goodsId = #{goodsId}")
    Goods getGoodsById(Long goodsId);

    //根据userID获取用户所有商品
    @Select("SELECT * from goods where userID = #{userID}")
    List<Goods> getAllGoods(Long userID);

    //根据「分类」获得 n 个goods
    @Select("SELECT * from goods where goodsClassify = #{goodsClassify} and userID!=#{loginUserID} LIMIT  #{n}")
    List<Goods> getRecommendGoods(Goods goods);

    //新建订单模板
//    @Options(useGeneratedKeys = true,keyProperty = "goodsID")
    @Insert("insert into goods values (null,#{userID},null,null,null,null,null,0,1,null )")
    int addGoodsModel(Long userID);

    //查询刚增加的goodsID
    @Select("SELECT goodsID from goods  ORDER BY goodsID  desc LIMIT 1")
    String selectNewId();

    //「更新」更新模板订单
    @Update("update goods set goodsName = #{goodsName},goodsDescribe = #{goodsDescribe},goodsClassify = #{goodsClassify},price = #{price} where goodsID=#{goodsID}")
    int updataModel(Goods goods);

    // 「☢ -后台」查询所有商品
    @Select("SELECT * from `goods`")
     List<Goods> backstageSelectAll();

    // 「☢ -后台」根据goodsID删除商品
    @Update("update goods set deleteTag = 0 where goodsID=#{goodsID}")
    int backstageDeleteById(Long goodsID) ;

    // 「☢ -后台」根据goodsID更新商品信息
    @Update("update goods set goodsName=#{goodsName},goodsDescribe=#{goodsDescribe},goodsClassify=#{goodsClassify},price=#{price}, deleteTag = #{deleteTag} where goodsID=#{goodsID}")
    int backstageUpdataById(Goods goods);

}
