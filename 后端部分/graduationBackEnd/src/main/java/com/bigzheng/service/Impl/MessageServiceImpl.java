package com.bigzheng.service.Impl;

import com.bigzheng.common.R;
import com.bigzheng.entity.Message;
import com.bigzheng.mapper.MessageMapper;
import com.bigzheng.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> getAllMessage(Long goodsID) {
        return messageMapper.getAllMessage(goodsID);
    }

    @Override
    public int updateFavour(Message message) {
        return messageMapper.updateFavour(message);
    }

    @Override
    public int addMessage(Message message) {
        return messageMapper.addMessage(message);
    }
}
