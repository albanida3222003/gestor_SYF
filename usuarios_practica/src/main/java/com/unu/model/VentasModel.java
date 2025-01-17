package com.unu.model;

import com.unu.beans.Ventas;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentasModel extends Conexion {
    private CallableStatement cs;
    private ResultSet rs;

    // Método para listar todas las ventas
    public List<Ventas> listarVentas() {
        List<Ventas> ventas = new ArrayList<>();
        try {
            String sql = "CALL sp_listar_ventas();";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                Ventas venta = new Ventas();
                venta.setIdventas(rs.getInt("idventas"));
                venta.setFecha(rs.getDate("fecha"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setPrecio(rs.getBigDecimal("precio"));
                venta.setTotalCoste(rs.getBigDecimal("total_coste"));
                venta.setIdProducto(rs.getInt("id_producto"));
                venta.setIdConsumidor(rs.getInt("id_consumidor"));
                venta.setIdEmpleado(rs.getInt("id_empleado"));

                ventas.add(venta);
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("listarVentas() " + e.getMessage());
        }
        return ventas;
    }

    // Método para insertar una venta
    public boolean insertarVenta(Ventas venta) {
        boolean resultado = false;
        try {
            String sql = "CALL sp_insertar_venta(?, ?, ?, ?, ?, ?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setDate(1, venta.getFecha());
            cs.setInt(2, venta.getCantidad());
            cs.setBigDecimal(3, venta.getPrecio());
            cs.setInt(4, venta.getIdProducto());
            cs.setInt(5, venta.getIdConsumidor());
            cs.setInt(6, venta.getIdEmpleado());

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("insertarVenta() " + e.getMessage());
        }
        return resultado;
    }

    // Método para actualizar una venta
    public boolean actualizarVenta(Ventas venta) {
        boolean resultado = false;
        try {
            String sql = "CALL sp_actualizar_venta(?, ?, ?, ?, ?, ?, ?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, venta.getIdventas());
            cs.setDate(2, venta.getFecha());
            cs.setInt(3, venta.getCantidad());
            cs.setBigDecimal(4, venta.getPrecio());
            cs.setInt(5, venta.getIdProducto());
            cs.setInt(6, venta.getIdConsumidor());
            cs.setInt(7, venta.getIdEmpleado());

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("actualizarVenta() " + e.getMessage());
        }
        return resultado;
    }

    // Método para eliminar una venta
    public boolean eliminarVenta(int idventas) {
        boolean resultado = false;
        try {
            String sql = "CALL sp_eliminar_venta(?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, idventas);

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("eliminarVenta() " + e.getMessage());
        }
        return resultado;
    }
}
