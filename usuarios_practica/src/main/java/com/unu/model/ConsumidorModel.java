package com.unu.model;

import com.unu.beans.Consumidor;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConsumidorModel extends Conexion {
    private CallableStatement cs;
    private ResultSet rs;

    // Método para listar todos los consumidores
    public List<Consumidor> listarConsumidores() {
        List<Consumidor> consumidores = new ArrayList<>();
        try {
            String sql = "CALL sp_listar_consumidores();";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                Consumidor consumidor = new Consumidor();
                consumidor.setIdconsumidor(rs.getInt("idconsumidor"));
                consumidor.setNombre(rs.getString("nombre"));
                consumidor.setTelefono(rs.getString("telefono"));
                consumidor.setCorreo(rs.getString("correo"));
                consumidor.setDireccion(rs.getString("direccion"));

                consumidores.add(consumidor);
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("listarConsumidores() " + e.getMessage());
        }
        return consumidores;
    }

    // Método para insertar un consumidor
    public boolean insertarConsumidor(Consumidor consumidor) {
        boolean resultado = false;
        try {
            String sql = "CALL sp_insertar_consumidor(?, ?, ?, ?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setString(1, consumidor.getNombre());
            cs.setString(2, consumidor.getTelefono());
            cs.setString(3, consumidor.getCorreo());
            cs.setString(4, consumidor.getDireccion());

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("insertarConsumidor() " + e.getMessage());
        }
        return resultado;
    }

    // Método para actualizar un consumidor
    public boolean actualizarConsumidor(Consumidor consumidor) {
        boolean resultado = false;
        try {
            String sql = "CALL sp_actualizar_consumidor(?, ?, ?, ?, ?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, consumidor.getIdconsumidor());
            cs.setString(2, consumidor.getNombre());
            cs.setString(3, consumidor.getTelefono());
            cs.setString(4, consumidor.getCorreo());
            cs.setString(5, consumidor.getDireccion());

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("actualizarConsumidor() " + e.getMessage());
        }
        return resultado;
    }

    // Método para eliminar un consumidor
    public boolean eliminarConsumidor(int idconsumidor) {
        boolean resultado = false;
        try {
            String sql = "CALL sp_eliminar_consumidor(?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, idconsumidor);

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("eliminarConsumidor() " + e.getMessage());
        }
        return resultado;
    }
}
