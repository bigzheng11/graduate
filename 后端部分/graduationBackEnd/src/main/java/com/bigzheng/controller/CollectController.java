package com.bigzheng.controller;
import com.bigzheng.common.R;
import com.bigzheng.entity.Address;
import com.bigzheng.entity.Collect;
import com.bigzheng.mapper.CollectMapper;
import com.bigzheng.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    //「所有列表」根据userID获得所有收藏
    @GetMapping("/getall/{userID}")
    public R getAllCollect(@PathVariable Long userID){
        List<Collect> collectList = collectService.getAllCollect(userID);
        return  R.ok().data("collectList",collectList);
    }

    //「添加」根据传入对象添加收藏
    @PostMapping("/add")
    public R addCollect(Collect collect) {
        int i = collectService.addCollect(collect);
            return R.ok();
    }

    //「修改」根据userID和goodID和isCollect,修改订单状态
    @PostMapping("/changeiscollect")
    public R changeIsCollect(Collect collect) {
        collectService.changeIsCollect(collect);
        return R.ok();
    }



}

