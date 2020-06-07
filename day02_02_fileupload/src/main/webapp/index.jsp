<%--
  Created by IntelliJ IDEA.
  User: 宇澤
  Date: 2020/6/1
  Time: 下午 01:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>傳統文件上傳</h3>

    <form action="/user/fileupload1" method="post" enctype="multipart/form-data">
        選擇文件: <input type="file" name="upload"/><br/>
        <input type="submit" value="上傳">
    </form>

    <h3>SpringMVC 文件上傳</h3>

    <form action="/user/fileupload2" method="post" enctype="multipart/form-data">
        選擇文件: <input type="file" name="upload"/><br/>
        <input type="submit" value="上傳">
    </form>

    <h3>跨 Server 文件上傳</h3>

    <form action="/user/fileupload3" method="post" enctype="multipart/form-data">
        選擇文件: <input type="file" name="upload"/><br/>
        <input type="submit" value="上傳">
    </form>
</body>
</html>
