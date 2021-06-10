package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kuang.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class FastJsonController {

    public static void main(String[] args) {

        User user1 = new User("琴江1", 15, "男");
        User user2 = new User("琴江2", 15, "男");
        User user3 = new User("琴江3", 15, "男");
        User user4 = new User("琴江4", 15, "男");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println("**********JAVA对象 转 JSON字符串***************");
        String s1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+s1);
        String s2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+s2);

        System.out.println("*************JSON字符串 转 JAVA对象****************");
        User jp_user1 = JSON.parseObject(s2, User.class);
        System.out.println("JSON.parseObject(s2, User.class)==>"+jp_user1);

        System.out.println("*************JAVA对象 转 JSON对象****************");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("************JSON对象 转 JAVA对象***************");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

    }




}
