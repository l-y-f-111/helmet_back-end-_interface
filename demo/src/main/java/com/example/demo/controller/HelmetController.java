package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.entity.Helmet;
import com.example.demo.service.HelmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/helmet")
public class HelmetController {

    @Autowired(required=false)
    HelmetService helmetService;


    @PostMapping("/select")
    public Helmet select() {
        return helmetService.selectHelmet();
    }
}
