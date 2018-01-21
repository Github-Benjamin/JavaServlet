package dao;

/**
 * Created by Anonymous on 2018/1/21.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Admin;
import servlets.SearchAdmin;

import common.DBConnect;
import common.PageBean;
import java.util.Date;
import java.text.SimpleDateFormat;


public class AdminControl
{

    ResultSet rs=null;
    String sql=null;
    DBConnect dbconnect=new DBConnect();

    public AdminControl()
    {
    }

    public String isAdmin(Admin admin) throws Exception
    {
        String username=admin.getUserName();
        String a="a";
        sql="select * from user where username='"+admin.getUserName()+"' and password='"+admin.getPassword()+"'";
        rs=dbconnect.executeQuery(sql);
        if(rs.next())
        {
            a="success";
        }
        rs.close();
        return a;
    }

    //add the admin
    public void addAdmin(Admin admin)
    {
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            sql="insert into user (username,password,email,createtime,phone) values ('"+admin.getUserName()+"','"+admin.getPassword()+"','"+admin.getEmail()+"','"+df.format(new Date())+"','"+admin.getPhone()+"')";
            dbconnect.executeUpdate(sql);
        }
        catch(Exception ex)
        {    ex.printStackTrace();
            System.out.print("AddAdmin Bean error:"+ex.getMessage());
        }
    }



    public ArrayList getAllAdmin()
    {

        ArrayList a=new ArrayList();
        try
        {
            sql="select * from user";
            rs=dbconnect.executeQuery(sql);
            while(rs.next())
            {
                Admin admin=new Admin();
                admin.setUserName(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setEmail(rs.getString("email"));
                admin.setPhone(rs.getString("phone"));
                a.add(admin);
            }
            rs.close();
        }catch(Exception ex)
        {
            System.out.print("AdminControl's allAdmin error:"+ex.getMessage());
        }
        return a;
    }

    //isExist admin uername
    public boolean isExistAdmin(String username) throws Exception
    {
        boolean a=false;
        String sql="select * from user where username='"+username+"'";
        rs=dbconnect.executeQuery(sql);
        if(rs.next())
        {
            a=true;
        }
        rs.close();
        return a;
    }

    ///del admin
    public void DelAdmin(String username) throws Exception
    {
        try
        {
            sql="delete from user where username='"+username+"'";
            dbconnect.executeUpdate(sql);
        }
        catch(Exception ex)
        {
            System.out.print("DelAdmin Error:"+ex.getMessage());
        }
    }

    public int getAdminCount(String strsql)  //计算查询结果的行数
    {
        int i=0;
        try
        {
            rs=dbconnect.executeQuery(strsql);
            while(rs.next())
            {
                i=rs.getInt(1);
            }
        }
        catch(Exception ex)
        {
            System.out.print("AdminControl's getAdminInfo error:"+ex.getMessage());
        }
        return i;
    }

    public ArrayList getAdminInfo(String strsql)  //得到查询结果
    {
        ArrayList a=new ArrayList();
        try
        {
            rs=dbconnect.executeQuery(strsql);
            while(rs.next())
            {
                Admin admin=new Admin();
                admin.setUserName(new String(rs.getString("username")));
                admin.setPassword(new String(rs.getString("password")));
                admin.setEmail(new String(rs.getString("email")));
                admin.setPhone(new String(rs.getString("phone")));
                a.add(admin);
            }
        }
        catch(Exception ex)
        {
            System.out.print("AdminControl's getAdminInfo error:"+ex.getMessage());
        }
        return a;
    }


    //UpdateAdmin
    public void UpdateAdmin(Admin admin) throws Exception
    {
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            sql="update user set password='"+admin.getPassword()+"' email='"+admin.getEmail()+"' createtime='"+df.format(new Date())+"' phone='"+admin.getPhone()+"' where username='"+admin.getUserName()+"'";
            dbconnect.executeUpdate(sql);
        }
        catch(Exception ex)
        {
            System.out.print("UpdateAdmin Error:"+ex.getMessage());
        }
    }

    public PageBean listData(int page,SearchAdmin searchadmin) throws Exception 	//获得指定页面的数据，并且封装在PageBean中返回
    {
        try
        {
            int count=getAdminCount(searchadmin.strSQL1);
            ArrayList result=getAdminInfo(searchadmin.strSQL);
            PageBean pagebean=new PageBean(count,result);
            ArrayList v=new ArrayList();
            int x=(pagebean.maxRowCount<page*pagebean.rowsPerPage?pagebean.maxRowCount:page*pagebean.rowsPerPage);
            for(int i=pagebean.rowsPerPage*(page-1);i<x;i++)
            {
                v.add(result.get(i));
            }
            pagebean.curPage=page;
            pagebean.data=v;
            return pagebean;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            throw ex;
        }
    }


    public void close()
    {
        dbconnect.close();
    }

    public Admin getAdmin(String userName) {
        String sql = "select * from user where username='"+userName+"'";
        ResultSet rs = dbconnect.executeQuery(sql);
        Admin admin = new Admin();
        try {
            admin.setUserName(new String(rs.getString("username")));
            admin.setPassword(new String(rs.getString("password")));
            admin.setEmail(new String(rs.getString("email")));
            admin.setPhone(new String(rs.getString("phone")));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return admin;
    }

}
