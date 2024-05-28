package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@Getter
@Setter
@Data
public class Helmet {
    private int number;
    private int wear_count;
    private int without_count;
    private int bike_count;
    private Timestamp time;
}
