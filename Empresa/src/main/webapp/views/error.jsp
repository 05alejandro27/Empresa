<%--
  Created by IntelliJ IDEA.
  User: alexcry
  Date: 17/10/25
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>paginaError</title>
</head>
<body>

    <h1>Surgio un error</h1>

    <c:if test="${error}}">
        <p>${error}</p>
    </c:if>

    <c:if test="${!error}}">
        <p>${error}</p>
    </c:if>

</body>
</html>
