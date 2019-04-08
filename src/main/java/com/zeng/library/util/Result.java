package com.zeng.library.util;

public class Result {
    public static int SUCCESS_CODE = 1;
    public static int FAIL_CODE =0;
    public int code;
    public String message;
    private Result(int code,String message){
        this.code = code;
        this.message = message;
    }
    public static Result success(){
        return new Result(SUCCESS_CODE,null);
    }
    public static Result fail(){
        return new Result(FAIL_CODE,"密码错误");
    }
}
