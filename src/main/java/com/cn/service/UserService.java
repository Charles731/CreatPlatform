package com.cn.service;

import com.cn.entity.User;

/**
 * Created by User on 2017/10/31.
 */
public interface UserService {

    //用户注册
    void regist(User user);
    //用户登录
    void login(String name, String password);
}
