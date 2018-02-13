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
<button id ="create">增</button><br>
username: <input type="text" id = "username"><br>
password: <input type="password" id = "password">
<br>
<button id ="delete">删</button>
<br>
id:<input type="text" id = "deleteid">
<br>

<button id ="put">改</button>
<br>
id:<input type="text" id = "editid">
<br>

<button id ="get">查</button>
<br>
id:<input type="text" id = "getid">

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/json.js"></script>

<script>
    <%--alert("<%=basePath%>");--%>
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
            var username = $("#username").val();
            var password = $("#password").val();
            $.postJSON("mysql/create",
                {
                    "userName" : username,
                    "passWord" : password
                },
                function (msg) {
                    JSON.stringify(msg)
                }
            )
        });
    });
    $(document).ready(function(){
        $("#get").click(function(){
            var id = $("#getid").val();
            $.getJSON("mysql/get/" + id,{

            },
                function (msg) {
                    alert(JSON.stringify(msg))
                }
            )
        });
    });
    $(document).ready(function(){
        $("#delete").click(function(){
            var id = $("#deleteid").val();
            $.deleteJSON("mysql/delete/" + id,{

                },
                function (msg) {
                    alert(JSON.stringify(msg))
                }
            )
        });
    });
    $(document).ready(function(){
        $("#put").click(function(){
            var id = $("#editid").val();
            $.putJSON("mysql/edit",{
                    "id" : id,
                    "userName" : "hpl",
                    "passWord" : "2345"
                },
                function (msg) {
                    alert(JSON.stringify(msg))
                }
            )
        });
    });

</script>
</body>
</html>
