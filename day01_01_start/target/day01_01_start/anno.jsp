<%--
  Created by IntelliJ IDEA.
  User: 宇澤
  Date: 2020/5/23
  Time: 上午 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--    常用的註解--%>
    <a href="anno/testRequestParam?uname=哈哈">RequestParam</a>

    <br/>

    <form action="/anno/testRequestBody" method="post">
        用戶姓名: <input type="text" name="username"/><br/>
        用戶年齡: <input type="text" name="age"/><br/>
        <input type="submit" value="送出"/>
    </form>

    <a href="/anno/testPathVariable/10">testPathVariable</a>

    <br/>

    <a href="/anno/testRequestHeader">RequestHeader</a>

    <br/>

    <a href="/anno/testCookieValue">CookieValue</a>

    <br/>

    <form action="/anno/testModelAttribute" method="post">
        用戶姓名: <input type="text" name="uname"/><br/>
        用戶年齡: <input type="text" name="age"/><br/>
        <input type="submit" value="送出"/>
    </form>

    <a href="/anno/testSessionAttributes">SessionAttributes</a>

    <br/>

    <a href="/anno/getSessionAttributes">getSessionAttributes</a>

    <br/>

    <a href="/anno/delSessionAttributes">delSessionAttributes</a>

    <br/>
</body>
</html>
