package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFullController {
    //映射访问路径
    @RequestMapping("/commit/{p1}/{p2}")
    public String index(@PathVariable int p1, @PathVariable int p2, Model model){

        int result = p1+p2;
//        Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg","RestFullController   " + result);
//      返回视图位置
        return "test";
    }

//    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    @GetMapping
    @RequestMapping(value = "/hello")

    public String index2(Model model){
        model.addAttribute("msg","hello");

        return "test";
    }
}
