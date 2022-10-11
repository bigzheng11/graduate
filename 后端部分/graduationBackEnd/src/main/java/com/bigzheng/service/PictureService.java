package com.bigzheng.service;

import com.bigzheng.entity.Picture;
import org.apache.ibatis.annotations.Insert;

import java.util.List;


public interface PictureService {

    //「all-list」获取所有图片列表
    List<Picture> getAllPicture(Long goodsID);

    // 「add」根据goodsID和picture地址 新增图片
    int addPicture(Picture picture);
}
