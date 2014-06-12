<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="searchDevice" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="addDeviceForm" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/libs/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"> </script>
    <script type="text/javascript" src="<c:url value="/resources/libs/bootstrap/js/bootstrap.min.js" />"> </script>
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
<jsp:include page="../include/menu.jsp"/>
<div class="container" id="container">

    <h1 class="text-left">Service Orders</h1>
    <div id="allServiceOrders">
        <table id="foundDevicesTable" class="table table-striped">
            <tr><th>#Id</th><th>Customer</th><th>Note</th><th>Go to edit</th><th>View</th><th>Invoice</th></tr>
            <c:forEach var="serviceOrder" items="${serviceOrders}">
               <tr><td>${serviceOrder.serviceOrder}</td><td>${serviceOrder.serviceRequest.customer.retrieveCustomerName()}</td>
                   <td>${serviceOrder.note}</td><td><a class='btn btn-default' href="<c:url value="/service-order/updateServiceOrder?serviceOrderId=${serviceOrder.serviceOrder}"/>">Edit</a></td>
                   <td><a class='btn btn-default' href="<c:url value="/service-order/update?serviceRequestId=${serviceOrder.serviceRequest.serviceRequest}"/>">View</a></td>
                   <td><a class='btn btn-default' href="<c:url value="/invoice/doInvoice?serviceOrderId=${serviceOrder.serviceOrder}"/>">Do Invoice</a></td></tr>
            </c:forEach>

        </table>
    </div>


</div>

</body>
</html>