<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<Map<String, String[]>> allData = (ArrayList<Map<String, String[]>>) session.getAttribute("allData");
%>

<html>
<head>
    <title>List</title>
</head>
<body>
<%
    for (Map<String, String[]> data : allData) {
        out.print("<h2> data item: </h2>");
        out.print("<ul>");
        Set<Map.Entry<String, String[]>> entries = data.entrySet();
        for (Map.Entry<String, String[]> field : entries) {
            out.print("<li>" + field.getValue()[0] + "</li>");
        }
        out.print("</ul>");
    }
%>

</body>
</html>
