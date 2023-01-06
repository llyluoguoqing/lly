package com.lly.demo.controller;

import com.lly.demo.bean.User;
import com.lly.demo.util.APIResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/lly")
@RestController
@Api(value  = "用户平台应用接口",tags = "用户操作接口")
public class UserController {

    @GetMapping("/getUser")
    @ApiOperation(value = "获取用户", notes = "无参数")
    public List<User> getUser(){
        User user=new User();
        User user1=new User();
        List<User> userList=new ArrayList<>();
        user.setId(1);
        user.setName("lly");
        user.setAge(29);
        user.setSex("男");
        user1.setId(11);
        user1.setName("lly1");
        user1.setAge(291);
        user1.setSex("男1");
        System.out.println(user);
        userList.add(user);
        userList.add(user1);
        return  userList;
    }
    @GetMapping("/getUser1")
    @ApiOperation(value = "获取用户", notes = "无参数")
    public APIResponse<User> getUser1(){
        User user=new User();
        APIResponse<User> userAPIResponse=new APIResponse<User>();
        user.setId(1);
        user.setName("lly");
        user.setAge(29);
        user.setSex("男");
        System.out.println(user);
        userAPIResponse.setData(user);
        userAPIResponse.setCode("500");
        userAPIResponse.setMsg("success");
        return  userAPIResponse;
    }
}
