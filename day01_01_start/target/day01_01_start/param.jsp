<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--    請求參數綁定--%>
<%--    <a href="/param/testParam?username=hehe&password=123">請求參數綁定</a>--%>

<%--    把數據封裝到 Account 類中--%>
<%--        <form action="/param/saveAccount" method="post">--%>
<%--            姓名: <input type="text" name="username"/><br/>--%>
<%--            密碼: <input type="text" name="password"/><br/>--%>
<%--            金額: <input type="text" name="money"/><br/>--%>
<%--            用戶姓名: <input type="text" name="user.uname"/><br/>--%>
<%--            用戶年齡: <input type="text" name="user.age"/><br/>--%>
<%--            <input type="submit" value="送出"/>--%>
<%--        </form>--%>


    <%--    把數據封裝到 Account 類中，類中存在 List 和 Map 的集合--%>
<%--    <form action="/param/saveAccount" method="post">--%>
<%--        姓名: <input type="text" name="username"/><br/>--%>
<%--        密碼: <input type="text" name="password"/><br/>--%>
<%--        金額: <input type="text" name="money"/><br/>--%>

<%--        用戶姓名: <input type="text" name="list[0].uname"/><br/>--%>
<%--        用戶年齡: <input type="text" name="list[0].age"/><br/>--%>

<%--        用戶姓名: <input type="text" name="map['one'].uname"/><br/>--%>
<%--        用戶年齡: <input type="text" name="map['one'].age"/><br/>--%>
<%--        <input type="submit" value="送出"/>--%>
<%--    </form>--%>

<%--    自定義類型轉換器
    <form action="/param/saveUser" method="post">
        用戶姓名: <input type="text" name="uname"/><br/>
        用戶年齡: <input type="text" name="age"/><br/>
        用戶生日: <input type="text" name="date"/><br/>
        <input type="submit" value="送出"/>
    </form>--%>

    <a href="/param/testServlet">Servlet 原生的 API</a>
</body>
</html>
