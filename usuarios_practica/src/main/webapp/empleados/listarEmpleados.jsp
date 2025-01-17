<%@page import="java.util.List"%>
<%@page import="com.unu.beans.Empleados"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Empleados</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-dark text-light">

    <%@ include file="/cabecera.jsp" %>

    <div class="container mt-4">
        <h2 class="text-center">Lista de Empleados</h2>

        <div class="d-flex justify-content-end mb-3">
            <a href="<%=url%>EmpleadosController?operacion=nuevo" class="btn btn-success">Registrar Nuevo Empleado</a>
        </div>

        <table class="table table-dark table-striped text-center">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Teléfono</th>
                    <th>Correo</th>
                    <th>Dirección</th>
                    <th>Vigencia</th>
                    <th>Operaciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Empleados> empleados = (List<Empleados>) request.getAttribute("empleados");
                if (empleados != null) {
                    for (Empleados emp : empleados) {
                %>
                <tr>
                    <td><%= emp.getNombre() %></td>
                    <td><%= emp.getApellido() %></td>
                    <td><%= emp.getTelefono() %></td>
                    <td><%= emp.getCorreo() %></td>
                    <td><%= emp.getDireccion() %></td>
                    <td></td> <%-- Espacio en blanco para Vigencia --%>
                    <td>
                        <a href="EmpleadosController?operacion=editar&idEmpleado=<%= emp.getIdEmpleados() %>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="EmpleadosController?operacion=produccion&idEmpleado=<%= emp.getIdEmpleados() %>" class="btn btn-info btn-sm">Producción</a>
                        <a href="EmpleadosController?operacion=contrato&idEmpleado=<%= emp.getIdEmpleados() %>" class="btn btn-primary btn-sm">Contrato</a>
                    </td>
                </tr>
                <%
                    }
                }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
