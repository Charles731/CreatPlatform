package com.cn.controller;

import com.cn.entity.Admin;
import com.cn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author vook
 * @date 2017/11/15 16:14
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    //注入Service
    @Autowired
    private AdminService adminService;

//    @RequestMapping("/adLogin")
//    public String adLogin(String a_name, String a_password, Model model) {
//        System.out.println("管理员登录 " + "账号：" + a_name + " 密码：" + a_password);
//        boolean isAdminExist = false;
//        isAdminExist = adminService.adLogin(a_name,a_password);
//        System.out.println("isAdminExist----->" + isAdminExist);
//        if(isAdminExist) {
//            model.addAttribute("a_name",a_name);
//            model.addAttribute("a_password",a_password);
//            return "success";
//        }
//        return "fail";
//
//    }
      @RequestMapping("/adLogin")
      @ResponseBody
      public Admin adLogin(@RequestBody Admin requestAdmin) {
           String a_name = requestAdmin.getA_name();
           String a_password = requestAdmin.getA_password();
           boolean isAdminExist = false;
           Admin admin = adminService.adLogin(a_name,a_password);
           System.out.println("isAdminExist----->" + isAdminExist);
           return admin;
     }

    @RequestMapping("/deleteUser/{u_id}")
    @ResponseBody
    public boolean deleteUser(@PathVariable("u_id")int u_id) {
        boolean isSuccess = false;
        isSuccess = adminService.deleteUser(u_id);
        return isSuccess;
    }
}
