package com.bigzheng.service.Impl;
import com.bigzheng.entity.User;
import com.bigzheng.mapper.UserMapper;
import com.bigzheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //根据userID查询用户所有信息
    @Override
    public User getUserByUserId(Long userId) {
        return userMapper.getUserByUserId(userId);
    }

    //「注册」新增用户信息
    @Override
    public int saveUser(User user) {
        //使用Md5加密 密码
        //String newPass = MD5Utils.inputPassToFormPass(user.getPassword());
        //user.setPassword(newPass);
        return userMapper.saveUser(user);
    }

    //「更新」根据user更新用户信息
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Integer insertPhoto(User s) {
        return null;
    }

    //图片上传
//    public Integer insertPhoto(User s){
//        return userMapper.insertPhoto(s);
//    }
}