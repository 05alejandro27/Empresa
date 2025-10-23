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

    <table border="1">
        <tr>
            <td>Nombre</td>
            <td>Dni</td>
            <td>Sexo</td>
            <td>Categoria</td>
            <td>Anyos</td>
        </tr>
        <c:forEach var="empleado" items="${lista}">
            <tr>
                <%---Esto sería en caso de que en un futuro nos pidieran modificar el cliente
                    <td>
                        <a href="empleado?opcion=meditar&id=<c:out value="${ empleado.dni}"></c:out>">
                            <c:out value="${ empleado.dni}"></c:out>
                        </a>
                    </td>
                --%>

                <td><c:out value="${ empleado.nombre}"></c:out></td>
                <td><c:out value="${ empleado.dni}"></c:out></td>
                <td><c:out value="${ empleado.sexo}"></c:out></td>
                <td><c:out value="${ empleado.categoria}"></c:out></td>
                <td><c:out value="${ empleado.anyos}"></c:out></td>

            </tr>
        </c:forEach>
    </table>

    <a href="${pageContext.request.contextPath}/index.jsp">
        <button type="button">Volver</button>
    </a>


</body>
</html>
