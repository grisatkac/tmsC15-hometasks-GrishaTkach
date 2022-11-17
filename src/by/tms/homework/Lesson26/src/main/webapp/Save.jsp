<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/save" method="post">
    <input type="text" name="name" placeholder="input your name" />
    <input type="number" name="amount" placeholder="input amount" />
    <input type="number" name="price" placeholder="input price" />
    <input type="submit" value="send information"/>
</form>
</body>
</html>
