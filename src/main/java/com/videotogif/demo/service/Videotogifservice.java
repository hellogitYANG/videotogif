package com.videotogif.demo.service;

import com.videotogif.demo.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

public interface Videotogifservice {
    public ResultVO videotogif(MultipartFile file);
}
