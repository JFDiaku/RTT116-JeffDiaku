<%--
  Created by IntelliJ IDEA.
  User: jeffr
  Date: 12/13/2024
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Title</title>
</head>
<body class="">
    <div class="container-xl h-100">
        <jsp:include page="../include/header.jsp"/>

        <h1 class="text-center">Customer Search</h1>

        <form action="/customers" class="d-flex flex-column justify-content-center">
            <div class="w-75 d-flex gap-3 mx-auto mt-5" style="max-width:800px">
                <label class="form-label fs-4" for="firstName">Search:</label>
                <input type="text" class="form-control col-9 w-75 " id="firstName" name="customerName" value=${customerName} >
            </div>

            <button class="btn mb-3 mt-5 w-25 mx-auto btn-primary" type="submit">Submit form</button>
        </form>


        <h3 class="text-center mb-5">Customers found(${Customers.size()})</h3>


        <c:set var="count" value="0" scope="page" />

        <c:if test="${not empty Customers}">
            <c:set var="count" value="${count + 1}" scope="page"/>
            <table style="min-height: 200px" class="table px-3 px-md-5">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Contact First Name</th>
                        <th>Contact Last Name</th>
                        <th>id</th>
                        <th>Customer Name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="customer" items="${Customers}">
                        <tr>
                            <th scope="row">${count}</th>
                            <td>${customer.contactFirstname}</td>
                            <td>${customer.contactLastname}</td>
                            <td>${customer.id}</td>
                            <td>${customer.customerName}</td>
                        </tr>
                        <c:set var="count" value="${count + 1}" scope="page"/>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty Customers}">
            <div style="height: 22%"></div>
        </c:if>

        <jsp:include page="../include/footer.jsp"/>
    </div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
