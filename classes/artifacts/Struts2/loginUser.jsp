<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>xkUser</title>
</head>
<body>
<<<<<<< HEAD
    <h1>欢迎${currentUser}登录</h1>
=======
    <h1>欢迎<s:property value="#currentUser" />登录</h1>
>>>>>>> 810dc95c998d5e6e2eb24e8d88b697d773ef7251
    <table border="1px" cellspacing="0" cellpadding="5">
        <tr>
            <td>ID</td>
            <td>名称</td>
            <td>密码</td>
            <td>邮箱</td>
            <td>身份</td>
        </tr>
        <s:iterator id="user" value="users" status="status">
<<<<<<< HEAD
            <s:set var="id" value="#user.id" />
            <s:set var="username" value="#user.username" />
            <s:set var="password" value="#user.password" />
            <s:set var="email" value="#user.email" />
            <s:set var="identity" value="#user.identity" />
            <tr>
                <td><s:property value="#id" /></td>
                <td><s:property value="#username" /></td>
                <td><s:property value="#password" /></td>
                <td><s:property value="#email" /></td>
                <td><s:property value="#identity" /></td>
=======
            <tr>
                <td><s:property value="#user.id" /></td>
                <td><s:property value="#user.username" /></td>
                <td><s:property value="#user.password" /></td>
                <td><s:property value="#user.email" /></td>
                <td><s:property value="#user.identity" /></td>
>>>>>>> 810dc95c998d5e6e2eb24e8d88b697d773ef7251
            </tr>
        </s:iterator>
    </table>
    <p><a href="index.jsp">返回首页</a></p>
</body>
</html>