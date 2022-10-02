package com.bigzheng.entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Long userID;      //手机号
    private String password;  //密码
    private String userName;  //用户名
    private Integer userSex;  //性别
    private String userImg;   //用户头像
}