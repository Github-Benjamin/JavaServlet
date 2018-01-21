package servlets;

/**
 * Created by Anonymous on 2018/1/21.
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;

import pojos.Admin;
import dao.AdminControl;
import pojos.Message;


@WebServlet("/login")
public class Login extends HttpServlet
{

    //Initialize global variables
    public void init() throws ServletException
    {
    }

    //Process the HTTP Post request
    public void service(HttpServletRequest req,HttpServletResponse res)
            throws ServletException,IOException
    {

        res.setContentType("text/html;charset=utf-8");
        PrintWriter out=res.getWriter();

        Admin admin=new Admin();
        AdminControl admincontrol=new AdminControl();
        String username=req.getParameter("username");
        String password=req.getParameter("password");


        Gson gson = new Gson();
        Message message = new Message();


        if(username.equals("")||password.equals(""))
            out.print("<script>alert('请输入帐号和密码!');history.back()</script>");
        try
        {

            admin.setUserName(username);
            admin.setPassword(password);

            if(admincontrol.isAdmin(admin).equals("success"))
            {
                HttpSession session=req.getSession(true);

                session.setAttribute("admin", admin);

       	    	/*Admin ad = admincontrol.getAdmin(username);
       	    	session.setAttribute("manage",ad.getManage());*/
       	    	/*if(manage=="admin")
       	    	{res.sendRedirect("admin.html");
       	    	}else*/
                // res.sendRedirect("/admin");

                message.setSuccess("1");
                String jsonStr = gson.toJson(message);
                out.print(jsonStr);


            } else
            {
                message.setError("用户名或密码错误！");
                String jsonStr = gson.toJson(message);
                out.print(jsonStr);
                //out.print("<script>alert('密码错误！');history.back()</script>");
            }
        }catch(Exception e)
        {
            System.out.println("login has error"+e.getMessage());
        }
    }
    //Clean up resources
    public void destroy()
    {
    }
}
