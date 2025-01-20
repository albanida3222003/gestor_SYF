<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.unu.beans.Ventas"%>
<%@page import="com.unu.beans.Consumidor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body class="bg-dark text-light">
	<%@ include file="/cabecera.jsp"%>
	<div class="container mt-4">
        <h2 class="text-center">Lista de Ventas</h2>

        <div class="d-flex justify-content-end mb-3">
            <a href="VentasController?operacion=nuevo" class="btn btn-success">Registrar Nueva Venta</a>
        </div>

        <table class="table table-dark table-striped text-center">
            <thead>
                <tr>
                    <th>Fecha</th>
                    <th>Cantidad</th>
                    <th>Total</th>
                    <th>Empresa</th>
                    <th>Operaciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Ventas> ventas = (List<Ventas>) request.getAttribute("ventas");
                List<Consumidor> consumidor = (List<Consumidor>) request.getAttribute("consumidores");
                if (ventas != null) {
                    for (Ventas ven : ventas) {
                %>
                <tr>
                    <td><%= ven.getFecha() %></td>
                    <td><%= ven.getCantidad() %></td>
                    <td><%= ven.getTotalCoste() %></td>
                    <td><%= consumidor.get(ven.getIdConsumidor()).getNombre() %></td>
                    <td>
                        <a href="ConsumidoresController?operacion=editar&idConsumidor=<%= ven.getIdventas() %>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="ConsumidoresController?operacion=eliminar&idConsumidor=<%= ven.getIdventas() %>" class="btn btn-danger btn-sm">Eliminar</a>
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