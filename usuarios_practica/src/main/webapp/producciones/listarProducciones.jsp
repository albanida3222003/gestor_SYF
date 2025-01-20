<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.unu.beans.Producciones"%>
<%@page import="com.unu.beans.Empleados"%>
<%@page import="com.unu.beans.Productos"%>
<%@page import="java.util.List"%>
<%@page import="com.unu.model.EmpleadosModel"%>
<%@page import="com.unu.model.ProductosModel"%>
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
		<h2 class="text-center">Lista de Empleados</h2>

		<div class="d-flex justify-content-end mb-3">
			<a href="EmpleadosController?operacion=listar"
				class="btn btn-info me-2">Volver</a><a
				href="ProduccionesController?operacion=nuevo"
				class="btn btn-info me-2">Registrar Producción</a>
		</div>


		<table class="table table-dark table-striped text-center">
			<thead>
				<tr>
					<th>Fecha</th>
					<th>Cantidad</th>
					<th>Empleado</th>
					<th>Producto</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Producciones> produ = (List<Producciones>) request.getAttribute("producciones");
				List<Empleados> emp = new EmpleadosModel().listarEmpleados();
				List<Productos> productos = new ProductosModel().listarProductos();

				if (produ != null) {
					for (Producciones pro : produ) {
				%>
				<tr>
					<td><%=pro.getFechaProduccion()%></td>
					<td><%=pro.getCantidad()%></td>
					<td><%=emp.get(pro.getIdEmpleado()).getNombre()%></td>
					<td><%=productos.get(pro.getIdProducto()-1).getColor()%></td>
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