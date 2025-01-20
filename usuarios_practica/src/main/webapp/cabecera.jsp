<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>

<title>Cabezera menu</title>
</head>
<body data-bs-theme="dark">
	<%
	String url = "http://localhost:8088/empresa_syf/";
	%>
	
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand">SYF</a>
			
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="http://localhost:8088/empresa_syf/VentasController">Ventas</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8088/empresa_syf/ConsumidoresController">Clientes</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8088/empresa_syf/EmpleadosController">Personal</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8088/empresa_syf/">Horarios</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8088/empresa_syf/ProveedoresController">Proveedores</a></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success">Search</button>
				</form>
			</div>
		</div>
	</nav>
</div>
</body>
</html>