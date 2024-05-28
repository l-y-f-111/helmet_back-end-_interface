package com.example.demo.service;

import com.example.demo.entity.Helmet;
import com.example.demo.mapper.HelmetMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;

public class HelmetService {
    @Autowired
    HelmetMapper helmetMapper;
    public Helmet selectHelmet() {
        return helmetMapper.selectHelmet();
    }
    public void addHelmet(int total,int wear_count,int without_count,int bike_count){
        Timestamp time = new Timestamp(new Date().getTime());
        helmetMapper.addHelmet(total,wear_count,without_count,bike_count,time);
    }
}
