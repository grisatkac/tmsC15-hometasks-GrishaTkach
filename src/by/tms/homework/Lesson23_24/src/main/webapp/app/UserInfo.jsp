<%@ page import="com.example.lesson23_24.models.UserModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    UserModel token = (UserModel) session.getAttribute("Bearer");
    String name = token.getName();
    String email = token.getEmail();
    String role = token.getRole();
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User info</title>
    <style>
        header {
            text-align: center;
        }

        .main {
            text-align: center;
        }
    </style>
</head>

<body>
<header>
    <h1>User information</h1>
</header>
<main class="main">
    <div class="main-container">
        <p>Name: <%=name%></p>
        <p>Email: <%=email%></p>
        <p>Role: <%=role%></p>
    </div>
</main>
</body>

</html>
