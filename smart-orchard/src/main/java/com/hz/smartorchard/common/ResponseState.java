package com.hz.smartorchard.common;

public interface ResponseState {

    /**
     *  500 服务器错误
     *  403 无权限
     *  401 未登录
     *  200 成功
     */
    int SERVER_ERROR = 500;
    int WITHOUT_PERMISSION = 403;
    int NOT_LOGGED_IN = 401;
    int SUCCESS_CODE = 200;



}
