package servlets;

import dao.AdminControl;
import pojos.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anonymous on 2018/1/21.
 */
@WebServlet("/admin/loginout")
public class LoginOut extends HttpServlet
{

    //Initialize global variables
    public void init() throws ServletException
    {
    }

    //Process the HTTP Post request
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,IOException
    {

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();

        HttpSession session=req.getSession(true);
        session.invalidate();
        resp.sendRedirect("admin.html");

    }
    //Clean up resources
    public void destroy()
    {
    }
}

