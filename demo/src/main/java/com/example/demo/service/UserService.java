package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public boolean insertUser(User user) {
        if(userMapper.insert(user)){
            return true;
        }
        return false;
    }

    public User selectUser(String uid, String psw) {
        return userMapper.selectUser(uid, psw);
    }

    public boolean login(User user) {
        User dbUser = userMapper.selectUser(user.getUid(), user.getPsw());
        if (dbUser == null)
            return false;
        else
            return true;
    }
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }


}
