<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="searchDeviceForm" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>We will search device here</title>
</head>
<body>
<h1>Search</h1>
    <form:form modelAttribute="searchDeviceForm" method="post" action="search">
         <searchDeviceForm:inputField name="device.name" label="name"/>
         <searchDeviceForm:inputField name="device.model" label="model"/>
         <searchDeviceForm:textArea name="device.description" label="description" rowNum="6" colNum="30"/>
         <searchDeviceForm:inputField name="device.manufacturer" label="manufacturer"/>
         <searchDeviceForm:inputField name="device.regNo" label="regNo"/>

         <form:select path="deviceTypeId" items="${deviceTypes}" />

         <button type="submit">Submit</button>
    </form:form>
<h3>Search result</h3>
    <c:forEach var="result" items="${searchResult}">
        <br>
        <c:out value="${result}"/>
    </c:forEach>
</body>
</html>