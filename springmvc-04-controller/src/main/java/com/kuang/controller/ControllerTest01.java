package com.kuang.controller;



import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//定义控制器
//注意点：不要导错包，实现Controller接口，重写方法；
public class ControllerTest01 implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest var1, HttpServletResponse var2) throws Exception {

        //返回一个模型视图对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","test1Controller");
        mv.setViewName("test");

        return mv;
    }
}
