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
    <title>mostrarEmpleado</title>
</head>
<body>
    <h1>Mostrar todos los empleados</h1>
    <table border="1">
        <tr>
            <td>Dni</td>
            <td>Nombre</td>
            <td>Dni</td>
            <td>Sexo</td>
            <td>Categoria</td>
            <td>Anyos</td>
        </tr>
        <c:forEach var="empleado" items="${lista}">
            <tr>
                <td>
                    <a href="empleado?opcion=meditar&id=<c:out value="${ empleado.dni}"></c:out>">
                        <c:out value="${ empleado.dni}"></c:out>
                    </a>
                </td>

                <td><c:out value="${ empleado.nombre}"></c:out></td>
                <td><c:out value="${ empleado.dni}"></c:out></td>
                <td><c:out value="${ empleado.sexo}"></c:out></td>
                <td><c:out value="${ empleado.categoria}"></c:out></td>
                <td><c:out value="${ empleado.anyos}"></c:out></td>

            </tr>
        </c:forEach>
    </table>
</body>
</html>
