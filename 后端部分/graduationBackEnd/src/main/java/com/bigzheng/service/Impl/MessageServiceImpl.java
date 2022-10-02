package com.bigzheng.service.Impl;

import com.bigzheng.entity.Message;
import com.bigzheng.mapper.MessageMapper;
import com.bigzheng.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;


}
