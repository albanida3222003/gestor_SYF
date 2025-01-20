<%@ page import="java.util.List" %>
<%@ page import="com.unu.beans.Proveedores" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Proveedores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-dark text-light">

    <%@ include file="/cabecera.jsp" %>

    <div class="container mt-4">
        <h2 class="text-center">Lista de Proveedores</h2>

        <div class="d-flex justify-content-end mb-3">
            <a href="ProveedoresController?operacion=nuevo" class="btn btn-success">Registrar Nuevo Proveedor</a>
        </div>

        <table class="table table-dark table-striped text-center">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Teléfono</th>
                    <th>Dirección</th>
                    <th>Operaciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Proveedores> proveedores = (List<Proveedores>) request.getAttribute("proveedores");
                if (proveedores != null) {
                    for (Proveedores proveedor : proveedores) {
                %>
                <tr>
                    <td><%= proveedor.getNombre() %></td>
                    <td><%= proveedor.getCorreo() %></td>
                    <td><%= proveedor.getTelefono() %></td>
                    <td><%= proveedor.getDireccion() %></td>
                    <td>
                        <a href="ProveedoresController?operacion=obtener&idProveedor=<%= proveedor.getIdproveedor() %>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="ProveedoresController?operacion=eliminar&idProveedor=<%= proveedor.getIdproveedor() %>" class="btn btn-danger btn-sm">Eliminar</a>
                    </td>
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
