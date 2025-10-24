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
    <title>mostrarSalarioEmpleado</title>
    <link href="${pageContext.request.contextPath}/css/styleSalario.css" rel="stylesheet" type="text/css">
</head>
<body>
    <header>
        <h1>Mostrar salario de un empleado concreto</h1>
    </header>

    <div id="tabla">
        <form action="empresa" method="post">
            <input type="hidden" name="opcionFormulario" value="buscarSalario">
            <table border="2px" class="tablaBorde">
                <tr>
                    <th>Dni:</th>
                    <td><input class="barraBusqueda" type="text" name="dni" size="9"></td>
                </tr>
            </table>
            <input class="boton" type="submit" value="Buscar">
        </form>

        <c:if test="${dni != null}">
            <p>El empleado con dni ${dni} cobra ${salario}€</p>
        </c:if>
    </div>

    <footer>
        <a href="${pageContext.request.contextPath}/index.jsp">
            <button class="boton">Volver</button>
        </a>
    </footer>

</body>
</html>