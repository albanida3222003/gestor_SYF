<%@page import="com.unu.model.ContratosModel"%>
<%@page import="java.util.List"%>
<%@page import="com.unu.beans.Empleados"%>
<%@page import="com.unu.beans.Contratos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empleados</title>
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
			<a href="ProduccionesController?operacion=listar"
				class="btn btn-info me-2">Lista Produccion</a> <a
				href="ProduccionesController?operacion=nuevo"
				class="btn btn-info me-2">Registrar Producción</a> <a
				href="ContratosController?operacion=nuevo"
				class="btn btn-primary me-2">Registrar Contrato</a> <a
				href="<%=url%>EmpleadosController?operacion=nuevo"
				class="btn btn-success">Registrar Nuevo Empleado</a>

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
				List<Contratos> contratos = (List<Contratos>) request.getAttribute("contratos");

				if (empleados != null) {
					for (Empleados emp : empleados) {
				%>
				<tr>
					<td><%=emp.getNombre()%></td>
					<td><%=emp.getApellido()%></td>
					<td><%=emp.getTelefono()%></td>
					<td><%=emp.getCorreo()%></td>
					<td><%=emp.getDireccion()%></td>
					<%
					Contratos con = new ContratosModel().obtener(emp.getIdEmpleados());
					if (con != null) {
					%>
					<td><%=con.getVigencia()%></td>
					<%
					} else {
					%>
					<td>Inactivo</td>
					<%
					}
					%>
					<td><a
						href="EmpleadosController?operacion=obtener&idEmpleado=<%=emp.getIdEmpleados()%>"
						class="btn btn-warning btn-sm">Editar</a></td>
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