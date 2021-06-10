package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
public class AjaxController {

    @RequestMapping("/a1")
    public void ajax1(String name, HttpServletResponse response) throws IOException {
        if ("admin".equals(name)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> ajax2(){
        List<User> users = new ArrayList<User>();
        users.add(new User("琴江1",15,"男"));
        users.add(new User("琴江2",15,"男"));
        users.add(new User("琴江3",15,"男"));
        return users;  //由于@RestController注解，将users转成json格式返回
    }

}
