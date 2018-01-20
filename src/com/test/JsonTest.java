package com.test;

/**
 * Created by Anonymous on 2018/1/20.
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;


@WebServlet("/JsonTest")
public class JsonTest extends HttpServlet {

    //处理get请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        Gson gson = new Gson();

        Student student = new Student();

        student.setName("Benjamin");
        student.setAge("22");

        String jsonStr = gson.toJson(student);

        out.println(jsonStr);

    }


    //处理post请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.println("我是一个JSON数据");

    }


    //销毁servlet实例对象时的回调方法
    @Override
    public void destroy() {
        super.destroy();
    }

    //初始化servlet时的回调方法
    @Override
    public void init() throws ServletException {
        super.init();
    }

}