package com.bigzheng.service;

import com.bigzheng.entity.Picture;

import java.util.List;


public interface PictureService {

    //「all-list」获取所有图片列表
    List<Picture> getAllPicture(Long goodsID);
}
