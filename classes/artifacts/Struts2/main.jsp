<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome To Struts2!</title>
</head>
<body>
<s:debug/>
<hr/>
EL表达式取出user和user2两个用户的信息：
<br/>
<h2>user username:${user.username} &nbsp;&nbsp; user email:${user.email}</h2>
<h2>user2 username:${user2.username} &nbsp;&nbsp; user2 email:${user2.email}</h2>
<hr/>
s标签取出user和user2两个用户的信息：
<br/>
<h2>
    user username:<s:property value="user.username"/>&nbsp;&nbsp;
    user email:<s:property value="user.email"/>
</h2>
<h2>
    user username:<s:property value="#user.username"/>&nbsp;&nbsp;
    user email:<s:property value="#user.email"/>
</h2>

<h2>
    <font color="red">user2 username: <s:property value="#user2.username"/>
</h2>
<h2>
    <font color="red">user2 email: <s:property value="#user2.email"/>
</h2>
<hr/>
<p><a href="index.jsp">返回首页</a></p>
</body>
</html>