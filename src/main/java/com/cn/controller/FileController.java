package com.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 2017/10/26.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/toFile")
    public String toFileUpload() {
        return "fileUpload";
    }

    @RequestMapping("/toFile2")
    public String toFileUpload2() {
        return "fileUpload2";
    }

    @RequestMapping("oneFile")
    public String toFileUpload(@RequestParam("file")CommonsMultipartResolver file,
                               HttpServletRequest request, Model model) {
        //String fileName = file.getOriginalFilename();
    }

}
