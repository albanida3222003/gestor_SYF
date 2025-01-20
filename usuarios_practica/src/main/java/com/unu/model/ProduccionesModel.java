package com.unu.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unu.beans.Producciones;

public class ProduccionesModel extends Conexion {
    private CallableStatement cs;
    private ResultSet rs;

    // Listar todas las producciones
    public List<Producciones> listarProducciones() {
        List<Producciones> listaProducciones = new ArrayList<>();
        try {
            String sql = "call sp_listar_producciones();"; // Llamada a procedimiento almacenado
            this.openConnection();
            cs = conexion.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                Producciones produccion = new Producciones();
                produccion.setIdproduccion(rs.getInt("idproduccion"));
                produccion.setFechaProduccion(rs.getDate("fecha_produccion"));
                produccion.setCantidad(rs.getInt("cantidad"));
                produccion.setIdEmpleado(rs.getInt("id_empleado"));
                produccion.setIdProducto(rs.getInt("id_producto"));
                produccion.setIdDetalleSuministro(rs.getInt("id_detalle_suministro"));
                listaProducciones.add(produccion);
            }

            this.closeConnection();
        } catch (Exception e) {
            System.out.println("listarProducciones() " + e.getMessage());
        }
        return listaProducciones;
    }

    // Crear una nueva producción
    public boolean crearProduccion(Producciones produccion) {
        boolean exito = false;
        try {
            String sql = "call sp_crear_produccion( ?, ?, ?, ?, ?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setDate(1, new java.sql.Date(produccion.getFechaProduccion().getTime()));
            cs.setInt(2, produccion.getCantidad());
            cs.setInt(3, produccion.getIdEmpleado());
            cs.setInt(4, produccion.getIdProducto());
            cs.setInt(5, produccion.getIdDetalleSuministro());
            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                exito = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("crearProduccion() " + e.getMessage());
        }
        return exito;
    }

    // Actualizar una producción existente
    public boolean actualizarProduccion(Producciones produccion) {
        boolean exito = false;
        try {
            String sql = "call sp_actualizar_produccion(?, ?, ?, ?, ?, ?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, produccion.getIdproduccion());
            cs.setDate(2, new java.sql.Date(produccion.getFechaProduccion().getTime()));
            cs.setInt(3, produccion.getCantidad());
            cs.setInt(4, produccion.getIdEmpleado());
            cs.setInt(5, produccion.getIdProducto());
            cs.setInt(6, produccion.getIdDetalleSuministro());
            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                exito = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("actualizarProduccion() " + e.getMessage());
        }
        return exito;
    }

    // Eliminar una producción
    public boolean eliminarProduccion(int idproduccion) {
        boolean exito = false;
        try {
            String sql = "call sp_eliminar_produccion(?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, idproduccion);
            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                exito = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("eliminarProduccion() " + e.getMessage());
        }
        return exito;
    }
}
