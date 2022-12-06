package com.videotogif.demo.service.impl;

import com.videotogif.demo.beans.Usergif;
import com.videotogif.demo.dao.UsergifMapper;
import com.videotogif.demo.service.Videotogifservice;
import com.videotogif.demo.util.VideoToGIf;
import com.videotogif.demo.vo.ResStatus;
import com.videotogif.demo.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@Service
public class Videotogifserviceimpl implements Videotogifservice {
    @Autowired
    UsergifMapper usergifMapper;
    VideoToGIf videoToGIf=new VideoToGIf();
    @Override
    public ResultVO videotogif(MultipartFile file) {
        String url2="D:\\apache-tomcat-9.0.53\\webapps\\gif\\mp4";
        String name= System.currentTimeMillis()+""+ (new Random().nextInt(89999)+10000);
        String mp4name=name+".mp4";
        String gifname=name+".gif";
        String filePath=url2+"/"+mp4name;
        File desFile=new File(filePath);
        System.out.println(file);
        //如果文件不存在就创建目录
        if(!desFile.getParentFile().exists()){
            desFile.mkdirs();
        }
        //封装的写入流文件
        try {
            file.transferTo(desFile);

            videoToGIf.transform("D:\\apache-tomcat-9.0.53\\webapps\\gif\\mp4\\"+mp4name,"D:\\apache-tomcat-9.0.53\\webapps\\gif\\gif\\"+gifname);
            usergifMapper.insertgif(new Usergif("123",gifname,new Date()));
            if(desFile.isFile() && desFile.exists()) {
                desFile.delete();
                System.out.println("delmp4 yes");
            }
            return new ResultVO(ResStatus.OK,"succes",""+gifname);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultVO(ResStatus.NO,"erro",null);
    }
}
