package com.login;

/**
 * Created by Anonymous on 2018/1/20.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


//方法二
@WebServlet("/login")
public class CheckAccount extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取session
        HttpSession session = req.getSession();

        AccountBean account = new AccountBean();

        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        System.out.println(username+"111"+pwd+"111");

        account.setPassword(pwd);
        account.setUsername(username);

        if (username != null && username != "") {
            if (pwd != "" && pwd != null) {
                session.setAttribute("account", account);
                String login_suc = "success.jsp";
                resp.sendRedirect(login_suc);
                return;
            }else {
                String login_fail = "fail.jsp";
                resp.sendRedirect(login_fail);
                return;
            }
        }

        String login_fail = "login.jsp";
        resp.sendRedirect(login_fail);
        return;

//        String login_fail = "fail.jsp";
//        resp.sendRedirect(login_fail);
//        return;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}