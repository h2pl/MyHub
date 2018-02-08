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
<button id ="create">增</button>
<button id ="delete">删</button>
<button id ="put">改</button>
<button id ="get">查</button>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/json.js"></script>

<script>
    alert("<%=basePath%>");
//
//    $(document).ready(function(){
//        $("#get").click(function(){
//            $.get("mysql/get",function(data,status){
//                alert("数据：" + data + "\n状态：" + status);
//            });
//            alert("get")
//        });
//    });
    $(document).ready(function(){
        $("#create").click(function(){
            $.postJSON("mysql/create",
                {
                    "username" : "hpl",
                    "password" : 123
                },
                function (msg) {
                    alert(msg)
                }
            )
        });
    });
//    $(document).ready(function(){
//        $("#delete").click(function(){
//            $.delete("mysql/get",function(data,status){
//                alert("数据：" + data + "\n状态：" + status);
//            });
//            alert("get")
//        });
//    });
//    $(document).ready(function(){
//        $("#get").click(function(){
//            $.get("mysql/get",function(data,status){
//                alert("数据：" + data + "\n状态：" + status);
//            });
//            alert("get")
//        });
//    });
</script>
</body>
</html>
