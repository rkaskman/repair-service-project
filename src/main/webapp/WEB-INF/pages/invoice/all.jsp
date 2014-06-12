<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="updateInvoiceForm" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/libs/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/libs/bootstrap/js/bootstrap.min.js" />"></script>
    <title>We will serviceRequest</title>
</head>
<body>
<jsp:include page="../include/menuUser.jsp"/>
<div class="container">
    <h1>Your Invoices</h1>
    <hr>

    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped">
                <tr>
                    <th>description</th>
                    <th>referenceNumber</th>
                    <th>senderAccount</th>
                    <th>senderName</th>
                    <th>priceTotal</th>
                    <th>actions done</th>
                </tr>
                <c:forEach items="${invoices}" var="invoice">
                <tr>
                    <td>${invoice.description}</td>
                    <td>${invoice.referenceNumber}</td>
                    <td>${invoice.receiverAccounts}</td>
                    <td>${invoice.receiverName}</td>
                    <td>${invoice.priceTotal}</td>
                    <td><c:forEach items="${invoice.invoiceRows}" var="invoiceRow">
                        <li>${invoiceRow.actionPartDescription} -> ${invoiceRow.amount}(${invoiceRow.unitType}) x ${invoiceRow.unitPrice}  </li>
                    </c:forEach></td>
                </tr>
                </c:forEach>
            </table>
        </div>

    </div>
</div>
</body>
</html>