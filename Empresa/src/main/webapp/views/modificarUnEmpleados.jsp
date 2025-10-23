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
    <title>modificarUnEmpleado</title>
    <link href="${pageContext.request.contextPath}/css/styleModificar.css" rel="stylesheet" type="text/css">
</head>
<body>
    <header>
        <h1>Modificar un empleado</h1>
    </header>

    <form action="empresa" method="post">
    <input type="hidden" name="opcionFormulario" value="buscarEmpleado">
    <table border="1">
        <tr>
            <td>Dni:</td>
            <td><input type="text" name="dni" size="9"></td>
        </tr>
    </table>
    <input type="submit" value="buscar">
    </form>

    <c:if test="${empleado != null}">
        <form action="empresa" method="post">
            <input type="hidden" name="opcionFormulario" value="modificarEmpleado">
            <input type="hidden" name="dni" value="${empleado.dni}">
            <table border="1">
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" value="${empleado.nombre}" size="50"></td>
                </tr>
                <tr>
                    <td>Sexo:</td>
                    <td><input type="text" name="sexo" value="${empleado.sexo}" size="50"></td>
                </tr>
                <tr>
                    <td>Categoria:</td>
                    <td><input type="text" name="categoria" value="${empleado.categoria}" size="50"></td>
                </tr>
                <tr>
                    <td>Años trabajados:</td>
                    <td><input type="text" name="anyosTrabajados" value="${empleado.categoria}" size="50"></td>
                </tr>
            </table>
            <input type="submit" value="modificar">
        </form>
    </c:if>

    <a href="${pageContext.request.contextPath}/index.jsp">
        <button type="button">Volver</button>
    </a>


</body>
</html>
