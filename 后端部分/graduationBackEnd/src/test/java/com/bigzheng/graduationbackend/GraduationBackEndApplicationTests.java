package com.bigzheng.graduationbackend;

import com.bigzheng.entity.User;
import com.bigzheng.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GraduationBackEndApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = new User();
        user.setUserID(15333888L);
        user.setUserName("zhouzhengwei1");
        user.setPassword("12345678");
        user.setUserSex(1);
        user.setUserImg("2222222222222");
        int i = userMapper.saveUser(user);
    }

}
