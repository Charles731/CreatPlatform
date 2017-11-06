package com.cn.service;

import com.cn.dao.UserDao;
import com.cn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 业务层
 * Created by User on 2017/10/31.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void regist(User user) {
        userDao.addUser(user);
    }

    public void login(String name, String password) {
        userDao.findUserByNameAndPwd(name, password);
    }
}
