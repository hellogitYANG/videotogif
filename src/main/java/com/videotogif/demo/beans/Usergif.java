package com.videotogif.demo.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usergif {
    Integer id;
    String userid;
    String giflocal;
    Date dateTime;
    //second comit
    //third commit
    //hot-fix commit1
    //hot-fix commit2
    //master commit1
    public Usergif(String userid, String giflocal, Date dateTime) {
        this.userid = userid;
        this.giflocal = giflocal;
        this.dateTime = dateTime;
    }
}
