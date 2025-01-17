package com.unu.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unu.beans.Horarios;

public class HorariosModel extends Conexion {
    private CallableStatement cs;
    private ResultSet rs;

    // Método para listar todos los horarios
    public List<Horarios> listarHorarios() {
        List<Horarios> horarios = new ArrayList<>();
        try {
            String sql = "call sp_listar_horarios();"; // Llamada a procedimiento almacenado
            this.openConnection();
            cs = conexion.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                Horarios horario = new Horarios();
                horario.setIdhorario(rs.getInt("idhorario"));
                horario.setHoraInicio(rs.getString("hora_inicio"));
                horario.setHoraFin(rs.getString("hora_fin"));
                horario.setDia(rs.getString("dia"));
                horario.setIdContrato(rs.getInt("id_contrato"));
                horarios.add(horario);
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al listar horarios: " + e.getMessage());
        }
        return horarios;
    }

    // Método para insertar un nuevo horario
    public boolean insertarHorario(Horarios horario) {
        boolean insertado = false;
        try {
            String sql = "{call sp_insertar_horario(?, ?, ?, ?)}"; // Llamada a procedimiento almacenado
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setString(1, horario.getHoraInicio());
            cs.setString(2, horario.getHoraFin());
            cs.setString(3, horario.getDia());
            cs.setInt(4, horario.getIdContrato());

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                insertado = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al insertar horario: " + e.getMessage());
        }
        return insertado;
    }

    // Método para actualizar un horario
    public boolean actualizarHorario(Horarios horario) {
        boolean actualizado = false;
        try {
            String sql = "{call sp_actualizar_horario(?, ?, ?, ?, ?)}"; // Llamada a procedimiento almacenado
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, horario.getIdhorario());
            cs.setString(2, horario.getHoraInicio());
            cs.setString(3, horario.getHoraFin());
            cs.setString(4, horario.getDia());
            cs.setInt(5, horario.getIdContrato());

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                actualizado = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al actualizar horario: " + e.getMessage());
        }
        return actualizado;
    }

    // Método para eliminar un horario
    public boolean eliminarHorario(int idhorario) {
        boolean eliminado = false;
        try {
            String sql = "{call sp_eliminar_horario(?)}"; // Llamada a procedimiento almacenado
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, idhorario);

            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                eliminado = true;
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al eliminar horario: " + e.getMessage());
        }
        return eliminado;
    }
}
