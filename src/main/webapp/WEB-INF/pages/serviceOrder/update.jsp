<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="serviceOrder" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/libs/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/libs/bootstrap/js/bootstrap.min.js" />"></script>
    <title>We will add serviceOrder</title>
</head>
<body>
<div class="container">
    <jsp:include page="../include/menu.jsp"/>

    <h1>Service Orders Connected To Service Request No ${serviceRequest.serviceRequest}</h1>
    <hr>

    <c:set var="serviceOrder"  value="${serviceRequest.serviceOrder}"/>
        <h3>Service Order No ${serviceOrder.serviceOrder} (${serviceOrder.note})</h3>
        <ul>
            <c:forEach var="device" items="${serviceOrder.devices}">
                <li><b>${device.name}</b></li>
                <i>Actions performed:</i>

                <ul>
                    <c:forEach var="serviceAction" items="${serviceOrder.serviceActions}">
                            <c:if test="${serviceAction.serviceDeviceFk == device.device}">
                                <li>
                                     ${serviceAction.actionDescription}
                                     (${serviceAction.serviceActionStatusType.typeName}) -
                                         ${serviceAction.price}(${serviceAction.serviceType.serviceUnitType.typeName})
                                     || ${serviceAction.serviceType.typeName}
                                </li>
                            </c:if>
                    </c:forEach>
                    <li>Töö: Teenus: Kogus: Ühiku hind: Hind kokku:
                    </li>
                </ul>


                <i>Parts changed:</i>

                <ul>
                    <c:forEach var="part" items="${serviceOrder.serviceParts}">
                        <c:if test="${part.serviceDevice.device.device == device.device}">
                            <li>${part.partName} - ${part.partCount} x ${part.partPrice}</li>
                        </c:if>
                    </c:forEach>
                </ul>

            </c:forEach>
        </ul>

        <b>ServiceOrderStatusType is</b>
        <select name="serviceOrderStatusType">
            <c:forEach items="${serviceOrderStatusTypes}" var="statusType">
                <option value="${statusType.soStatusType}" ${serviceOrder.serviceOrderStatusType.soStatusType == statusType.soStatusType ? 'selected' : ''}>${statusType.typeName}</option>
            </c:forEach>
        </select>


    <c:if test="${not empty serviceOrder.invoice}">
        <br>
        <br>
        <b>There is invoice for this order</b>
    </c:if>
        <hr>

    <div class="row">
        <div class="col-sm-5">
            <form:form method="post" action="update/addNewServiceOrder?serviceRequestId=${serviceRequest.serviceRequest}">
                <button class="btn btn-primary" type="submit">Add New Order</button>
            </form:form>
        </div>
    </div>

</div>
</body>
</html>