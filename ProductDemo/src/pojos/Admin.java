package pojos;

/**
 * Created by Anonymous on 2018/1/21.
 */
import java.io.*;
import java.util.*;

public class Admin{

    public String username;
    public String password;
    public String email;
    public String phone;

    //default Fuction
    public Admin()
    {
    }

    //setter
    public void setUserName(String username)
    {
        this.username = username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    //getter
    public String getUserName( )
    {
        return this.username;
    }
    public String getPassword( )
    {
        return this.password;
    }
    public String getEmail( )
    {
        return this.email;
    }
    public String getPhone( )
    {
        return this.phone;
    }

}
