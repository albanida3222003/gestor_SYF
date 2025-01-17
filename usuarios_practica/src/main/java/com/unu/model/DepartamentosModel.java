package com.unu.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unu.beans.Departamentos;

public class DepartamentosModel extends Conexion {
    private CallableStatement cs;
    private ResultSet rs;

    public List<Departamentos> listarDepartamentos() {
        List<Departamentos> departamentos = null;
        try {
            String sql = "call sp_listar_departamentos();";
            departamentos = new ArrayList<Departamentos>();
            this.openConnection();
            cs = conexion.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                Departamentos dep = new Departamentos();
                dep.setIddepartamento(rs.getInt("iddepartamento"));
                dep.setNombre(rs.getString("nombre"));
                dep.setSalario(rs.getBigDecimal("salario"));
                dep.setHorasSemanales(rs.getByte("horas_semanales"));
                
                departamentos.add(dep);
            }
            
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("listarDepartamentos() " + e.getMessage());
        }
        return departamentos;
    }

    public boolean editarDepartamento(Departamentos departamento) {
        boolean resultado = false;
        try {
            String sql = "call sp_editar_departamento(?, ?, ?, ?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, departamento.getIddepartamento());
            cs.setString(2, departamento.getNombre());
            cs.setBigDecimal(3, departamento.getSalario());
            cs.setByte(4, departamento.getHorasSemanales());
            
            resultado = cs.executeUpdate() == 1;
            
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("editarDepartamento() " + e.getMessage());
        }
        return resultado;
    }

    public boolean eliminarDepartamento(int iddepartamento) {
        boolean resultado = false;
        try {
            String sql = "call sp_eliminar_departamento(?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, iddepartamento);
            
            resultado = cs.executeUpdate() == 1;
            
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("eliminarDepartamento() " + e.getMessage());
        }
        return resultado;
    }

    public boolean registrarDepartamento(Departamentos departamento) {
        boolean resultado = false;
        try {
            String sql = "call sp_registrar_departamento(?, ?, ?);";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setString(1, departamento.getNombre());
            cs.setBigDecimal(2, departamento.getSalario());
            cs.setByte(3, departamento.getHorasSemanales());
            
            resultado = cs.executeUpdate() == 1;
            
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("registrarDepartamento() " + e.getMessage());
        }
        return resultado;
    }
}