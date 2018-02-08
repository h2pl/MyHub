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
<a href="mysql"><p>mysql test</p></a>
<a href="redis"><p>redis test</p></a>
<a href="dubbo"><p>dubbo test</p></a>
<a href="mq"><p>mq" test</p></a>
<a href="hadoop"><p>hadoop test</p></a>

</body>
</html>