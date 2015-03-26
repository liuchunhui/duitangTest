<%--
  Created by IntelliJ IDEA.
  User: huihui
  Date: 15-3-26
  Time: 上午1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.main.huihui.tool.UrlBookModel" %>
<html>
<head>
    <title>结果</title>
</head>
<body>
    <% LinkedList<UrlBookModel> books = (LinkedList<UrlBookModel>)request.getAttribute("books"); %>

    <h1>显示结果(设为抓取置前100本书)</h1>
    <center><table border="1">
        <tr>
            <td>书籍名称</td>
            <td>电子书价格</td>
        </tr>

        <%
            for (UrlBookModel book : books) {
                out.print("<tr><td>" + book.getName() + "</td><td>");

                if (book.getPrice() == null) {
                    out.println("无</td></tr>");
                }else {
                    out.println(book.getPrice() + "</td></tr>");
                }
            }
        %>
    </table></center>




</body>
</html>
