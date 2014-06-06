<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="addDeviceForm" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/libs/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/libs/bootstrap/js/bootstrap.min.js" />"> </script>
    <title>We will add device here</title>
</head>
<body>
<jsp:include page="../include/menu.jsp"/>
<div class="container">
    <h1>Add Device</h1>
    <hr>

    <c:if test="${successMessage}">
        <div class="alert alert-success">Device is created!</div>
    </c:if>
    <div class="row">
        <div class="col-sm-5">
        <form:form modelAttribute="addDeviceForm" method="post" action="add">
            <addDeviceForm:inputField name="device.name" label="Name:"/>
            <addDeviceForm:inputField name="device.model" label="Model:"/>
            <addDeviceForm:textArea name="device.description" label="Description:" rowNum="6" colNum="30"/>
            <addDeviceForm:inputField name="device.manufacturer" label="Manufacturer:"/>
            <addDeviceForm:inputField name="device.regNo" label="Registration Number:"/>
            <form:select class="form-control" path="deviceTypeId" items="${deviceTypes}"/>
            <br>
            <button class="btn btn-primary" type="submit">Add Device</button>
        </form:form>
        </div>
    </div>
</div>
</body>
</html>