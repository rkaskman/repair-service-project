<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="serviceRequest" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/libs/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/libs/bootstrap/css/bootstrap-theme.min.css">
    <title>We will serviceRequest</title>
</head>
<body>
    <form:form modelAttribute="serviceRequest" method="post" action="add">
         <serviceRequest:textArea name="serviceDescByCustomer" label="serviceDescByCustomer" rowNum="6" colNum="30"/>
         <serviceRequest:textArea name="serviceDescByEmployee" label="serviceDescByEmployee" rowNum="6" colNum="30"/>
         <button type="submit">Submit</button>
    </form:form>
</body>
</html>