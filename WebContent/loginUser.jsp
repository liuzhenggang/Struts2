<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>xkUser</title>
</head>
<body>
    <h1>欢迎<s:property value="#currentUser" />登录</h1>
    <table border="1px" cellspacing="0" cellpadding="5">
        <tr>
            <td>名称</td>
            <td>密码</td>
            <td>邮箱</td>
            <td>身份</td>
            <td>操作</td>
        </tr>
        <s:iterator id="user" value="users" status="status">
            <tr>
                <td><s:property value="#user.username" /></td>
                <td><s:property value="#user.password" /></td>
                <td><s:property value="#user.email" /></td>
                <td><s:property value="#user.identity" /></td>
                <td><a href="editUser.action?id=<s:property value="#user.id"/>">编辑</a></td>
                <td><a href="delUser.action?id=<s:property value="#user.id"/>">删除</a></td>
            </tr>
        </s:iterator>
    </table>
    <p><a href="userAdd.jsp">新增用户</a></p>
    <p><a href="index.jsp">返回首页</a></p>
</body>
</html>