package com.test;

/**
 * Created by Anonymous on 2018/1/20.
 */

//public class HelloWorld {
//}

import com.login.AccountBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

//方法二
@WebServlet("/HelloWorld")

public class HelloWorld extends HttpServlet {
    private String message;

    //初始化servlet时的回调方法
    @Override
    public void init() throws ServletException {
        message = "Hello world, this message is from servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //方法一中，获取Web.xml中单项ServletConfig 实例
        //ServletConfig config = this.getServletConfig();
        //String str = config.getInitParameter("encoding");

        //方法一中，获取Web.xml中单项ServletContext 实例
        //ServletContext context = this.getServletContext();
        //String appName = context.getInitParameter("appName");


        //重定向到/HelloWorld页面,http状态码 302
        //resp.sendRedirect("/httptest");


        //请求分派，http状态码 200，请求url连接不会改变，只有一次请求

        // 请求域属性传递对象
        // String str = "这是HelloWorld中定义的的字符串";
        // req.setAttribute("string",str);

        // 请求分派
        // RequestDispatcher dispatcher = req.getRequestDispatcher("httptest");
        // dispatcher.forward(req,resp);

        // 打印
//        System.out.println("Hello World!");

        //设置响应内容类型
        resp.setContentType("text/html");
        //设置逻辑实现
        PrintWriter out = resp.getWriter();

        //从请求中获取session
        HttpSession session = req.getSession();
        AccountBean getsession = (AccountBean)session.getAttribute("account");
        if(getsession != null){
            System.out.println("username:"+getsession.getUsername()+"password"+getsession.getPassword());
        }

        //返回
        out.println("<h1>" + message + "</h1>");

        }

    //处理post请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置响应内容类型
        resp.setContentType("text/html;charset=utf-8");
        //从响应对象中获取打印流
        PrintWriter out = resp.getWriter();

        //创建一个Cookie实例
        Cookie cookie = new Cookie("username","Benjamin");
        //设置有效期为1天
        cookie.setMaxAge(24*3600);
        //往相应中写入cookie
        resp.addCookie(cookie);


        //获取cookie数组
        Cookie[] cookies = req.getCookies();
        if(cookies == null){
            out.println("<h3>还没有cookie</h3>");
        }else {
            out.println("<h3>cookie列表</h3>");
            //遍历cookie消息
            for (int i=0;i<cookies.length;i++){
                out.println("cookie名称："+cookies[i].getName());
                out.println(",对应的值："+cookies[i].getValue());
                out.println("<br/>");
            }
        }

    }

    //销毁servlet实例对象时的回调方法
    @Override
    public void destroy() {
        super.destroy();
    }

}
