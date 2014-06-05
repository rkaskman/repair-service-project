<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="serviceOrder" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>We will add serviceOrder</title>
</head>
<body>
    <h1>Service Order</h1>
    <hr>

<c:forEach var="serviceOrder" items="${serviceOrders}">

    <h2>Devices</h2>
    <c:forEach var="result" items="${serviceOrder.devices}">
        <br>
        <c:out value="${result}"/>
        <br>
    </c:forEach>

    <h2>Invoices</h2>
    <c:forEach var="result" items="${serviceOrder.invoices}">
        <br>
        <c:out value="${result}"/>
    </c:forEach>

    <h2>serviceActions</h2>
    <c:forEach var="result" items="${serviceOrder.serviceActions}">
        <br>
        <c:out value="${result}"/>
    </c:forEach>

    <h2>serviceParts</h2>
    <c:forEach var="result" items="${serviceOrder.serviceParts}">
        <br>
        <c:out value="${result}"/>
    </c:forEach>

    <h2>ServiceOrderStatusType is ${serviceOrder.serviceOrderStatusType}</h2>

</c:forEach>
</body>
</html>