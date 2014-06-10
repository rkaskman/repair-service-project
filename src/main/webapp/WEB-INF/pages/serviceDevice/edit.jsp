<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="serviceDevice" tagdir="/WEB-INF/tags" %>

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

        #deviceSelector {
            padding: 12px;
        }

        #devices td {
            padding: 5px;
        }

        #serviceOrderNote {
            float: right;
        }

        #container {
            overflow: hidden;
        }

    </style>
</head>
<body>
<jsp:include page="../include/menu.jsp"/>
<div class="container" id="container">

    <h1 class="text-left">Device service details</h1>

    <div class="row">
        <div class="col-lg-4">
        <form:form id="serviceDevices" role="form" method="get">
            <input name="serviceOrderId" type="hidden" value="${serviceOrderId}">
            <label class="control-label">Device in service:</label>
            <select name="deviceId" class="form-control" id="deviceSelector">
                <c:forEach var="device" items="${deviceList}">
                    <option value="${device.device}" ${device.device == selectedDeviceId ? 'selected="selected"' : ''}>${device.name}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-primary">Select device</button>
        </form:form>
        </div>
    </div>
</div>

</body>
</html>