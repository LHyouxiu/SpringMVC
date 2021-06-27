package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/a1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a2")
    public List<User> ajax2(){
        List<User> users = new ArrayList<>();
        users.add(new User("狂神1",1,"男"));
        users.add(new User("狂神2",2,"男"));
        users.add(new User("狂神3",3,"男"));
        return users;
    }

    @RequestMapping("/a3")
    public String ajax3(String name,String pwd){
        String msg = "";
        //模拟数据库中存在数据
        if(name != null){
            if ("admin".equals(name)){
                msg = "ok";
            }else {
                msg = "用户名输入错误";
            }
        }

        if (pwd !=null){
            if ("123456".equals(pwd)){
                msg = "ok";
            }else{
                msg = "密码输入有误";
            }
        }

        return msg;
    }



}
