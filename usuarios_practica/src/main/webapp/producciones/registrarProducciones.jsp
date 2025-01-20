<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.unu.beans.Producciones"%>
<%@page import="com.unu.beans.Empleados"%>
<%@page import="com.unu.beans.Contratos"%>
<%@page import="com.unu.beans.Departamentos"%>
<%@page import="com.unu.beans.Productos"%>
<%@page import="java.util.List"%>
<%@page import="com.unu.model.EmpleadosModel"%>
<%@page import="com.unu.model.ProductosModel"%>
<%@page import="com.unu.model.DepartamentosModel"%>
<%@page import="com.unu.model.ContratosModel"%>
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
	<%
	List<Empleados> empleados = new EmpleadosModel().listarEmpleados();
	List<Productos> productos = new ProductosModel().listarProductos();
	List<Contratos> contratos = new ContratosModel().listarContratos();
	List<Departamentos> departamentos = new DepartamentosModel().listarDepartamentos();
	%>
	<%@ include file="/cabecera.jsp"%>
	<div class="container mt-4">
		<h2 class="text-center">Registrar Nueva Produccion</h2>

		<div class="card bg-secondary p-4">
			<form action="ProduccionesController?operacion=insertar"
				method="POST">

				<div class="mb-3">
					<label class="form-label">Cantidad</label> <input type="number"
						name="cantidad" class="form-control" required min="1">
				</div>

				<div class="mb-3">
					<label class="form-label">Empleados</label> <select name="empleado"
						class="form-select" required>
						<%
						for (Empleados emp : empleados) {
							for (Contratos con : contratos) {
								if (con.getIdEmpleado() == emp.getIdEmpleados() && con.getIdDepartamento() == 3) {
						%>
						<option value="<%=emp.getIdEmpleados()%>"><%=emp.getNombre()%></option>
						<%
						}
						}
						}
						%>
					</select>
				</div>

				<div class="mb-3">
					<label class="form-label">Productos</label> <select name="producto"
						class="form-select" required>
						<%
						for (Productos prod : productos) {
						%>
						<option value="<%=prod.getIdproducto()%>"><%=prod.getColor()%></option>
						<%
						}
						%>
					</select>
				</div>

				<div class="mb-3">
					<label class="form-label">Fecha</label> <input type="date"
						name="fecha" class="form-control" required>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-success">Registrar
						Produccion</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>