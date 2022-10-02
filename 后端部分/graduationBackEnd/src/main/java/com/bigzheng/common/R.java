package com.bigzheng.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

//结果类
@Getter
@Setter
@ToString
public class R {
    private boolean success;
    private Integer code;
    private String message;

    //data: Map 名-值映射
    private Map<String,Object> data = new HashMap<String,Object>();

    //成功操作，返回结构：
    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(com.bigzheng.common.ResultCode.SUCCESS);  //设置状态码为1，代码成功。
        r.setMessage("请求成功");
        return r;
    }

    //失败操作，返回结构
    public  static R error(Integer code,String message){
        R r = new R();
        r.setSuccess(false);
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    //赋值data
    public R data(String key,Object value){
        this.data.put(key,value);
        return this;   //this已经赋值基础数据data，返回R
    }


}
