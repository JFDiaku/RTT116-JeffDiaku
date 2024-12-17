<%--
  Created by IntelliJ IDEA.
  User: jeffr
  Date: 12/16/2024
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container-xl">
        <jsp:include page="../../include/header.jsp"/>
        <h1 class="text-center">Create Customer</h1>

        <form action="/customer/create" class="d-flex flex-column justify-content-center">
            <div class="row w-75 mx-auto mt-5 ">
                <label class="form-label fs-5 col-3" for="firstName">First name:</label>
                <input type="text" class="form-control col" id="firstName" name="firstName" value="" >
            </div>

            <div class="row w-75 mx-auto mt-5 ">
                <label class="form-label fs-5 col-3" for="lastName">Last name:</label>
                <input type="text" class="form-control col" id="lastName" name="lastName" value="" >
            </div>


            <div class="row w-75 mx-auto mt-5 ">
                <label class="form-label fs-5 col-3" for="customerName">Customer Name:</label>
                <input type="text" class="form-control col" id="customerName" name="customerName" value="" >
            </div>

            <div class="row w-75 mx-auto mt-5 ">
                <label class="form-label fs-5 col-3" for="phone">Phone:</label>
                <input type="text" class="form-control col" id="phone" name="phone" value="" >
            </div>

            <div class="row w-75 mx-auto mt-5 ">
                <label class="form-label fs-5 col-3" for="addressLine1">Address Line 1:</label>
                <input type="text" class="form-control col" id="addressLine1" name="addressLine1" value="" >
            </div>

            <div class="row w-75 mx-auto mt-5 ">
                <label class="form-label fs-5 col-3" for="addressLine2">Address Line 2:</label>
                <input type="text" class="form-control col" id="addressLine2" name="addressLine2" value="" >
            </div>

            <div class="row w-75 mx-auto mt-5 ">
                <label class="form-label fs-5 col-3" for="city">City:</label>
                <input type="text" class="form-control col" id="city" name="city" value="" >
            </div>

            <div class="row w-75 mx-auto mt-5 ">
                <label class="form-label fs-5 col-3 " for="state">State:</label>
                <input type="text" class="form-control col " id="state" name="state" value="" >
            </div>

            <div class="row w-75 mx-auto mt-5 ">
                <label class="form-label fs-5 col-2 " for="postal_code">Postal Code:</label>
                <input type="text" class="form-control col " id="postal_code" name="postal_code" value="" >
            </div>

            <div class="row w-75 mx-auto mt-5 ">
                <label class="form-label fs-5 col-2 " for="country">Country:</label>
                <input type="text" class="form-control col " id="country" name="country" value="" >
            </div>

            <div class="row w-75 mx-auto mt-5 ">
                <label class="form-label fs-5 col-2 " for="creditLimit">Credit Limit:</label>
                <input type="text" class="form-control col " id="creditLimit" name="creditLimit" value="" >
            </div>

            <button class="btn mb-3 mt-5 w-25 mx-auto btn-primary" type="submit">Submit form</button>
        </form>
        <jsp:include page="../../include/footer.jsp"/>
    </div>
</body>
</html>
