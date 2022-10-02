package com.bigzheng.service;


import com.bigzheng.entity.Address;
import com.bigzheng.entity.Video;

public interface VideoService {
    //「根据goodsID」获取视频
    Video getAllvideo(Long goodsID) ;
}
