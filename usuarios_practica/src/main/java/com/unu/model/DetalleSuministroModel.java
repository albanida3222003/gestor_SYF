package com.unu.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.unu.beans.DetalleSuministro;

public class DetalleSuministroModel extends Conexion {

    private CallableStatement cs;
    private ResultSet rs;

    // Listar todos los detalles de suministro
    public List<DetalleSuministro> listarDetalleSuministro() {
        List<DetalleSuministro> lista = new ArrayList<>();
        try {
            String sql = "call sp_listar_detalles_suministro();";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                DetalleSuministro ds = new DetalleSuministro();
                ds.setIddetalleSuministro(rs.getInt("iddetalle_suministro"));
                ds.setTipoProducto(rs.getString("tipo_producto"));
                ds.setCantidad(rs.getInt("cantidad"));
                ds.setPrecio(rs.getDouble("precio"));
                ds.setTotalCoste(rs.getDouble("total_coste"));
                ds.setStock(rs.getInt("stock"));
                ds.setIdProveedor(rs.getInt("id_proveedor"));
                lista.add(ds);
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("listarDetalleSuministro() " + e.getMessage());
        }
        return lista;
    }

    // Crear un detalle de suministro
    public boolean crearDetalleSuministro(DetalleSuministro ds) {
        try {
            String sql = "call sp_crear_detalle_suministro(?, ?, ?, ?, ?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setString(1, ds.getTipoProducto());
            cs.setInt(2, ds.getCantidad());
            cs.setDouble(3, ds.getPrecio());
            cs.setInt(4, ds.getStock());
            cs.setInt(5, ds.getIdProveedor());
            cs.execute();
            this.closeConnection();
            return true;
        } catch (Exception e) {
            System.out.println("crearDetalleSuministro() " + e.getMessage());
            return false;
        }
    }

    // Actualizar un detalle de suministro
    public boolean actualizarDetalleSuministro(DetalleSuministro ds) {
        try {
            String sql = "call sp_actualizar_detalle_suministro(?, ?, ?, ?, ?, ?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, ds.getIddetalleSuministro());
            cs.setString(2, ds.getTipoProducto());
            cs.setInt(3, ds.getCantidad());
            cs.setDouble(4, ds.getPrecio());
            cs.setInt(5, ds.getStock());
            cs.setInt(6, ds.getIdProveedor());
            cs.execute();
            this.closeConnection();
            return true;
        } catch (Exception e) {
            System.out.println("actualizarDetalleSuministro() " + e.getMessage());
            return false;
        }
    }

    // Eliminar un detalle de suministro
    public boolean eliminarDetalleSuministro(int iddetalleSuministro) {
        try {
            String sql = "call sp_eliminar_detalle_suministro(?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, iddetalleSuministro);
            cs.execute();
            this.closeConnection();
            return true;
        } catch (Exception e) {
            System.out.println("eliminarDetalleSuministro() " + e.getMessage());
            return false;
        }
    }
}
