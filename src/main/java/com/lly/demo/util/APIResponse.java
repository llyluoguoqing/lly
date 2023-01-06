package com.lly.demo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: lly
 * \* Date: 2020-01-12
 * \* Time: 13:36
 * \* To Change Description And Date And User:
 * \* Description:返回的参数封装类
 * \
 */
@Data
@ApiModel(description = "返回结果")
public class APIResponse <T> {
    //private static final String CODE_SUCCESS = "200";
    private static final String CODE_SUCCESS = "success";
    //private static final String CODE_FAIL = "500";
    private static final String CODE_FAIL = "fail";
    @ApiModelProperty(value = "返回状态编码")
    private String code;
    @ApiModelProperty(value = "返回数据")
    private T data;
    @ApiModelProperty(value = "返回状态")
    private String msg;

    public APIResponse(){

    }

    public APIResponse(String code){
        this.code = code;
    }

    public APIResponse(String code, T data){
        this.code = code;
        this.data = data;
    }

    public APIResponse(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static APIResponse success(){
        return new APIResponse(CODE_SUCCESS);
    }

    public static APIResponse success(Object data){
        return new APIResponse(CODE_SUCCESS, data);
    }

    public static APIResponse fail(String msg){
        return new APIResponse(CODE_FAIL, msg);
    }

    public static APIResponse widthCode(String errorCode) {
        return new APIResponse(errorCode);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}