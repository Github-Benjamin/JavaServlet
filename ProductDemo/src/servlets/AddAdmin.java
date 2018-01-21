package servlets;

/**
 * Created by Anonymous on 2018/1/21.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import pojos.Admin;
import pojos.Message;
import dao.AdminControl;


@WebServlet("/admin/add")
public class AddAdmin extends HttpServlet
{

    //Initialize global variables
    public void init() throws ServletException
    {
    }

    //Process the HTTP Post request
    public void doPost(HttpServletRequest request, HttpServletResponse response)

    {
        PrintWriter out=null;
        AdminControl admincontrol=new AdminControl();

        try {
            response.setContentType("text/html; charset=utf-8");
            out = response.getWriter();

            Admin admin=new Admin();

            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String email=request.getParameter("email");
            String phone=request.getParameter("phone");

            //System.out.println(username+password+email+phone);
            Gson gson = new Gson();
            Message message = new Message();


            //处理数据
            if(!admincontrol.isExistAdmin(username))
            {
                admin.setUserName(username);
                admin.setPassword(password);
                admin.setEmail(email);
                admin.setPhone(phone);
                admincontrol.addAdmin(admin);

                message.setStatus("1");
                String jsonStr = gson.toJson(message);
                out.print(jsonStr);
                // out.print("<script>alert('成功添加！');window.location.href='addadmin.jsp'</script>");
            }
            else
            {

                message.setStatus("0");
                String jsonStr = gson.toJson(message);
                out.print(jsonStr);
                // out.print("<script>alert('该管理员已经存在！');history.back()</script>");
            }

        } catch(Exception e)
        {   e.printStackTrace();
            System.out.print("AddAdmin Servlet error:"+e.getMessage());
            out.print("<script>alert('出现异常，添加失败！');window.location.href='addadmin.jsp'</script>");
        }
        // out.print("<script>alert('成功添加！');window.location.href='addadmin.jsp'</script>");
        admincontrol.close();
    }

    //Clean up resources
    public void destroy()
    {
    }
}

