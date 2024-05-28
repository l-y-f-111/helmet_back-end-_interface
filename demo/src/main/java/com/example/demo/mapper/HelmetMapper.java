package com.example.demo.mapper;

import com.example.demo.entity.Helmet;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;

public interface HelmetMapper {

    /*2024-5-7
    * 未修改查询
    *
    * */
    
    @Select("select * from helmet.helmet where time >='2024-5-7' and time <'2024-5-8' ")
    Helmet selectHelmet();
    /*insert into helmet."user" (uid,psw,email) values (#{uid},#{psw},#{email})*/
    @Insert("insert into   helmet.\"helmett\" (total_count,wear_count,without_count,bike_count,time) values " +
            "(#{total},#{wear_count},#{without_count},#{bike_count}.#{time})")
    void addHelmet(int total, int wear_count, int without_count, int bike_count, Timestamp time);
}
