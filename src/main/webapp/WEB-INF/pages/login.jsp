<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="/resources/libs/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="/resources/libs/bootstrap/js/bootstrap.min.js" ></script>
<title>Log in</title>
</head>
<body class="preview" id="top" data-spy="scroll">
<jsp:include page="include/menu.jsp" />
  <div class="container">
    <div class="row">
      <div class="well span4 offset4">

        <h1>Log in</h1>
          <div id="login-error">${error}</div>

        <form action="j_spring_security_check" method="post">
          <table>
            <tr>
              <th>Username:</th>
              <td><input name="j_username" type="text" /></td>
            </tr>
            <tr>
              <th>Password:</th>
              <td><input name="j_password" type="password" /></td>
            </tr>
            <tr>
              <th />
              <td><input type="submit" value="Log in" /></td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  </div>
</body>
</html>