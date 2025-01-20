<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.unu.beans.Proveedores"%>
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
<body>
	<%@ include file="/cabecera.jsp"%>

	<div class="container mt-4">
		<h2 class="text-center">Editar Proveedor</h2>

		<%
		Proveedores provedor = (Proveedores) request.getAttribute("proveedor");
		%>

		<div class="card bg-secondary p-4">
			<form action="ProveedoresController" method="POST">
				<input type="hidden" name="operacion" value="editar"> <input
					type="hidden" name="idProveedor"
					value="<%=provedor.getIdproveedor()%>">

				<div class="mb-3">
					<label class="form-label">Id</label> <input type="text" name="id"
						class="form-control" value="<%=provedor.getIdproveedor()%>"
						required>
				</div>


				<div class="mb-3">
					<label class="form-label">Nombre</label> <input type="text"
						name="nombre" class="form-control"
						value="<%=provedor.getNombre()%>" required>
				</div>

				<div class="mb-3">
					<label class="form-label">Correo</label> <input type="email"
						name="correo" class="form-control"
						value="<%=provedor.getCorreo()%>" required>
				</div>

				<div class="mb-3">
					<label class="form-label">Teléfono</label> <input type="text"
						name="telefono" class="form-control"
						value="<%=provedor.getTelefono()%>" required>
				</div>

				<div class="mb-3">
					<label class="form-label">Dirección</label> <input type="text"
						name="direccion" class="form-control"
						value="<%=provedor.getDireccion()%>" required>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-warning">Actualizar</button>
					<a href="listarProveedores.jsp" class="btn btn-danger">Cancelar</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>