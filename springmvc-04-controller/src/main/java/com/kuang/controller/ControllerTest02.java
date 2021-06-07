package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller注解的类会自动添加到Spring上下文中
@Controller
@RequestMapping("/admin")
public class ControllerTest02 {

    //映射访问路径
    @RequestMapping("/t2")
    public String index(Model model){

        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg","ControllTest02");
        //返回视图位置
        return "test";

    }


}
