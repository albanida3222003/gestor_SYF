<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.unu.beans.Empleados" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Empleado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-dark text-light">

    <%@ include file="/cabecera.jsp" %>

    <div class="container mt-4">
        <h2 class="text-center">Editar Empleado</h2>

        <%
        Empleados empleado = (Empleados) request.getAttribute("empleado");
        %>

        <div class="card bg-secondary p-4">
            <form action="EmpleadosController" method="POST">
                <input type="hidden" name="operacion" value="modificar">
                <input type="hidden" name="idEmpleados" value="<%= empleado.getIdEmpleados() %>">

                <div class="mb-3">
                    <label class="form-label">Nombre</label>
                    <input type="text" name="nombre" class="form-control" value="<%= empleado.getNombre() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Apellido</label>
                    <input type="text" name="apellido" class="form-control" value="<%= empleado.getApellido() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">DNI</label>
                    <input type="text" name="dni" class="form-control" value="<%= empleado.getDni() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Sexo</label>
                    <select name="sexo" class="form-select" required>
                        <option value="M" <%= empleado.getSexo().equals("M") ? "selected" : "" %>>Masculino</option>
                        <option value="F" <%= empleado.getSexo().equals("F") ? "selected" : "" %>>Femenino</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Correo</label>
                    <input type="email" name="correo" class="form-control" value="<%= empleado.getCorreo() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Teléfono</label>
                    <input type="text" name="telefono" class="form-control" value="<%= empleado.getTelefono() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Dirección</label>
                    <input type="text" name="direccion" class="form-control" value="<%= empleado.getDireccion() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Fecha de Nacimiento</label>
                    <input type="date" name="fechaNacimiento" class="form-control" value="<%= empleado.getFechaNacimiento() %>" required>
                </div>
				
                <div class="text-center">
                    <button type="submit" class="btn btn-warning">Actualizar</button>
                    <a href="listarEmpleados.jsp" class="btn btn-danger">Cancelar</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
