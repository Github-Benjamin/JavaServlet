<%--
  Created by IntelliJ IDEA.
  User: Anonymous
  Date: 2018/1/20
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>

<%--import导入AccountBean即可--%>
<%@ page import="com.login.AccountBean" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>success</title>
</head>
<body>

    <%
        AccountBean account = (AccountBean)session.getAttribute("account");
    %>
        username:<%= account.getUsername()%>
        <br>
        password:<%= account.getPassword() %>

</body>
</html>

