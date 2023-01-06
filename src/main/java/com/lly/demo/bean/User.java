package com.lly.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "用户信息")
public class User implements Serializable {
    @ApiModelProperty(value = "主键")
    private int id;
    @ApiModelProperty(value = "名字")
    private String name;
    @ApiModelProperty(value = "年龄")
    private int age;
    @ApiModelProperty(value = "性别")
    private String sex;


}
