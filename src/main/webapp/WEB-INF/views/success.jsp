<%--
  Created by IntelliJ IDEA.
  User: gzh
  Date: 2020/5/29
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@page isELIgnored="false" import="com.test.dao.Userloginlog,com.test.entity.userloginlog"  %>

<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //驱动程序名
    String driverName="com.mysql.jdbc.Driver";
//数据库用户名
    String userName="root";
//密码
    String userPasswd="admin";
//数据库名
    String dbName="bagevent_test";
//表名
    String tableName="userloginlog";
//联结字符串
    String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection connection=DriverManager.getConnection(url);
    Statement statement = connection.createStatement();
    String sql="SELECT * FROM "+tableName;
    ResultSet rs = statement.executeQuery(sql);
//获得数据结果集合
    ResultSetMetaData rmeta = rs.getMetaData();
//确定数据集的列数，亦字段数
//    int numColumns=rmeta.getColumnCount();
// 输出每一个数据值
    out.print("login_id");
    out.print("|");
    out.print("user_id");
    out.print("|");
    out.print("login_time");
    out.print("|");
    out.print("login_ip");
    out.print("<br>");
    while(rs.next()) {
        out.print(rs.getString(1)+" ");
        out.print("|");
        out.print(rs.getString(2));
        out.print("|");
        out.print(rs.getString(3));
        out.print("|");
        out.print(rs.getString(4));
        out.print("<br>");
    }
    out.print("<br>");
    out.print("Congratulations!");
    rs.close();
    statement.close();
    connection.close();
%>

</body>
</html>
