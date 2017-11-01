package com.cn.controller;

import com.cn.entity.User;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by User on 2017/10/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    //注入Service
    @Autowired
    private UserService userService;

    @RequestMapping("regist")
    public String regist(User user, Model model) {

        System.out.println("用户注册：" + user.getU_name()+user.getPassword());
        userService.regist(user);

        model.addAttribute("msg", "注册成功");
        //注册后成功跳转success.jsp页面
        return "success";
    }

    @RequestMapping
    public String login(String name, String password, Model model) {
        System.out.println("用户登录" + name + password);

        userService.login(name,password);
        model.addAttribute("msg", "登陆成功");

        return "success";
    }

}
