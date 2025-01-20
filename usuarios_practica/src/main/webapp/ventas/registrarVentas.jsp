<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.unu.beans.Producciones"%>
<%@page import="com.unu.beans.Empleados"%>
<%@page import="com.unu.beans.Contratos"%>
<%@page import="com.unu.beans.Departamentos"%>
<%@page import="com.unu.beans.Productos"%>
<%@page import="com.unu.beans.Consumidor"%>
<%@page import="java.util.List"%>
<%@page import="com.unu.model.EmpleadosModel"%>
<%@page import="com.unu.model.ConsumidorModel"%>
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
	List<Consumidor> consumidor = new ConsumidorModel().listarConsumidores();
	%>
	<%@ include file="/cabecera.jsp"%>
	<div class="container mt-4">
		<h2 class="text-center">Registrar Nueva Venta</h2>

		<div class="card bg-secondary p-4">
			<form action="VentasController?operacion=insertar"
				method="POST">

				<div class="mb-3">
					<label class="form-label">Cantidad</label> <input type="number"
						name="cantidad" id="cantidad" class="form-control" required
						min="1" value="1" oninput="calcularTotal()">
				</div>

				<div class="mb-3">
					<label class="form-label">Productos</label> <select name="producto"
						id="producto" class="form-select" required
						onchange="actualizarPrecio()">
						<option value="<%=productos.get(0).getIdproducto()%>"
							data-precio="0.25">
							<%=productos.get(0).getColor()%>
						</option>
						<option value="<%=productos.get(1).getIdproducto()%>"
							data-precio="0.30">
							<%=productos.get(1).getColor()%>
						</option>
					</select>
				</div>

				<div class="mb-3">
					<label class="form-label">Precio del Producto: </label> <span name = "precio"
						id="precio">0.25</span>
				</div>

				<div class="mb-3">
					<label class="form-label">Total (Cantidad × Precio): </label> <span
						id="totalVenta">0.25</span>
				</div>

				<script>
					function actualizarPrecio() {
						var selectProducto = document
								.getElementById("producto");
						var precioSpan = document.getElementById("precio");

						// Obtener el precio del producto seleccionado
						var precio = parseFloat(selectProducto.options[selectProducto.selectedIndex]
								.getAttribute("data-precio")) || 0;

						// Mostrar el precio en el span
						precioSpan.textContent = precio.toFixed(2);

						// Calcular el total
						calcularTotal();
					}

					function calcularTotal() {
						var cantidad = parseInt(document
								.getElementById("cantidad").value) || 1;
						var precio = parseFloat(document
								.getElementById("precio").textContent) || 0;
						var total = cantidad * precio;

						document.getElementById("totalVenta").textContent = total
								.toFixed(2);
					}
				</script>


				<div class="mb-3">
					<label class="form-label">Consumidor</label> <select
						name="consumidor" class="form-select" required>
						<%
						for (Consumidor con : consumidor) {
						%>
						<option value="<%=con.getIdconsumidor()%>"><%=con.getNombre()%></option>
						<%
						}
						%>
					</select>
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
					<label class="form-label">Fecha</label> <input type="date"
						name="fecha" class="form-control" required>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-success">Registrar
						Venta</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>