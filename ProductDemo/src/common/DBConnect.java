package common;

/**
 * Created by Anonymous on 2018/1/21.
 */
import java.sql.*;
import java.io.*;


public class DBConnect
{
    Connection conn=null;
    Statement stmt=null;
    ResultSet r=null;

    String url="jdbc:mysql://localhost:3306/servlet?characterEncoding=utf8&useSSL=true";
    String username="root";
    String password="";
    String driver="com.mysql.jdbc.Driver";

    public DBConnect()
    {
        try
        {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,username,password);
            stmt=conn.createStatement();
        }
        catch(Exception ex)
        {
            System.out.print("连接数据库发生错误："+ex.getMessage());
        }
    }

    //ResultSet Query
    public ResultSet executeQuery(String sql)
    {
        try
        {
            r=stmt.executeQuery(sql);
        }
        catch(Exception ex)
        {
            System.out.print("查询发生错误："+ex.getMessage());
        }
        return r;
    }

    //executeUpdate
    public void executeUpdate(String sql)
    {
        try
        {
            stmt.executeUpdate(sql);
        }
        catch(Exception ex)
        {
            System.out.print("执行SQL发生错误:"+ex.getMessage());
        }
    }

    //close the conn
    public void close()
    {
        try
        {
            if(r!=null)  r.close();
            if(stmt!=null)  stmt.close();
            if(conn!=null)  conn.close();
        }
        catch(Exception ex)
        {
            System.out.print("closeconn Error:"+ex.getMessage());
        }
    }

}
