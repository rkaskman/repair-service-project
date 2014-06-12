<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="serviceRequest" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/libs/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"> </script>
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
        <table class="table table-striped">
            <tr><th>ID</th><th>Customer description</th><th>Employee description</th><th>Status</th><th>Edit</th><th>Summary</th></tr>
        <c:forEach var="request" items="${serviceRequests}">

            <tr>
                <td>${request.serviceRequest}</td>
                <td>${request.serviceDescByCustomer}</td>
                <td>${request.serviceDescByEmployee}</td>
                <td>${request.serviceRequestStatusType.typeName}</td>
                <td>

                    <c:choose>
                        <c:when test="${not empty request.serviceOrder}">
                            <a href="<c:url value="/service-order/updateServiceOrder?serviceOrderId=${request.serviceOrder.serviceOrder}"/>" class="btn btn-default">Edit service order</a>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${request.serviceRequestStatusType.serviceRequestStatusType == 1}">
                            <a href="<c:url value="/service-order/addNewServiceOrder?serviceRequestId=${request.serviceRequest}"/>"  class="btn btn-default">Create service order</a>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:if test="${not empty request.serviceOrder}">
                        <a class="btn btn-default" href="<c:url value="/service-order/update?serviceRequestId=${request.serviceRequest}" />">Summary</a>
                    </c:if>
                </td>


            </tr>
            <%--<li>--%>
                <%--<a href="<c:url value="/service-order/update?serviceRequestId=${request.serviceRequest}" />">Service request no ${request.serviceRequest} for client ${request.customer.retrieveCustomerName()}</a>--%>
            <%--</li>--%>
        </c:forEach>
        </table>
    </ul>

</div>

</body>
</html>