<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Empleado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-dark text-light">

    <%@ include file="/cabecera.jsp" %>

    <div class="container mt-4">
        <h2 class="text-center">Registrar Nuevo Empleado</h2>

        <div class="card bg-secondary p-4">
            <form action="EmpleadosController?operacion=registrar" method="POST">
                <!-- Campos de empleado -->
                <div class="mb-3">
                    <label class="form-label">Nombre</label>
                    <input type="text" name="nombre" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Apellido</label>
                    <input type="text" name="apellido" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">DNI</label>
                    <input type="text" name="dni" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Sexo</label>
                    <select name="sexo" class="form-select" required>
                        <option value="M">Masculino</option>
                        <option value="F">Femenino</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Correo</label>
                    <input type="email" name="correo" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Teléfono</label>
                    <input type="text" name="telefono" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Dirección</label>
                    <input type="text" name="direccion" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Fecha de Nacimiento</label>
                    <input type="date" name="fechaNacimiento" class="form-control" required>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success">Registrar Empleado</button>
                </div>
            </form>
        </div>
    </div>

</body>
</html>