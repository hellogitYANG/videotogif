package com.videotogif.demo.controller;

import com.videotogif.demo.service.Videotogifservice;
import com.videotogif.demo.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/gif")
public class Videotogifcontroller {

    @Autowired
    Videotogifservice videotogifservice;
    @PostMapping("/add")
    private ResultVO addList(MultipartFile multipartFile){
        return videotogifservice.videotogif(multipartFile);
    }
}
