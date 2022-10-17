<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name of course</th>
            <th>Price</th>
            <th>Amount of student</th>
        </tr>
        </thead>

        <tbody>
        <c:if test="${courses.size() != 0}">
            <c:forEach var="course" items="${courses}">
                <tr>
                    <th>${course.getId()}</th>
                    <th>${course.getName()}</th>
                    <th>${course.getPrice()}</th>
                    <th>${course.getMaximumAmountOfStudents()}</th>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>

    <div>
        <p>Additional information about courses:</p>
        <div>
            <c:if test="${courses.size() != 0}">
                <c:forEach var="course" items="${courses}">
                    <div>
                        <p>${course.getName()} course</p>
                        <c:choose>
                            <c:when test="${course.getName() eq 'Java'}">
                                <p>Tech stack: Java Core, JSP, JSTL, SQL, Spring, Spring Boot</p>
                            </c:when>

                            <c:when test="${course.getName() eq 'Python'}">
                                <p>Tech stack: Django, Celery</p>
                            </c:when>

                            <c:when test="${course.getName() eq 'Go'}">
                                <p>Tech stack: Golang</p>
                            </c:when>
                        </c:choose>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
