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
    <h1>Add</h1>

    <c:if test="${successMessage}">
        <div class="alert alert-success">Device is created!</div>
    </c:if>

    <form:form modelAttribute="addDeviceForm" method="post" action="add">
        <addDeviceForm:inputField name="device.name" label="name"/>
        <addDeviceForm:inputField name="device.model" label="model"/>
        <addDeviceForm:textArea name="device.description" label="description" rowNum="6" colNum="30"/>
        <addDeviceForm:inputField name="device.manufacturer" label="manufacturer"/>
        <addDeviceForm:inputField name="device.regNo" label="regNo"/>

        <form:select path="deviceTypeId" items="${deviceTypes}"/>

        <button type="submit">Submit</button>
    </form:form>
</div>
</body>
</html>