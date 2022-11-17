<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/delete" method="post">
    <p>Please input item id for deleting this user: </p>
    <div>
        <label>
            <input type="number" name="id-field" />
        </label>
    </div>
    <input type="submit" value="Delete items" />
</form>
</body>
</html>
