package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

   @Select("select * from helmet.\"user\" where uid=#{uid} and psw=#{psw} ")
   User selectUser(@Param("uid") String uid,@Param("psw") String psw);

    @Insert("insert into helmet.\"user\" (uid,psw,email) values (#{uid},#{psw},#{email})")
    boolean insert(User user);

    @Update("update  helmet.\"user\" set psw = #{psw}  where uid = #{uid}")
    boolean updateUser(User user);
}


