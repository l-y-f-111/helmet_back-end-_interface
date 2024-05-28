package com.example.demo.common;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {

    public static final String CODE_SUCCESS = "200";
    public static final String CODE_AUTH_ERROR = "401";
    public static final String CODE_SYS_ERROR = "500";

    /*
     * 请求返回编码，
     * 表示此次请求成功或者失败
     * 或者失败类型
     * */
    private String code;
    /*
     * msg表示错误的详细信息
     * */
    private String msg;
    /*
     *返回前端数据的载体
     *  */
    private Object data;

    public static Result success() {
        return new Result(CODE_SUCCESS, "请求成功", null);
    }
    public static Result success(Object data){
        return new Result(CODE_SUCCESS,"请求成功",data);
    }
    public static Result error(String msg){
        return new Result(CODE_SYS_ERROR,msg,null);
    }
    public static Result error(String code,String msg){
        return new Result(code,msg,null);
    }
    public static Result error(){
        return new Result(CODE_SYS_ERROR,"系统错误",false);
    }
}
