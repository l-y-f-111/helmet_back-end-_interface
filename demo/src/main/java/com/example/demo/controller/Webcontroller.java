package com.example.demo.controller;

import com.example.demo.common.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*提供接口返回数据*/
@CrossOrigin
@RestController

public class Webcontroller {
    @RequestMapping
    public Result hello(String name) {
        return Result.success(name);
    }
}
