<%@ page contentType="text/html; charset=utf-8" language="java" import="pojos.Admin" import="dao.AdminControl"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>网站管理后台</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" />
    <script type="text/javascript" src="/static/js/jquery-3.1.1.min.js" ></script>
    <script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
</head>
<body>

    <%
        Admin admin = (Admin)session.getAttribute("admin");
    %>

    <nav class="nav navbar-inverse" role="navigotion" style="background:black">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="javascrpt:;" class="navbar-brand">网站管理后台</a>
            </div>

            <button class="navbar-toggle navbar-center" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <ul class="nav navbar-nav  navbar-right" style="width: 200px">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span><%= admin.getUserName()%>(超级管理员)<b class="caret"></b></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="javascript:;"  class="userinfo">个人信息</a></li>
                        <li><a href="javascript:;" class="xiugai">修改密码</a></li>
                        <li><a href="/admin/loginout">退出</a></li>
                    </ul>
                </li>
            </ul>

        </div>
    </nav>


    <div style="height: 15px"></div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <ul id="main-nav" class="nav nav-tabs nav-stacked collapse navbar-collapse">

                    <li class="active">
                        <a href="/admins/manage"><i class="glyphicon glyphicon-th-large"></i>首页</a>
                    </li>

                    <li><a href="#indexSetting" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-cog"></i>&nbsp;首页管理<span class="pull-right glyphicon glyphicon-chevron-down"></span></a>
                        <ul id="indexSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                            <li class="addmeu" data-href="/admins/banner"><a href="#">&nbsp;&nbsp;&nbsp;<i class="glyphicon glyphicon-picture"></i>&nbsp;轮播图管理</a></li>
                            <li class="addmeu" data-href="/admins/movie"><a href="#">&nbsp;&nbsp;&nbsp;<i class="glyphicon glyphicon-film"></i>&nbsp;电影管理</a></li>
                            <li class="addmeu" data-href="/admins/bullhorn"><a href="#">&nbsp;&nbsp;&nbsp;<i class="glyphicon glyphicon-bullhorn"></i>&nbsp;资讯管理</a></li>
                            <li class="addmeu" data-href="/admins/case"><a href="#">&nbsp;&nbsp;&nbsp;<i class="glyphicon glyphicon-book"></i>&nbsp;案例管理</a></li>
                            <li class="addmeu" data-href="/admins/news"><a href="#">&nbsp;&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i>&nbsp;新闻管理</a></li>
                        </ul>
                    </li>


                    <li><a href="#userSetting" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-credit-card"></i>&nbsp;系统管理<span class="pull-right glyphicon glyphicon-chevron-down"></span></a>
                        <ul id="userSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                            <li class="addmeu" data-href="/admins/usermanage"><a href="#">&nbsp;&nbsp;&nbsp;<i class="glyphicon glyphicon-credit-card"></i>&nbsp;用户管理</a></li>
                            <li class="addmeu" data-href="/admins/domanage"><a href="#">&nbsp;&nbsp;&nbsp;<i class="glyphicon glyphicon-credit-card"></i>&nbsp;角色权限管理</a></li>
                            <li class="addmeu" data-href="/admins/menumanage"><a href="#">&nbsp;&nbsp;&nbsp;<i class="glyphicon glyphicon-credit-card"></i>&nbsp;菜单管理</a></li>
                            <li class="addmeu" data-href="/admins/operationlog"><a href="#">&nbsp;&nbsp;&nbsp;<i class="glyphicon glyphicon-credit-card"></i>&nbsp;操作日志</a></li>
                        </ul>
                    </li>

                    <li>
                        <a href="#" class="addmeu" data-href="/admins/message"><i class="glyphicon glyphicon-globe"></i>&nbsp;留言管理
                            <span class="label label-warning pull-right">
                                5
                            </span>
                        </a>
                    </li>

                    <li>
                        <a href="#"  class="addmeu" data-href="/admins/chartdata"><i class="glyphicon glyphicon-calendar"></i>&nbsp;总览图表统计</a>
                    </li>
                    <li>
                        <a href="#"  class="addmeu" data-href="/admins/chartdatas"><i class="glyphicon glyphicon-calendar"></i>&nbsp;单日图表统计</a>
                    </li>

                    <li>
                        <a href="#" class="addmeu" data-href="/admins/operationlog"><i class="glyphicon glyphicon-fire"></i>&nbsp;关于系统</a>
                    </li>

                </ul>
            </div>

            <!--<div class="col-md-10">-->
                <!--主窗口-->
            <!--</div>-->

            <div class="col-md-10 column">
                <!--<div class="breadcrumbs" id="breadcrumbs">-->
                    <!--&lt;!&ndash; 面包屑导航 &ndash;&gt;-->
                    <!--<ul class="breadcrumb">-->
                        <!--<li><a href="#">Home</a></li>-->
                        <!--<li class="active">Dashboard</li>-->
                    <!--</ul>-->
                <!--</div>-->
                <div class="addpage">
                    <img style="width: 100%" src="/static/img/welcome.gif" alt="">
                    <!--<iframe id="iframe-page-content" src="/login" height="700px"   width="100%"  frameborder="no" border="0" marginwidth="0" marginheight=" 0" scrolling="no" allowtransparency="yes"></iframe>-->
                </div>
            </div>

        </div>

    </div>

    <div class="modal fade" style="margin-top: 5%" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabe">个人信息</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="txt_departmentname">部门名称</label>
                        <select class="form-control" style="width: auto">
                          <option>开发部</option>
                          <option>产品部</option>
                          <option>运营部</option>
                          <option>商务部</option>
                          <option>综合管理部</option>
                        </select>
                        <!--<input type="text" name="txt_departmentname" class="form-control" id="txt_departmentname" placeholder="部门名称" value="产品部">-->
                    </div>
                    <div class="form-group">
                        <label for="txt_departmentlevel">部门级别</label>
                        <input type="text" name="txt_departmentlevel" class="form-control" id="txt_departmentlevel" placeholder="部门级别" value="渣渣测试">
                    </div>
                    <div class="form-group">
                        <label for="txt_parentdepartment">邮箱账号</label>
                        <input type="text" name="txt_parentdepartment" class="form-control" id="txt_parentdepartment" placeholder="邮箱账号"  value="qiang.qian@downjoy.com">
                    </div>
                    <div class="form-group">
                       <label for="txt_statu">状态</label>
                        <select class="form-control" style="width: auto">
                          <option>启用</option>
                          <option>停用</option>
                        </select>
                       <!--<input type="text" name="txt_statu" class="form-control" id="txt_statu" placeholder="状态" value="启用">-->
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                    <button type="button" id="btn_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" style="margin-top: 5%" id="UPPassWord" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="UPPassWordLabe">修改密码</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="txt_departmentname">用户名</label>
                        <p class="form-control"><%= admin.getUserName()%></p>
                        <!--<input type="text" name="txt_departmentname" class="form-control" id="txt_departmentname" placeholder="部门名称" value="产品部">-->
                    </div>
                    <div class="form-group">
                        <label for="txt_departmentlevel">原密码</label>
                        <input type="password" name="txt_departmentlevel" class="form-control" id="pwtxt_departmentlevel" placeholder="原密码">
                    </div>
                    <div class="form-group">
                        <label for="txt_parentdepartment">新密码</label>
                        <input type="password" name="txt_parentdepartment" class="form-control" id="pwtxt_parentdepartment" placeholder="新密码">
                    </div>
                    <div class="form-group">
                        <label for="txt_parentdepartment">邮箱账号</label>
                        <input type="password" name="txt_parentdepartment" class="form-control" id="newpwtxt_parentdepartment" placeholder="确认密码">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                    <button type="button" id="PWbtn_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
                </div>
            </div>
        </div>
    </div>

    <div style="height: 50px"></div>
		<div class="footer navbar-fixed-bottom"  style="background: black">
			<div style="height: 15px"></div>
			<ul class="list-inline text-center">
				<li>Copyright ©2017.Benjamin Software All Rights Reserved.</li>
			</ul>
		</div>
	<div style="height: 15px"></div>
    <script type="text/javascript" src="/static/js/main.js"></script>

    <script type="text/javascript" language="javascript">
        function iFrameHeight() {
            var ifm= document.getElementById("iframe-page-content");
            var subWeb = document.frames ? document.frames["iframe-page-content"].document :
            ifm.contentDocument;
            if(ifm != null && subWeb != null) {
                    ifm.height = subWeb.body.scrollHeight+220;
                }
            }
    </script>
</body>
</html>