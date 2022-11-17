<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name = request.getParameter("name");
    String amount = request.getParameter("amount");
    String price = request.getParameter("price");

%>

<html>
<head>
    <title>Data</title>
</head>
<body>
    <div>
        <p>Name: <%=name%></p>
        <p>Amount: <%=amount%></p>
        <p>Price: <%=price%></p>
    </div>
</body>
</html>
