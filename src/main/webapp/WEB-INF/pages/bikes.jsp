<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Bikes</title>
    <spring:url value="/resources/js/bike.js" var="bikeJs"/>
    <script src="${bikeJs}"></script>
    <style>

        th {
            background-color: #cccccc;
        }

        .error {

        }
    </style>
</head>
<body>
<c:if test="${not empty bicycles}">
    <div><a href='s'>servlet</a> | <a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/bike2/log.txt'>log.txt</a></div>
    <br>
    <table border=1 cellpadding=4 cellspacing=1>
        <tr>
            <th>id</th>
            <th>type</th>
            <th>price</th>
            <th>description</th>
            <th>change value</th>
        </tr>
        <c:forEach var="bike" items="${bicycles}">
            <tr>
                <td><c:out value="${bike.id}"/></td>
                <td><c:out value="${bike.type}"/></td>
                <td><c:out value="${bike.price}"/></td>
                <td><a href=<c:out value="javascript:getBicycle(${bike.id})"/>>description</a></td>
                <td><a href=<c:out value="s?id=${bike.id}"/>>change</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>
<br>

<div id="bicycleServiceResponse">
</div>
<div id="descriptionFormDiv" style="visibility:hidden;">
    <form name=descriptionForm>
        <table bgcolor='#cccccc'>
            <tr bgcolor='#ffffff'>
                <td bgcolor='#eeeeee' colspan=2>Description</TD>
            </tr>
            <tr bgcolor='#ffffff'>
                <td bgcolor='#cccccc' nowrap>Bicycle Id:</td>
                <td bgcolor='#cccccc'><input type=text name=bicycleId size=4 disabled></td>
            </tr>
            <tr bgcolor='#ffffff'>
                <td bgcolor='#cccccc' nowrap>Description:</td>
                <td bgcolor='#cccccc'><textarea name=description cols=25 rows=5></textarea></td>
            </tr>
            <tr bgcolor='#ffffff'>
                <td bgcolor='#cccccc' nowrap colspan=2><input type="button" value="Close"
                                                              onClick="hideDescriptionForm()"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>