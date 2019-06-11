package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("uploadFile1")
    public void uploadFile1(MultipartFile uploadFile) throws IOException {
        System.out.println(uploadFile.getName());
        System.out.println(uploadFile.getContentType());
        System.out.println(uploadFile.getOriginalFilename());
        System.out.println(uploadFile.getSize());
        uploadFile.transferTo(new File("D:\\iotest\\"+uploadFile.getOriginalFilename()));
    }
}
