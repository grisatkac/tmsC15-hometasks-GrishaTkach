<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.example.lesson26.pojo.Identity" %>
<%@ page import="com.example.lesson26.pojo.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Set<Map.Entry<Identity, Item>> allData = ((Map<Identity, Item>) session.getAttribute("allData")).entrySet();
%>

<html>
<head>
    <title>List</title>
</head>
<body>
<%
    for (Map.Entry<Identity, Item> data : allData) {
        out.print("<h2> data item: </h2>");
        out.print("<ul>");
        out.print("<li><p> user id: " + data.getKey().getId() + "</p></li>");
        out.print("<li><p> user name: " + data.getValue().getName() + "</p></li>");
        out.print("<li><p> amount: " + data.getValue().getAmount() + "</p></li>");
        out.print("<li><p> price: " + data.getValue().getPrice() + "</p></li>");
        out.print("</ul>");
    }
%>

</body>
</html>
