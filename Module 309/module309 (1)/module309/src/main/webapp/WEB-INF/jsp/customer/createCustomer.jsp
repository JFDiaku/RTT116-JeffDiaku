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

        <form action="/customer/createCustomer" class="w-50 grid row mx-auto row-gap-0 rounded bg-secondary-subtle px-3 pb-5 mt-5 ">

            <div class="col-6 mx-auto mt-5 ">
                <label class="form-label fs-6 " for="customerName">Customer Name:</label>
                <input type="text" class="form-control " id="customerName" name="customerName" value="" >
            </div>

            <div class="col-6 mx-auto mt-5 ">
                <label class="form-label fs-6 " for="firstName">First name:</label>
                <input type="text" class="form-control " id="firstName" name="firstName" value="" >
            </div>

            <div class="col-6 mx-auto mt-5 ">
                <label class="form-label fs-6 " for="lastName">Last name:</label>
                <input type="text" class="form-control " id="lastName" name="lastName" value="" >
            </div>

            <div class="col-6 mx-auto mt-5 ">
                <label class="form-label fs-6 " for="phone">Phone:</label>
                <input type="text" class="form-control " id="phone" name="phone" value="" >
            </div>

            <div class="col-6 mx-auto mt-5 ">
                <label class="form-label fs-6 " for="addressLine1">Address Line 1:</label>
                <input type="text" class="form-control " id="addressLine1" name="addressLine1" value="" >
            </div>

            <div class="col-6 mx-auto mt-5 ">
                <label class="form-label fs-6 " for="city">City:</label>
                <input type="text" class="form-control " id="city" name="city" value="" >
            </div>

            <div class="col-6 mx-auto mt-5 ">
                <label class="form-label fs-6 " for="country">Country:</label>
                <input type="text" class="form-control  " id="country" name="country" value="" >
            </div>

            <div></div>

            <button class="btn w-25 btn-primary col-4 mx-auto mt-5" type="submit">Submit form</button>

        </form>



        <jsp:include page="../../include/footer.jsp"/>
    </div>
</body>
</html>
