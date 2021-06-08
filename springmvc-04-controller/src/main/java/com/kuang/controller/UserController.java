package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user2")
public class UserController {
    @RequestMapping("/t1")
    public String test1(String name, Model model){

        System.out.println("提交的域名称和处理方法的参数名一致"+name);
        model.addAttribute("msg",name);
        return "test";
    }

    @RequestMapping("/t2")
    public String test2(@RequestParam("username") String name, Model model){
        //封装要显示到视图中的数据
        //相当于req.setAttribute("name",name);
        System.out.println("提交的域名称和处理方法的参数名不一致"+name);
        model.addAttribute("msg",name);
        return "test";
    }

    @RequestMapping("/t4")
    public String test4(@RequestParam("username") String name, ModelMap modelMap){
        //封装要显示到视图中的数据
        //相当于req.setAttribute("name",name);
        System.out.println("ModelMap 使用方法"+name);
        modelMap.addAttribute("msg",name);
        return "test";
    }


    @RequestMapping("/t3")
    public String test3(User user){
//      /user/t3?name=kuangshen&id=1&age=15
//      如果使用对象的话，前端传递的参数名和对象名必须一致，否则就是null。
        System.out.println("提交的表单域和对象的属性名一致,参数使用对象即可"+user);
        return "test";
    }

//    Model 只有寥寥几个方法只适合用于储存数据，简化了新手对于Model对象的操作和理解；
//
//    ModelMap 继承了 LinkedMap ，除了实现了自身的一些方法，同样的继承 LinkedMap 的方法和特性；
//
//    ModelAndView 可以在储存数据的同时，可以进行设置返回的逻辑视图，进行控制展示层的跳转。
}
