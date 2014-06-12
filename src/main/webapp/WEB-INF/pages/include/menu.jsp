<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="bike" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/" />">RepairService</a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Device <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/device/add" />">Add Device</a></li>
                        <li><a href="<c:url value="/device/search" />">Search Device</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Service Request <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/service-request/add" />">Add Service Request</a></li>
                        <li><a href="<c:url value="/service-request/all" />">All Service Requests</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Service Order <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/service-order/listAll" />">Show service orders</a></li>
                        <li><a href="<c:url value="/service-order/addNewServiceOrder?serviceRequestId=1" />">Add service order</a></li>

                    </ul>
                </li>

                <li><a href="<c:url value="/invoice/update?serviceOrderId=1" />">Search Invoice</a></li>

            </ul>

            <ul class="nav navbar-nav" style="float: right">
                <li><a href="<c:url value="/logout"/>">Logout</a></li>
            </ul>
        </div>
    </div>
</div>
<div style="margin-bottom: 30px;padding-bottom: 30px"></div>