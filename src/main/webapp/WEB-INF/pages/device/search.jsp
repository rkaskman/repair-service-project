<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="searchDeviceForm" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/libs/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/libs/bootstrap/js/bootstrap.min.js" />"></script>
    <title>We will search device here</title>
</head>
<body>
<jsp:include page="../include/menu.jsp"/>
<div class="container">
    <h1>Search</h1>
    <hr>
    <div class="row">
        <div class="col-sm-5">
            <form:form modelAttribute="searchDeviceForm" method="post" action="search">
                <searchDeviceForm:inputField name="device.name" label="Name:"/>
                <searchDeviceForm:inputField name="device.model" label="Model:"/>
                <searchDeviceForm:inputField name="device.regNo" label="RegNo:"/>
                <searchDeviceForm:inputField name="clientName" label="Client Name:"/>
                <form:select class="form-control" path="deviceTypeId" items="${deviceTypes}"/>
                <br>
                <button class="btn btn-primary" type="submit">Search</button>
            </form:form>
        </div>
    </div>

    <h3>Search result</h3>
    <c:forEach var="result" items="${searchResult}">
        <br>
        <c:out value="${result}"/>
    </c:forEach>
</div>
</div>
</body>
</html>