package com.bigzheng.controller;

import com.bigzheng.entity.Picture;
import com.bigzheng.entity.Video;
import com.bigzheng.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    //根据goodsID获得对应视频
    public Video getVideoById(@PathVariable Long goodsID){
        Video video = videoService.getAllvideo(goodsID);
        return video;
    }

}

