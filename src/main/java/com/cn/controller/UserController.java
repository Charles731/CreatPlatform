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

    @RequestMapping("/regist")
    public String regist(User user, Model model) {

        System.out.println("用户注册：" + user.getU_name()+user.getPassword());
        boolean isSuccess = false;
        isSuccess = userService.regist(user);

        if(isSuccess) {
            model.addAttribute("msg", "注册成功");
            //注册后成功跳转success.jsp页面
            return "registSuccess";
        }
        return "fail";
    }

    @RequestMapping("/login")
    public String login(String u_name, String password, Model model) {
        System.out.println("用户登录 " + "账号：" + u_name + " 密码：" + password);
        boolean isUserExist = false;
        isUserExist = userService.login(u_name,password);
        System.out.println("isUserExist----->" + isUserExist);
        if(isUserExist) {
            model.addAttribute("u_name",u_name);
            model.addAttribute("password",password);
            return "success";
        }
        return "fail";

    }

}
