package com.cn.service;

import com.cn.dao.AdminDao;
import com.cn.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务层
 * @author vook
 * @date 2017/11/15 15:59
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    public boolean adLogin(String a_name, String a_password) {
        boolean isAdminExist = false;
        Admin admin = adminDao.findAdminByNameAndPwd(a_name, a_password);
        System.out.println("Admin------>" + admin);
        if(admin != null) {
            isAdminExist = true;
            System.out.println("admin.a_password------------->" +adminDao.findAdminByNameAndPwd(a_name, a_password).getA_password());
            return isAdminExist;
        }

        return isAdminExist;
    }
}
