<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Log in</title>


</head>
<body class="preview" id="top" data-spy="scroll">
  <div class="container">
    <div class="row">
      <div class="well span4 offset4" style="margin-top: 50px;">

        <h1>Log in</h1>

        <c:if test="${not empty param.error}">
          <p class="error">Login failed</p>
        </c:if>

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