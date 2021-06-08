package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ResultServletApi {

    @RequestMapping("/result/t1")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.getWriter().println("Hello,SpringMVC By ServletApi");

    }

    @RequestMapping("/result/t2")
    public void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {
//      重定向
        response.sendRedirect("/index.jsp");

    }

    @RequestMapping("/result/t3")
    public void test3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        转发
        request.setAttribute("msg","/result/t3  转发页面");
        request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request,response);
    }

}
