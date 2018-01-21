package servlets;

/**
 * Created by Anonymous on 2018/1/21.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import java.util.HashMap;

import dao.AdminControl;


@WebServlet("/admin")
public class SearchAdmin extends HttpServlet
{
    public String strSQL="";
    public String strSQL1="";

    //Initialize global variables
    public void init() throws ServletException
    {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session=request.getSession(true);


        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        if(session.getAttribute("admin")==null)
        {
            out.print("<script>alert('请先登录！');window.location.href='login.html'</script>");
        }else{
            String manage = (String)session.getAttribute("manage");
            manage="系统";
            //System.out.println("manage:"+manage);

            if(!manage.equals("系统"))
            {
                out.print("<script>alert('对不起，你没有权限打开本网页！');history.back()</script>");
            }else{
                AdminControl admincontrol=new AdminControl();
                List list = new ArrayList();
                list = admincontrol.getAllAdmin();
                //System.out.println(list.size());
                request.setAttribute("adminList", list);
                response.sendRedirect("admin.jsp");
            }
        }
    }

    //和POST请求的处理一样
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request,response);
    }

    //Clean up resources
    public void destroy()
    {
    }
}

