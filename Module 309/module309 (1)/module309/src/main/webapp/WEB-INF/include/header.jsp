<%--
  Created by IntelliJ IDEA.
  User: jeffr
  Date: 12/15/2024
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar bg-body-tertiary navbar-expand-lg mb-5 px-3  ">

    <div class="container-fluid">

        <a class="navbar-brand  " href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end " id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="../employees">Employees</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../customers">Customers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../customer/create">Create Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                </li>
            </ul>
        </div>

    </div>

</nav>

