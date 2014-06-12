<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="addNote" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/libs/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/libs/bootstrap/js/bootstrap.min.js" />"></script>
    <title>We will serviceRequest</title>

    <spring:url value="/resources/js/jquery.min.js" var="jquery"/>
    <spring:url value="/resources/js/bike.js" var="appJs"/>

    <script src="${jquery}"></script>
    <script src="${appJs}"></script>
    <style>
        #orderDevices {
            padding-bottom: 12px;
        }

        #foundDevices {
            padding-left: 15px;
            float: left;
        }

        #devices {
            padding: 12px;
        }

        #devices td {
            padding: 5px;
        }

    </style>
</head>
<body>
<jsp:include page="../include/menuUser.jsp"/>
<div class="container" id="container">

    <h1 class="text-left">Service order #${serviceOrder.serviceOrder}</h1>

    <h3 class="text-left">Devices:</h3>

    <div id="devices" class="col-lg-8">
        <table id="foundDevicesTable" class="table table-striped">
            <tr>
                <th>Name</th>
                <th>RegNo</th>
                <th>Description</th>
                <th>Model</th>
            </tr>
            <c:forEach var="device" items="${serviceOrder.devices}">
            <tr>
                <td>${device.name}</td>
                <td>${device.regNo}</td>
                <td>${device.description}</td>
                <td>${device.model}</td>
                </c:forEach>
        </table>
    </div>

    <div class="row">
        <div class="col-lg-10">
            <div><strong>Service order status: ${serviceOrder.serviceOrderStatusType.typeName}</strong></div>
            <hr>

            <div><strong>Current cost: ${currentCost} </strong></div>

            <h3 class="text-left">Service notes</h3>
            <c:forEach var="note" items="${serviceOrder.serviceNotes}">
                <div><strong>Author</strong>: ${note.getNoteAuthorName()}, <strong>Added:</strong> ${note.created}</div>
                <div><strong>Content:</strong> ${note.note}</div>
                <br>
            </c:forEach>

            <%--<c:if test="${serviceOrder.serviceOrderStatusType.soStatusType != 4}">--%>
            <div>
                <h3 class="text-left">Add new note:</h3>
                <form:form action="addCustomerNote" method="post">
                    <input type="hidden" name="serviceOrderId" value="${serviceOrder.serviceOrder}">
                    <input type="hidden" name="customerId" value="${serviceOrder.serviceRequest.customer.customer}">
                    <label class="control-label">Note content:</label>
                    <textArea class="form-control" name="customerNote" rows="6" cols="30"></textArea>
                    <button type="submit" class="btn btn-default">Add note</button>
                </form:form>
            </div>
            <%--</c:if>--%>
        </div>
    </div>
</div>

</body>
</html>
