package com.bigzheng.service;

import com.bigzheng.entity.User;
import org.apache.ibatis.annotations.Update;

public interface UserService {
    //根据userID获取user的所有信息
    public User getUserByUserId(Long userId);

    //「注册」新增用户信息
    public int saveUser(User user);

    //「更新」根据user更新用户信息
    public int updateUser(User user);

    //图片上传
    Integer insertPhoto(User s);

}
