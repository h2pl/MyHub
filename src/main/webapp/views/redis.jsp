<%--
  Created by IntelliJ IDEA.
  User: 周杰伦
  Date: 2018/2/8
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>增</p>
<p>删</p>
<p>改</p>
<p>查</p>

</body>
</html>
