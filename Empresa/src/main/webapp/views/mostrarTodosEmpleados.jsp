<%--
  Created by IntelliJ IDEA.
  User: alexcry
  Date: 17/10/25
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mostrarTodosEmpleados</title>
    <link href="${pageContext.request.contextPath}/css/styleMostrar.css" rel="stylesheet" type="text/css">
</head>
<body>
    <header>
        <h1>Mostrar todos los empleados</h1>
    </header>

    <div id="tabla">
        <table border="2px" class="tablaBorde">
            <tr>
                <th>Nombre</th>
                <th>Dni</th>
                <th>Sexo</th>
                <th>Categoria</th>
                <th>Años trabajados</th>
            </tr>
            <c:forEach var="empleado" items="${lista}">
                <tr>

                    <td><c:out value="${ empleado.nombre}"></c:out></td>
                    <td><c:out value="${ empleado.dni}"></c:out></td>
                    <td><c:out value="${ empleado.sexo}"></c:out></td>
                    <td><c:out value="${ empleado.categoria}"></c:out></td>
                    <td><c:out value="${ empleado.anyos}"></c:out></td>

                </tr>
            </c:forEach>
        </table>
    </div>

    <footer>
        <a href="${pageContext.request.contextPath}/index.jsp">
            <button class="boton">Volver</button>
        </a>
    </footer>

</body>
</html>
