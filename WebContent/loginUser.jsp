<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>xkUser</title>
</head>
<body>
    <h1>欢迎${user.getUsername()}登录</h1>
    <table border="1px" cellspacing="0" cellpadding="5">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getUsername()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getIdentity()}</td>
        </tr>
    </table>
    <p><a href="index.jsp">返回首页</a></p>
</body>
</html>