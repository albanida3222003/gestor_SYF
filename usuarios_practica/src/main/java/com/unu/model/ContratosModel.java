package com.unu.model;

import com.unu.beans.Contratos;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContratosModel extends Conexion {
    private CallableStatement cs;
    private ResultSet rs;

    // Método para listar todos los contratos
    public List<Contratos> listarContratos() {
        List<Contratos> contratos = new ArrayList<>();
        try {
            String sql = "CALL sp_listar_contratos();";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                Contratos contrato = new Contratos();
                contrato.setIdcontrato(rs.getInt("idcontrato"));
                contrato.setFechaComienzo(rs.getDate("fecha_comienzo"));
                contrato.setFechaFin(rs.getDate("fecha_fin"));
                contrato.setVigencia(rs.getString("vigencia"));
                contrato.setIdEmpleado(rs.getInt("id_empleado"));
                contrato.setIdDepartamento(rs.getInt("id_departamento"));

                contratos.add(contrato);
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("listarContratos() " + e.getMessage());
        }
        return contratos;
    }

    // Método para insertar un contrato
    public boolean insertarContrato(Contratos contrato) {
        boolean resultado = false;
        try {
            String sql = "CALL sp_insertar_contrato(?, ?, ?, ?, ?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setDate(1, contrato.getFechaComienzo());
            cs.setDate(2, contrato.getFechaFin());
            cs.setString(3, contrato.getVigencia());
            cs.setInt(4, contrato.getIdEmpleado());
            cs.setInt(5, contrato.getIdDepartamento());

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("insertarContrato() " + e.getMessage());
        }
        return resultado;
    }

    // Método para actualizar un contrato
    public boolean actualizarContrato(Contratos contrato) {
        boolean resultado = false;
        try {
            String sql = "CALL sp_actualizar_contrato(?, ?, ?, ?, ?, ?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, contrato.getIdcontrato());
            cs.setDate(2, contrato.getFechaComienzo());
            cs.setDate(3, contrato.getFechaFin());
            cs.setString(4, contrato.getVigencia());
            cs.setInt(5, contrato.getIdEmpleado());
            cs.setInt(6, contrato.getIdDepartamento());

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("actualizarContrato() " + e.getMessage());
        }
        return resultado;
    }

    // Método para eliminar un contrato
    public boolean eliminarContrato(int idcontrato) {
        boolean resultado = false;
        try {
            String sql = "CALL sp_eliminar_contrato(?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, idcontrato);

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("eliminarContrato() " + e.getMessage());
        }
        return resultado;
    }
}
