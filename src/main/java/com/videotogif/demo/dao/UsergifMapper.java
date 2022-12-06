package com.videotogif.demo.dao;

import com.videotogif.demo.beans.Usergif;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsergifMapper {
    public int insertgif(@Param("usergif") Usergif usergif);
}
