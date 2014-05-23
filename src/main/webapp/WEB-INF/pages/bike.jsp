<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="bike" tagdir="/WEB-INF/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bike</title>
    <style>

        body {
            margin-left: 15px;
        }

        .bikeLabel {
            background-color: #cccccc;
        }

        .bikeRow {
            background-color: #ffffff;
        }

        .error{
            color: #ff0000;
        }

        label {
            float: left;
            text-align: right;
            margin-right: 15px;
            width: 100px;
        }

       button {
           position: absolute;
           display: block;
           margin-left: 120px;
       }
    </style>
</head>
<body>

    <div id="log"><a href='s'>servlet</a> | <a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/bike2/log.txt'>log.txt</a></div>
    <br>
    <form:form modelAttribute="bike" method="post" action="s?action=save">
        <input type="hidden" value="${bike.id}" name="id"/>
        <div class="control-group">
            <label class="control-label">Id</label>
            <div><c:out value="${bike.id}"/></div>
        </div>
         <bike:inputField name="type" label="Type"/>
         <bike:inputField name="price" label="Price"/>
         <bike:textArea name="description" label="Description" rowNum="6" colNum="30"/>
        <button type="submit">Submit</button>
    </form:form>
</body>
</html>