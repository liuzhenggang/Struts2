<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>xkUser</title>
</head>
<body>
<h1>欢迎<s:property value="#session.currentUser"/>登录</h1>
<s:form action="searchUser" method="post">
    <label for="username">名称：</label>
    <input id="username" type="text" name="user.username"/>
    <label for="password">密码：</label>
    <input id="password" type="text" name="user.password"/>
    <br/>
    <label for="email">邮箱：</label>
    <input id="email" type="text" name="user.email"/>
    <label for="identity">身份：</label>
    <input id="identity" type="checkbox" name="user.identity" value="admin"/>管理员
    <input type="checkbox" name="user.identity" value="user"/>用户
    <br/>
    <input id="search" type="submit" value="搜索"/>
</s:form>
<a>当前页：</a>${pageNum}
<a>总页数：</a>${maxPage}
<s:if test="pageNum != 1">
<a href="searchUser.action?pageNum=${pageNum - 1}">上一页<a/>
</s:if>

<s:if test="pageNum != maxPage">
<a href="searchUser.action?pageNum=${pageNum + 1}">下一页<a/>
</s:if>

<table border="1px" cellspacing="0" cellpadding="5">
    <s:token/>
    <tr>
        <td>ID</td>
        <td>名称</td>
        <td>密码</td>
        <td>邮箱</td>
        <td>身份</td>
        <td>操作</td>
    </tr>
    <s:iterator id="user" value="users" status="status">
        <tr>
            <td><s:property value="#user.id"/></td>
            <td><s:property value="#user.username"/></td>
            <td><s:property value="#user.password"/></td>
            <td><s:property value="#user.email"/></td>
            <td><s:property value="#user.identity"/></td>
            <td><a href="editUser.action?id=<s:property value="#user.id"/>&pageNum=${pageNum}">编辑</a>
                <a href="delUser.action?id=<s:property value="#user.id"/>&pageNum=${pageNum}">删除</a>
            </td>
        </tr>
    </s:iterator>
</table>
<p><a href="goAdd.action?pageNum=${pageNum}">新增用户</a></p>
<p><a href="index.jsp">返回首页</a></p>
</body>
</html>