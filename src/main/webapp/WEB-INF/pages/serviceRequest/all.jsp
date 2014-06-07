<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="serviceRequest" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/libs/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/libs/bootstrap/js/bootstrap.min.js" />"></script>
    <title>We will serviceRequest</title>

    <spring:url value="/resources/js/jquery.min.js" var="jquery"/>
    <spring:url value="/resources/js/bike.js" var="appJs"/>

    <script src="${jquery}"></script>
    <script src="${appJs}"></script>

</head>
<body>
<jsp:include page="../include/menu.jsp"/>
<div class="container">


    <h1>All Service Requests</h1>
    <hr>
    <ul>
        <c:forEach var="request" items="${serviceRequests}">
            <li>
                <a href="<c:url value="/service-order/update?serviceRequestId=${request.serviceRequest}" />">Service request no ${request.serviceRequest} created by ${request.createdBy} for client ${request.customer}</a>
            </li>
        </c:forEach>
    </ul>

</div>

</body>
</html>