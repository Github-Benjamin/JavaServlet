package common;

/**
 * Created by Anonymous on 2018/1/21.
 */
import java.util.*;
import javax.servlet.*;

public class PageBean
{

    public int curPage ; //当前是第几页
    public int maxPage ; //一共有多少页
    public int maxRowCount ; //一共有多少行
    public int rowsPerPage=12 ;//每页多少行
    public ArrayList data;//本页中要显示的资料

    public PageBean()  //构造函数
    {
    }

    public int countMaxPage() //根据总行数计算总页数
    {
        if (this.maxRowCount % this.rowsPerPage==0)
        {
            this.maxPage = this.maxRowCount/this.rowsPerPage;
        }
        else
        {
            this.maxPage = this.maxRowCount/this.rowsPerPage + 1;
        }
        return this.maxPage;
    }

    public ArrayList getResult()  //返回本页要显示的数据
    {
        return this.data;
    }

    public PageBean(int count,ArrayList arraylist)throws Exception
    {
        this.maxRowCount=count;  //得到总行数
        this.data=arraylist;    //得到要显示于本页的数据
        this.maxPage=countMaxPage();    //得到总页数
    }

}
