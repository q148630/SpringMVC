<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="account/findAll">測試</a>

    <h3>測試保存</h3>

    <form action="account/save" method="post">
        姓名: <input type="text" name="name"><br/>
        金額: <input type="text" name="money"><br/>
        <input type="submit" value="保存">
    </form>

</body>
</html>
