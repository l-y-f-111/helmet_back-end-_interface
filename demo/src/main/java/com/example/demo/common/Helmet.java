package com.example.demo.common;


import org.python.jline.internal.TestAccessible;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Helmet {


    void testReadFile1() throws IOException {
        //文件内容：Hello World|Hello Zimug
        String fileName = "D:\\save\\labels\\message.txt";

        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {  //按行读取字符串
                String line = sc.nextLine();
                System.out.println(line);
            }
        }

        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            sc.useDelimiter("\\|");  //分隔符
            while (sc.hasNext()) {   //按分隔符读取字符串
                String str = sc.next();
                System.out.println(str);
            }
        }

//        //sc.hasNextInt() 、hasNextFloat() 、基础数据类型等等等等。
//        //文件内容：1|2
//        fileName = "D:\\data\\test\\newFile5.txt";
//        try (Scanner sc = new Scanner(new FileReader(fileName))) {
//            sc.useDelimiter("\\|");  //分隔符
//            while (sc.hasNextInt()) {   //按分隔符读取Int
//                int intValue = sc.nextInt();
//                System.out.println(intValue);
//            }
//        }
    }
}
