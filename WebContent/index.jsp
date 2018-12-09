<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome To Struts2!</title>
</head>
<body>
<h1>Welcome To Struts2!</h1>
<p><a href="<s:url action='getUser'/>">用两种方式取出用户信息</a></p>
<s:form action="getLoginUser" method="post">
    <label for="username">用户姓名：</label>
    <input id="username" type="text" name="username"> <br/>
    <label for="password">用户密码：</label>
    <input id="password" type="password" name="password"> <br/>
    <input type="submit" value="登录"/>
</s:form>
</body>
</html>