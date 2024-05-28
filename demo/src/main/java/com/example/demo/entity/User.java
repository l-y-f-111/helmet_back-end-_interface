package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class User {
    private String uid;
    private String psw;//表示身份
    private String email;
}
