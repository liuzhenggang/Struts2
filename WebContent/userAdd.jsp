<%--
  Created by IntelliJ IDEA.
  User: xinya
  Date: 2018/12/12
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>增加用户</title>
</head>
<body>
<s:form action="addUser" method="post">
    <label for="username">名称：</label>
    <input id="username" type="text" name="user.username"> <br/>
    <label for="password">密码：</label>
    <input id="password" type="password" name="user.password"> <br/>
    <label for="email">邮箱：</label>
    <input id="email" type="text" name="user.email"> <br/>
    <label for="identity">身份：</label>
    <input id="identity" name="user.identity" type="radio" value="user" checked="checked"/>user
    <input name="user.identity" type="radio" value="admin"/>admin <br/>

    <input type="submit" value="添加"/>
</s:form>
</body>
</html>
