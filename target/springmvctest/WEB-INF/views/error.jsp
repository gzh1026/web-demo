<%--
  Created by IntelliJ IDEA.
  User: gzh
  Date: 2020/5/29
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>您还没注册,请输入个人信息完成注册</h1>
<form action="/test/register" method="POST">
    姓名:<input type="text" name="user_name" placeholder="请输入姓名" autofocus><br/>
    邮箱:<input type="email" name="email" ><br/>
    电话:<input type="text" name="cellphone" ><br/>
    密码:<input type="password" name="password" ><br/>
    <input type="submit" value="注册完成"><br/>
</form>
</body>
</html>
