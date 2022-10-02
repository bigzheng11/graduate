package com.bigzheng.mapper;

import com.bigzheng.entity.Order;
import com.bigzheng.entity.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PictureMapper {

    //「all-list」获取所有图片列表
    @Select("SELECT * from `picture` where goodsID = #{goodsID}")
    List<Picture> getAllPicture(Long goodsID);
}
