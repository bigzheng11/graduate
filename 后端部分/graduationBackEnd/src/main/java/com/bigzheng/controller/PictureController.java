package com.bigzheng.controller;
import com.bigzheng.entity.Picture;
import com.bigzheng.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    //「all-list」根据goodsID获取所有图片列表
    @GetMapping("/getpic/{goodsID}")
    public List<Picture> allPicture(@PathVariable Long goodsID){
        List<Picture> pictureList = pictureService.getAllPicture(goodsID);
        return pictureList;
    }

}

