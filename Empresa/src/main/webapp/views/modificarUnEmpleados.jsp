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

    <div id="tabla">
        <form action="empresa" method="post">
            <input type="hidden" name="opcionFormulario" value="buscarEmpleado">
            <table border="2px" class="tablaBorde">
                <tr>
                    <th>Dni:</th>
                    <td><input class="barraBusqueda" type="text" name="dni" size="9"></td>
                </tr>
            </table>
            <input class="boton" type="submit" value="Buscar">
        </form>

        <c:if test="${empleado != null}">
            <form action="empresa" method="post">
                <input type="hidden" name="opcionFormulario" value="modificarEmpleado">
                <input type="hidden" name="dni" value="${empleado.dni}">
                <table border="2px" class="tablaBorde">
                    <tr>
                        <th>Nombre:</th>
                        <td><input class="barraBusqueda" type="text" name="nombre" value="${empleado.nombre}" size="50"></td>
                    </tr>
                    <tr>
                        <th>Sexo:</th>
                        <td><input class="barraBusqueda" type="text" name="sexo" value="${empleado.sexo}" size="50"></td>
                    </tr>
                    <tr>
                        <th>Categoria:</th>
                        <td><input class="barraBusqueda" type="text" name="categoria" value="${empleado.categoria}" size="50"></td>
                    </tr>
                    <tr>
                        <th>Años trabajados:</th>
                        <td><input class="barraBusqueda" type="text" name="anyosTrabajados" value="${empleado.categoria}" size="50"></td>
                    </tr>
                </table>
                <input class="boton" type="submit" value="Modificar">
            </form>
        </c:if>
    </div>

    <footer>
        <a href="${pageContext.request.contextPath}/index.jsp">
            <button class="boton">Volver</button>
        </a>
    </footer>

</body>
</html>
