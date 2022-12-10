<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.tms.helpdesk.lesson34.entities.ticket.Ticket" %>
<html>
<head>
    <title>Tickets</title>
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
<div id="wrapper">
    <jsp:include page="sidebar.jsp" />
    <div id="content-wrapper" class="d-flex flex-column">
        <div id="content">
            <jsp:include page="header.jsp" />
            <div class="container-fluid">
                <h1 class="h3 mb-2 text-gray-800">Tables</h1>
                <p class="mb-4">On this page you can see all registered users</p>
                <div class="card shadow mb-4">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Title</th>
                                    <th>Description</th>
                                    <th>Status</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Id</th>
                                    <th>Title</th>
                                    <th>Description</th>
                                    <th>Status</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                    <c:set var="users" value='${requestScope["tickets"]}' />
                                    <c:forEach var="ticket" items="${tickets}">
                                        <tr>
                                            <td>${ticket.getId()}</td>
                                            <td>${ticket.getTitle()}</td>
                                            <td>${ticket.getDescription()}</td>
                                            <td>${ticket.getStatus().getValue()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </div>
</div>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="js/sb-admin-2.min.js"></script>
<script src="https://kit.fontawesome.com/a7a3734c85.js" crossorigin="anonymous"></script>

</body>
</html>
