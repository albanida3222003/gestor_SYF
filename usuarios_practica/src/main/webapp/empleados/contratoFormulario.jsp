<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Contrato</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-dark text-light">

    <%@ include file="/cabecera.jsp" %>

    <div class="container mt-4">
        <h2 class="text-center">Registrar Contrato</h2>

        <div class="card bg-secondary p-4">
            <form action="EmpleadosController?operacion=registrarContrato" method="POST">
                <input type="hidden" name="idEmpleado" value="${requestScope.idEmpleado}">

                <!-- Campos del contrato -->
                <div class="mb-3">
                    <label class="form-label">Fecha de Comienzo del Contrato</label>
                    <input type="date" name="fechaComienzo" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Fecha de Fin del Contrato</label>
                    <input type="date" name="fechaFin" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Departamento</label>
                    <select name="departamento" class="form-select" required>
                        <option value="1">Administrador</option>
                        <option value="2">Embotellador</option>
                        <option value="3">Empaquetador</option>
                    </select>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success">Registrar Contrato</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
