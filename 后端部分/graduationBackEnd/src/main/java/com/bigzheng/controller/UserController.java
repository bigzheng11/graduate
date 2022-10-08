package com.bigzheng.controller;

import com.bigzheng.common.R;
import com.bigzheng.common.ResultCode;
import com.bigzheng.entity.User;
import com.bigzheng.service.UserService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //「注册验证」根据userID 查询手机号是否已经注册
    //「查询信息」根据userID查询该用户信息
    @GetMapping("/check/{userID}")
    public R check(@PathVariable Long userID){
        User user = userService.getUserByUserId(userID);
        if(user!=null){
            return R.error(ResultCode.USER_HAS_EXIST,"该用户已经存在");
        }else{
            return R.ok();
        }
    }

    //「注册」新增用户信息
    @PostMapping("/save")
    public R saveUser(User user){
        //i为修改的行数
        int i = userService.saveUser(user);
        if(i>0){
            return R.ok();
        }else{
            return R.error(ResultCode.DATA_EXEC_WRONG,"用户注册失败");
        }
    }

    //「登录」根据userID和password判断是否正确,正确则返回所有信息
    @PostMapping("/login")
    public R login(User user){

        User userinfo =  userService.getUserByUserId(user.getUserID());
        if(userinfo!=null){
//            if(userinfo.getPassword().equals(MD5Utils.inputPassToFormPass(user.getPassword()))){
//                //调用JwtUtils工具类生成Token
//                userinfo.setToken(JwtUtils.createToken(userinfo));
//                userinfo.setPassword("");
//                return R.ok().data("userinfo",userinfo);   //登录成功， 重定向到 toHome控制器方法
//            }
            if(userinfo.getPassword().equals(user.getPassword())){
                //密码正确
                userinfo.setPassword("");
                return R.ok().data("userinfo",userinfo);   //登录成功， 重定向到 toHome控制器方法
            }
            //密码错误
            return R.error(ResultCode.USER_ACCOUNT_ERROR,"密码输入错误,请您重新输入");
        }
        return R.error(ResultCode.USER_NOT_EXIST,"未查询到用户信息，请您重新输入");
    }

    //「用户信息」登陆后,根据userID获取用户信息
    @GetMapping("/detail/{userID}")
    public User userDetail(@PathVariable Long userID) {
        User user = userService.getUserByUserId(userID);
        return user;
    }

    //「更新」根据user更新用户信息
    @PostMapping("/update")
    public R updateUser(User user){
        System.out.println("===============================");
        System.out.println("user"+user);
        System.out.println("===============================");
        int i = userService.updateUser(user);
        if(i>0){
            return R.ok();
        }else{
            return R.error(ResultCode.DATA_EXEC_WRONG,"用户更新失败");
        }
    }



}