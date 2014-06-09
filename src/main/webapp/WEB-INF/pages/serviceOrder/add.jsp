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

</style>
</head>
<body>
<jsp:include page="../include/menu.jsp"/>
<div class="container" id="container">

    <h1 class="text-left">Add Service Order</h1>

    <div>
       <strong>Service customer: <c:out value="${serviceRequest.customer.retrieveCustomerName()}"/> </strong>
    </div>

    <div id="orderDevices">
        <strong>Devices added to service order:</strong>
        <div id="devices">
            <table id="deviceTable">

            </table>
            <input id="serviceRequestId" value="<c:out value="${serviceRequest.serviceRequest}"/>" type="hidden"/>
        </div>
        <button class="btn btn-primary" onclick="submitServiceOrder()">Submit Order</button>
    </div>

    <div  id="deviceSearch" class="form-group col-lg-3">
        <h3>Search fo device</h3>
        <form:form id="deviceSearchForm" modelAttribute="searchDeviceForm">
            <searchDevice:inputField name="device.name" label="Name:"/>
            <searchDevice:inputField name="device.model" label="Model:"/>
            <searchDevice:inputField name="device.regNo" label="RegNo:"/>
            <searchDevice:inputField name="clientName" label="Client Name:"/>
            <form:select class="form-control" path="deviceTypeId" items="${deviceTypes}"/>
            <br>
        </form:form>
        <button class="btn btn-primary" onclick="searchForDevices()">Search</button>
    </div>

    <div id="foundDevices" class="col-lg-5">

    </div>

    <div  id="addNewDevice" class="form-group col-lg-3">
                <form:form id="addDeviceForm" modelAttribute="addDeviceForm">
                    <addDeviceForm:inputField name="device.name" label="Name:"/>
                    <addDeviceForm:inputField name="device.model" label="Model:"/>
                    <addDeviceForm:textArea name="device.description" label="Description:" rowNum="6" colNum="30"/>
                    <addDeviceForm:inputField name="device.manufacturer" label="Manufacturer:"/>
                    <addDeviceForm:inputField name="device.regNo" label="Registration Number:"/>
                    <form:select class="form-control" path="deviceTypeId" items="${deviceTypes}"/>
                    <br>
                </form:form>
        <button class="btn btn-primary" onclick="addNewDevice()">Add Device</button>
    </div>

</div>

</body>
</html>