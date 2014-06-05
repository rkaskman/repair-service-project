<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="serviceOrder" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/libs/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/libs/bootstrap/css/bootstrap-theme.min.css">
    <title>We will add serviceOrder</title>
</head>
<body>
<jsp:include page="../include/menu.jsp" />

    <h1>Service Order No ${serviceRequestId}</h1>
    <hr>

<c:forEach var="serviceOrder" items="${serviceOrders}">

    <h2>Devices</h2>
    <hr>
    <ul>
    <c:forEach var="device" items="${serviceOrder.devices}">
        <li><c:out value="${device.name}"/></li>
    </c:forEach>
    </ul>

    <h2>Actions performed</h2>
    <hr>
    <ul>
    <c:forEach var="serviceAction" items="${serviceOrder.serviceActions}">
        <li><c:out value="${serviceAction.actionDescription}"/> (${serviceAction.serviceActionStatusType.typeName}) -
                ${serviceAction.price}(${serviceAction.serviceType.serviceUnitType.typeName}) || ${serviceAction.serviceType.typeName}
        </li>
    </c:forEach>
    </ul>

    <h2>Parts changed</h2>
    <hr>
    <ul>
    <c:forEach var="part" items="${serviceOrder.serviceParts}">
        <li><c:out value="${part.partName}"/> - ${part.partCount} x ${part.partPrice}</li>
    </c:forEach>
    </ul>

    <h3>ServiceOrderStatusType is ${serviceOrder.serviceOrderStatusType.typeName}</h3>
    <h3>There are ${fn:length(serviceOrder.invoices)} invoices done for this order</h3>

</c:forEach>
</body>
</html>