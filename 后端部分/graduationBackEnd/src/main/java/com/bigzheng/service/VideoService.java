package com.bigzheng.service;


import com.bigzheng.entity.Address;
import com.bigzheng.entity.Video;
import org.apache.ibatis.annotations.Insert;

public interface VideoService {
    //「根据goodsID」获取视频
    Video getAllvideo(Long goodsID) ;

    // 「add」根据goodsID和video地址 新增视频
    int addVideo(Video video);
}
