<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.unu.beans.Consumidor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Consumidor</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ include file="/cabecera.jsp"%>

	<div class="container mt-4">
		<h2 class="text-center">Editar Consumidor</h2>

		<%
		Consumidor consumidor = (Consumidor) request.getAttribute("consumidor");
		%>

		<div class="card bg-secondary p-4">
			<form action="ConsumidoresController" method="POST">
				<input type="hidden" name="operacion" value="editar"> <input
					type="hidden" name="idconsumidor"
					value="<%=consumidor.getIdconsumidor()%>">
				
				<div class="mb-3">
					<label class="form-label">Id</label> <input type="text" name="id"
						class="form-control" value="<%=consumidor.getIdconsumidor()%>"
						required>
				</div>

				<div class="mb-3">
					<label class="form-label">Nombre</label> <input type="text"
						name="nombre" class="form-control"
						value="<%=consumidor.getNombre()%>" required>
				</div>

				<div class="mb-3">
					<label class="form-label">Correo</label> <input type="email"
						name="correo" class="form-control"
						value="<%=consumidor.getCorreo()%>" required>
				</div>

				<div class="mb-3">
					<label class="form-label">Teléfono</label> <input type="text"
						name="telefono" class="form-control"
						value="<%=consumidor.getTelefono()%>" required>
				</div>

				<div class="mb-3">
					<label class="form-label">Dirección</label> <input type="text"
						name="direccion" class="form-control"
						value="<%=consumidor.getDireccion()%>" required>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-warning">Actualizar</button>
					<a href="listarConsumidores.jsp" class="btn btn-danger">Cancelar</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
