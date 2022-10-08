package com.bigzheng.mapper;

import com.bigzheng.entity.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
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
    @Select("SELECT * from goods where goodsClassify = #{goodsClassify}  LIMIT  #{n}")
    List<Goods> getRecommendGoods(Goods goodsParameter);

    //新建订单模板
    @Insert("insert into goods values (null,#{userID}")
    @Options(useGeneratedKeys = true,keyProperty = "goodsID")
    String addGoodsModel(Long userID);

    //查询刚增加的goodsID
    @Select("SELECT goodsID from goods  ORDER BY goodsID    desc LIMIT 1")
    String selectNewId();

}
