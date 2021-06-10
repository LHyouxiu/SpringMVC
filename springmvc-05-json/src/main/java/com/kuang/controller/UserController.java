package com.kuang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//这里我们需要两个新东西，一个是@ResponseBody，一个是ObjectMapper对象
//@Controller
//public class UserController {
//
//    //produces:指定响应体返回类型和编码
//    @RequestMapping(value = "/json1",produces = "application/json;charset=utf-8")
//    @ResponseBody
//    public String json01(){
//        //创建一个jackson的对象映射器，用来解析数据
//        ObjectMapper mapper = new ObjectMapper();
//        //创建一个对象
//        User user = new User("琴江", 15, "男");
//        //将我们的对象解析成为json格式
//        String str = null;
//        try {
//            str = mapper.writeValueAsString(user);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
//        return str;
//    }
//}

//在类上直接使用 @RestController ，这样子，里面所有的方法都只会返回 json 字符串了，不用再每一个都添加@ResponseBody ！
//        我们在前后端分离开发中，一般都使用 @RestController ，十分便捷！

@RestController
public class UserController {

    //produces:指定响应体返回类型和编码
    @RequestMapping(value = "/json1")
    public String json01(){
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("琴江", 15, "男");
        //将我们的对象解析成为json格式
        String str = null;
        try {
            str = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str;
    }

    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {

//       创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();

        User user1 = new User("琴江1", 15, "男");
        User user2 = new User("琴江2", 15, "男");
        User user3 = new User("琴江3", 15, "男");
        User user4 = new User("琴江4", 15, "男");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
//        将对象解析成json格式
        String str = mapper.writeValueAsString(list);

        return str;
    }

    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //创建时间一个对象，java.util.Date
        Date date = new Date();
//        默认日期格式会变成一个数字，是1970年1月1日到当前日期的毫秒数！
//        Jackson 默认是会把时间转成timestamps形式

        String str = mapper.writeValueAsString(date);
        return str;
    }

    @RequestMapping("/json4")
    public String json4() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);

        Date date = new Date();
        String str = mapper.writeValueAsString(date);

        return str;
    }

    @RequestMapping("/json5")
    public String json5(){
        Date date = new Date();
        String json = JsonUtils.getJson(date);

        return json;
    }

}