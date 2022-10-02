package com.bigzheng.common;

//返回的状态码
public interface ResultCode {
    // 成功状态码
    public static final Integer SUCCESS = 1;

    // -------------------失败状态码----------------------
    // 参数错误
    public static final Integer PARAMS_IS_NULL = 10001;// 参数为空
    public static final Integer PARAMS_NOT_COMPLETE = 10002; // 参数不全
    public static final Integer PARAMS_TYPE_ERROR = 1003; // 参数类型错误
    public static final Integer PARAMS_IS_INVALID = 10004; // 参数无效

    // 用户错误
    public static final Integer USER_NOT_EXIST = 20001; // 用户不存在
    public static final Integer USER_NOT_LOGGED_IN = 20002; //用户未登陆
    public static final Integer USER_ACCOUNT_ERROR = 20003; //密码错误
    public static final Integer USER_ACCOUNT_FORBIDDEN = 20004; //用户账户已被禁用
    public static final Integer USER_HAS_EXIST = 20005;// 用户已存在
    public static final Integer USER_HAS_EXPIRED = 20006; //用户过期,toKen过期

    // 业务错误
    public static final Integer BUSINESS_ERROR = 30001;// 系统业务出现问题

    // 系统错误
    public static final Integer SYSTEM_INNER_ERROR = 40001; // 系统内部错误

    // 数据错误
    public static final Integer DATA_NOT_FOUND = 50001; // 数据未找到
    public static final Integer DATA_IS_WRONG = 50002;// 数据有误
    public static final Integer DATA_ALREADY_EXISTED = 50003;// 数据已存在
    public static final Integer DATA_EXEC_WRONG = 50004;   //数据执行操作有误

    // 接口错误
    public static final Integer INTERFACE_INNER_INVOKE_ERROR = 60001; // 系统内部接口调用异常
    public static final Integer INTERFACE_OUTER_INVOKE_ERROR = 60002;// 系统外部接口调用异常
    public static final Integer INTERFACE_FORBIDDEN = 60003;// 接口禁止访问
    public static final Integer INTERFACE_ADDRESS_INVALID = 60004;// 接口地址无效
    public static final Integer INTERFACE_REQUEST_TIMEOUT = 60005;// 接口请求超时
    public static final Integer INTERFACE_EXCEED_LOAD = 60006;// 接口负载过高

    // 权限错误
    public static final Integer PERMISSION_NO_ACCESS = 70001;// 没有访问权限
}
