package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /*
     * 新增用户信息
     * */


    @PostMapping("/select")
    public Result select(@RequestBody String uid, String psw) {
        userService.selectUser(uid, psw);
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if (StrUtil.isBlank(user.getUid()) || StrUtil.isBlank(user.getPsw())) {
            return Result.error();
        }
        return Result.success(userService.login(user));
    }

    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        if (userService.insertUser(user)) {
            return Result.success(true);
        }
        return Result.success(false);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        if (userService.updateUser(user))
            return Result.success(true);
        return Result.success(false);
    }

}

