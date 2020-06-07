<%--
  Created by IntelliJ IDEA.
  User: 宇澤
  Date: 2020/5/29
  Time: 下午 01:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery-min.js"></script>

    <script>
        // 頁面載入，綁定點擊事件
        $(function () {
            $("#btn").click(function () {
                // alert("hello btn");
                // 發送 ajax 請求
                $.ajax({
                    // 編寫 json 格式，設置屬性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe", "password":"123", "age":30}',
                    dataType:"json",
                    type:"post",
                    success: function (data) {
                        // data 服務器端響應的 json 的資料，進行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                })
            });
        });
    </script>
</head>
<body>

    <a href="user/testString">testString</a>

    <br/>

    <a href="user/testVoid">testVoid</a>

    <br/>

    <a href="user/testModelAndView">testModelAndView</a>

    <br/>

    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>

    <br/>

    <button id="btn">發送 ajax 請求</button>
</body>
</html>
