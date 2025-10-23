<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Menú de Opciones</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <header>
        <h1>Menu de Opciones Empleados</h1>
    </header>
    <div id="tabla">
        <table border="1">
            <tr>
                <td><a href="empresa?opcion=mostrarEmpleado"> Mostrar todos los empleado</a></td>
            </tr>
            <tr>
                <td><a href="empresa?opcion=mostrarSalarioEmpleado"> Mostrar el salario de un empleado</a></td>
            </tr>
            <tr>
                <td><a href="empresa?opcion=modificarUnEmpleados"> Modificar un empleado</a></td>
            </tr>
        </table>
    </div>
</body>
</html>