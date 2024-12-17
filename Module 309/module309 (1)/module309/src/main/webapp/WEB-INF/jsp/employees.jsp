<%--
  Created by IntelliJ IDEA.
  User: jeffr
  Date: 12/12/2024
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<div class="container">
    <jsp:include page="../include/header.jsp"/>
<h1 class="text-center">Employees Search</h1>

<form action="/employees" class="d-flex flex-column justify-content-center">
    <div class="row w-75 mx-auto mt-5 ">
        <label class="form-label fs-4 w-25" for="firstName">First name</label>
        <input type="text" class="form-control col-9 w-75 " id="firstName" name="employee" value=${employee} >
    </div>

    <button class="btn mb-3 mt-5 w-25 mx-auto btn-primary" type="submit">Submit form</button>
</form>


<h3 class="text-center mb-5">Employees found(${employees.size()})</h3>

<c:set var="count" value="0" scope="page" />

<c:if test="${not empty employees}">
    <c:set var="count" value="${count + 1}" scope="page"/>
    <table class="table">
        <thead>
            <tr>
                <th>#</th>
                <th>Employee id</th>
                <th>Employee Name</th>
                <th>Employee Email</th>
                <th>Vacation Hours</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="name" items="${employees}">
            <tr>
                <th  scope="row">${count}</th>
                <td>${name.id}</td>
                <td>${name.lastname}</td>
                <td>${name.email}</td>
                <td>${name.vacationHours}</td>
            </tr>
            <c:set var="count" value="${count + 1}" scope="page"/>
        </c:forEach>
        </tbody>
    </table>
    </c:if>


    <c:if test="${empty employees}">
        <div style="height: 22%"></div>
    </c:if>

    <jsp:include page="../include/footer.jsp"/>
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
