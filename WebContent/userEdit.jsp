<%--
  Created by IntelliJ IDEA.
  User: xinya
  Date: 2018/12/12
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<s:debug/>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
    <s:form action="updUser" method="post">
        <input type="hidden" name="user.id" value=${user.id} />
        <label for="username">名称：</label>
        <input id="username" type="text" name="user.username" value=${user.username}> <br/>
        <label for="password">密码：</label>
        <input id="password" type="password" name="user.password" value=${user.password}> <br/>
        <label for="email">邮箱：</label>
        <input id="email" type="text" name="user.email" value=${user.email}> <br/>
        <label for="identity">身份：</label>
        <input id="identity" name="user.identity" type="radio" value="user" checked=<s:if test="user.identity=='user'"> "checked" </s:if> />user
        <input type="radio"  name="user.identity" value="admin" <s:if test="user.identity=='admin'"> checked="checked" </s:if> />admin <br/>

        <input type="submit" value="更新"/>
    </s:form>
</body>
</html>
