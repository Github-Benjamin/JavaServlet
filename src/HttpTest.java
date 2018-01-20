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



/*
测试get post请求
url定义
*/
@WebServlet("/httptest")

public class HttpTest extends HttpServlet {

    private String username;

    //处理get请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // req 用户请求，resp服务端响应

        //调用doPost方法
        //doPost(req.resp);

        //设置响应内容类型
        resp.setContentType("text/html;charset=utf-8");

        //从响应对象中获取打印流
        PrintWriter out = resp.getWriter();

        // 获取get请求中的参数
        username = req.getParameter("username");

        out.println("这是我的第一个Servlet应用示例，Get请求用户名为：");
        out.println(username);

    }

    //处理post请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //重定向到/HelloWorld页面
        //resp.sendRedirect("/HelloWorld");

        //设置响应内容类型
        resp.setContentType("text/html;charset=utf-8");

        //从响应对象中获取打印流
        PrintWriter out = resp.getWriter();
        out.println("这是我的第一个Servlet应用示例");
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