package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import com.example.demo.common.Result;

import com.example.demo.service.HelmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Scanner;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {

    private static final String ROOT_PATH = "D:\\save";


    //    HelmetService helmetService;
    @Autowired
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException, InterruptedException {
        String originalFilename = file.getOriginalFilename();
        String mainName = FileUtil.mainName(originalFilename);
        String extName = FileUtil.extName(originalFilename);
        String fileName = "message.png";
        String txtPath = "D\\save\\labels\\message.txt";
        String fileRealPath = "D:\\save\\message.png";
        File saveFile = new File(fileRealPath);

        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String url = "http://localhost:8080/file/download/" + originalFilename;
        Process process = Runtime.getRuntime().exec("python D:\\ultralytics-main\\predict.py");
        process.waitFor();

        /*
         *
         *读取labels中的信息
         *将标签txt文件中的数据
         * 存到数据库中
         * 用来记录读取次数，戴头盔次数，不戴头盔次数，骑行者个数
         * */
//        String FileName = "D:\\save\\labels\\message.txt";
//
//        Scanner sc = new Scanner(new FileReader(FileName));
//        int total = 0;
//        int wear_count = 0;
//        int without_count = 0;
//        int bike_count = 0;
//        while (sc.hasNextLine()) {  //按// 行读取字符串
//            String line = sc.nextLine();
//            String[] strArr = line.split(" ");
//            int x = Integer.parseInt(strArr[0]);
//            total++;
//            /*
//             *数字表示含义
//             * bike:0
//             *wear_helmet:1
//             * without_helmet:2
//             *
//             * */
//            if (x == 0)
//                bike_count++;
//            if(x==1)
//                wear_count++;
//            if(x==2)
//                without_count++;
//        }
//        helmetService.addHelmet(total, wear_count,without_count, bike_count);


        return Result.success(url);
    }

    @GetMapping("/Get")
    public String getUrl() throws IOException {
        String filePath = "D:\\save\\message.png";

        Path file = Paths.get(filePath);
        byte[] byteArray = Files.readAllBytes(file.toAbsolutePath());
        String base64String = Base64.getEncoder().encodeToString(byteArray);
        return base64String;
    }

    @GetMapping("/download/{fileName}")
    public void download(@PathVariable String fileName, HttpServletResponse response) throws IOException, InterruptedException {
        String filePath = ROOT_PATH + File.separator + fileName;
        byte[] bytes = FileUtil.readBytes(filePath);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
/*        Process process = Runtime.getRuntime().exec("python D:\\ultralytics-main\\predict.py");
        process.waitFor();*/
        outputStream.flush();
        outputStream.close();
    }
}
