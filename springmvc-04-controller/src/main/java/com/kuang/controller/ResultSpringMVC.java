package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultSpringMVC {

    @RequestMapping("/rsm/t1")
    public String test1(){
//      转发一
        return "/index.jsp";
    }

    @RequestMapping("/rsm/t2")
    public String test2(){
//      转发二
        return "forward:/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/rsm/t3")
    public String test3(){
//        重定向
        return "redirect:/index.jsp";
    }


}
