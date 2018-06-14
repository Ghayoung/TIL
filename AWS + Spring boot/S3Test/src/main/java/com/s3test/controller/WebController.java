package com.s3test.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.s3test.service.S3Uploader;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class WebController {

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    //view에서 파일을 받아 파일 업로드 실행
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public void upload(@RequestBody MultipartFile file) throws IOException {
    	S3Uploader s3Uploader = new S3Uploader();
        s3Uploader.upload(file);
    }

}