<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="serviceRequest" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/libs/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/libs/bootstrap/js/bootstrap.min.js" />"> </script>
    <title>We will serviceRequest</title>

    <spring:url value="/resources/js/jquery.min.js" var="jquery"/>
    <spring:url value="/resources/js/bike.js" var="appJs"/>

    <script src="${jquery}"></script>
    <script src="${appJs}"></script>

</head>
<body>
<jsp:include page="../include/menu.jsp"/>
<div class="container">


    <h1>Add Service Request</h1>
    <hr>

    <c:if test="${successMessage}">
        <div class="alert alert-success">Service Request is created!</div>
    </c:if>

    <input type="text" name="requestClientSearchField">
    <button onclick="searchForClient()">Search</button>
    <div id="customerData"></div>
    <input class="form-control" name="customerIdTemp" type="hidden">
    <form:form modelAttribute="serviceRequest" method="post" action="add">
        <input class="form-control" name="customerId" type="hidden"/>
        <serviceRequest:textArea  name="serviceDescByCustomer" label="serviceDescByCustomer" rowNum="6" colNum="30"/>
        <serviceRequest:textArea name="serviceDescByEmployee" label="serviceDescByEmployee" rowNum="6" colNum="30"/>
        <div id="customerName"></div>
        <button class="btn btn-primary" type="submit">Submit</button>
    </form:form>
</div>

</body>
</html>