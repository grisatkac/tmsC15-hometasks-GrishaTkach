<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Todo Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>

<form:form action="/todo/form" method="POST" modelAttribute="task">
    <div>
        <table>
            <tr>
                <td>Title</td>
                <td><form:input path="title" type="text" name="title" modelAttribute="student"/></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><form:input path="description" type="text" name="description"/></td>
            </tr>
        </table>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </div>
</form:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>
