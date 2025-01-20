<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Proveedor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<%@ include file="/cabecera.jsp" %>
	    <div class="container mt-4">
        <h2 class="text-center">Registrar Nuevo Proveedor</h2>

        <div class="card bg-secondary p-4">
            <form action="ProveedoresController?operacion=insertar" method="POST">
                <!-- Campos de proveedor -->
                <div class="mb-3">
                    <label class="form-label">Nombre</label>
                    <input type="text" name="nombre" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Correo</label>
                    <input type="text" name="correo" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Telefono</label>
                    <input type="text" name="telefono" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Dirección</label>
                    <input type="text" name="direccion" class="form-control" required>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success">Registrar Proovedor</button>
                </div>
            </form>
        </div>
    </div>
	
</body>
</html>