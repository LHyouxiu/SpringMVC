package com.kuang.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class FileController {
    //@RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
    //批量上传CommonsMultipartFile为数组即可
    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //获取文件名 file.getOriginalFilename
        String originalFilename = file.getOriginalFilename();

        //如果文件名为空 直接返回首页
        if ("".equals(originalFilename)){
            return "redirect:/index.jsp";
        }
        System.out.println("上传文件名：" + originalFilename);

        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");

        //如果路径不存在 创建一个
        File realPath = new File(path);
        if(!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址:"+realPath);

        InputStream is = file.getInputStream();//文件输入流
        FileOutputStream os = new FileOutputStream(new File(realPath, originalFilename));

        //读取写出
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer)) != -1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
        return "redirect:/index.jsp";

    }

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("/upload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

    //上传路径保存设置
    String path = request.getServletContext().getRealPath("/upload");
    File realPath = new File(path);
    if (!realPath.exists()){
        realPath.mkdir();
      }
        //上传文件地址
        System.out.println("上传文件保存地址："+realPath);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(new File(realPath +"/"+ file.getOriginalFilename()));

        return "redirect:/index.jsp";
    }

    /*
    * 下载
    *
    * */
    @RequestMapping("/download")
    public String downloads(HttpServletResponse response,HttpServletRequest request) throws IOException {
        System.out.println("下载图片");
        //要下载的图片地址
        String realPath = request.getServletContext().getRealPath("/upload");
        String fileName = "1.png";

        //1.设置response 响应头
        response.reset();//设置页面不缓存，清空buffer
        response.setCharacterEncoding("UTF-8");//字符编码
        response.setContentType("multipart/form-data");
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + URLEncoder.encode(fileName,"UTF-8"));

        File file = new File(realPath, fileName);
        //2.读取文件 输入流
        FileInputStream input = new FileInputStream(file);
        //3.写出文件 输出流
        ServletOutputStream out = response.getOutputStream();

        byte[] bytes = new byte[1024];
        int index = 0;
        //4.执行 写出操作
        while ((index = input.read(bytes)) != -1){
            out.write(bytes,0,index);
            out.flush();
        }
        out.close();
        input.close();
        return "ok";

    }



}
