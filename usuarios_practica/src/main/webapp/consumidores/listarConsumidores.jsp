<%@page import="java.util.List"%>
<%@page import="com.unu.beans.Consumidor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Consumidores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-dark text-light">

    <%@ include file="/cabecera.jsp" %>

    <div class="container mt-4">
        <h2 class="text-center">Lista de Consumidores</h2>

        <div class="d-flex justify-content-end mb-3">
            <a href="ConsumidoresController?operacion=nuevo" class="btn btn-success">Registrar Nueva Venta</a>
        </div>

        <table class="table table-dark table-striped text-center">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Teléfono</th>
                    <th>Correo</th>
                    <th>Dirección</th>
                    <th>Operaciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Consumidor> consumidores = (List<Consumidor>) request.getAttribute("consumidores");
                if (consumidores != null) {
                    for (Consumidor cons : consumidores) {
                %>
                <tr>
                    <td><%= cons.getNombre() %></td>
                    <td><%= cons.getTelefono() %></td>
                    <td><%= cons.getCorreo() %></td>
                    <td><%= cons.getDireccion() %></td>
                    <td>
                        <a href="ConsumidoresController?operacion=editar&idConsumidor=<%= cons.getIdconsumidor() %>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="ConsumidoresController?operacion=eliminar&idConsumidor=<%= cons.getIdconsumidor() %>" class="btn btn-danger btn-sm">Eliminar</a>
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
