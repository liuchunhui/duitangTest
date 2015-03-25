<%--
  Created by IntelliJ IDEA.
  User: huihui
  Date: 15-3-25
  Time: 下午8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>搜索</title>
</head>
<body>
<h2>请输入要搜索的关键词:</h2>
    <form method="post" action="serviceServlet">
        <input type="text" name="key" />
        <input type="submit" value="确定" />
    </form>

    <%--<jsp:forward page="result.jsp" />--%>
</body>
</html>
