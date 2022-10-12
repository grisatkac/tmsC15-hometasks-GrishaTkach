<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/delete" method="post">
    <p>Please select field which will use for deleting: </p>
    <div>
        <label>
            <input type="radio" name="field" value="name">
            name
        </label>

        <label>
            <input type="radio" name="field" value="amount">
            amount
        </label>

        <label>
            <input type="radio" name="field" value="price">
            price
        </label>
    </div>
    <p>Please input value</p>
    <div>
        <label>
            <input type="text" name="value" />
            Value
        </label>
    </div>

    <input type="submit" value="Delete items" />
</form>
</body>
</html>
