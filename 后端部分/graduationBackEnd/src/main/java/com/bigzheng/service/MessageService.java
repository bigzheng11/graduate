package com.bigzheng.service;

import com.bigzheng.common.R;
import com.bigzheng.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface MessageService {

    //「所有列表」根据goodsID获得所有留言
    List<Message> getAllMessage(Long goodsID);

    //「修改」修改留言点赞数
    int updateFavour(Message message);

    // 「新增」 新增留言
    int addMessage(Message message);

}
