<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>Error</title>
</head>
<body>
  <c:if test="${not empty error}">
      <div><a href='s'>servlet</a> | <a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/bike/log.txt'>log.txt</a></div>
      <br>
      <div><c:out value="${error}"/></div>
  </c:if>
</body>
</html>
