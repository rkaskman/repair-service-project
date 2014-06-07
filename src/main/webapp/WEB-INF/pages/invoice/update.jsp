<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="invoice" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/libs/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/libs/bootstrap/js/bootstrap.min.js" />"></script>
    <title>We will serviceRequest</title>
</head>
<body>
<jsp:include page="../include/menu.jsp"/>
<div class="container">
    <h1>Invoice No ${invoice.invoice}</h1>
    <hr>

    <div class="row">
        <div class="col-sm-5">
            <form:form modelAttribute="invoice" method="post" action="add">
                <invoice:inputField name="description" label="Description:"/>
                <invoice:inputField name="priceTotal" label="Price:"/>
                <invoice:inputField name="referenceNumber" label="Reference Number:"/>
                <invoice:inputField name="receiverAccounts" label="Receiver Account:"/>
                <invoice:inputField name="receiverName" label="Receiver Name:"/>
                <invoice:inputField name="paymentDate" label="Payment Date:"/>

                <select name="invoiceStatusType">
                    <c:forEach items="${invoiceStatusTypes}" var="invoiceStatusType">
                        <option value="${invoiceStatusType.invoiceStatusType}" ${invoiceStatusType.invoiceStatusType == invoice.invoiceStatusType.invoiceStatusType ? 'selected' : ''}>${invoiceStatusType.typeName}</option>
                    </c:forEach>
                </select>

                <br> <br>
                <button class="btn btn-primary" type="submit">Save Invoice</button>
            </form:form>
        </div>
        <div class="col-sm-7">
            <h3>Invoice Rows:</h3>
            <hr>
            <ul>
                <c:forEach items="${invoice.invoiceRows}" var="invoiceRow">
                    <li>${invoiceRow.actionPartDescription} -> ${invoiceRow.amount}(${invoiceRow.unitType}) x ${invoiceRow.unitPrice}  </li>
                </c:forEach>
            </ul>
        </div>
    </div>

    </div>
    </body>
    </html>