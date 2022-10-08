package com.bigzheng.controller;
import com.bigzheng.common.R;
import com.bigzheng.entity.*;
import com.bigzheng.service.MessageService;
import com.bigzheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    //「所有列表」根据goodsID获得所有留言
    @GetMapping("/getall/{goodsID}")
    public R getAllMessage(@PathVariable Long goodsID){
        List<Message> messageList = messageService.getAllMessage(goodsID);
        for (int i = 0; i < messageList.size(); i++) {
            User user = userService.getUserByUserId(messageList.get(i).getUserID());
            messageList.get(i).setUser(user);
        }
        return  R.ok().data("messageList",messageList);
    }

    //「修改」修改留言点赞数
    @PostMapping("/update")
    public R updateFavour(Message message) {
        messageService.updateFavour(message);
        return R.ok();
    }

    // 「新增」 新增留言
    @PostMapping("/add")
    public R addMessage(Message message) {
        messageService.addMessage(message);
        return R.ok();
    }







}

