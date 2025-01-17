package com.unu.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unu.beans.Empleados;

public class EmpleadosModel extends Conexion {
    private CallableStatement cs;
    private ResultSet rs;

    public List<Empleados> listarEmpleados() {
        List<Empleados> empleados = new ArrayList<>();
        try {
            String sql = "call sp_listar_empleados();";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                Empleados emp = new Empleados();
                emp.setIdEmpleados(rs.getInt("idempleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setDni(rs.getString("dni"));
                emp.setSexo(rs.getString("sexo"));
                emp.setCorreo(rs.getString("correo"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                
                empleados.add(emp);
            }
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("listarEmpleados() " + e.getMessage());
        }
        return empleados;
    }
    
    public boolean registrarEmpleados(Empleados emp) {
        try {
            String sql = "call sp_registrar_empleados(?, ?, ?, ?, ?, ?, ?, ?)";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setString(1, emp.getNombre());
            cs.setString(2, emp.getApellido());
            cs.setString(3, emp.getDni());
            if (emp.getSexo().equals("M")) {
            	cs.setString(4, "Masculino");
			}
            if (emp.getSexo().equals("F")) {
            	cs.setString(4, "Femenino");
			}
            cs.setString(5, emp.getCorreo());
            cs.setString(6, emp.getTelefono());
            cs.setString(7, emp.getDireccion());
            cs.setDate(8, new java.sql.Date(emp.getFechaNacimiento().getTime()));
            
            cs.execute();
            this.closeConnection();
            return true;
        } catch (Exception e) {
            System.out.println("registrarEmpleados() " + e.getMessage());
            return false;
        }
    }
    
    public Empleados obtenerEmpleado(int idEmpleado) {
        Empleados emp = null;
        try {
            String sql = "call sp_obtener_empleado(?)";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, idEmpleado);
            rs = cs.executeQuery();
            
            if (rs.next()) {
                emp = new Empleados();
                emp.setIdEmpleados(rs.getInt("idempleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setDni(rs.getString("dni"));
                emp.setSexo(rs.getString("sexo"));
                emp.setCorreo(rs.getString("correo"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
            }
            
            this.closeConnection();
        } catch (Exception e) {
            System.out.println("obtenerEmpleado() " + e.getMessage());
        }
        return emp;
    }

    
    public boolean editarEmpleados(Empleados emp) {
        try {
            String sql = "call sp_editar_empleados(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, emp.getIdEmpleados());
            cs.setString(2, emp.getNombre());
            cs.setString(3, emp.getApellido());
            cs.setString(4, emp.getDni());
            if (emp.getSexo().equals("M")) {
            	cs.setString(5, "Masculino");
			}
            if (emp.getSexo().equals("F")) {
            	cs.setString(5, "Femenino");
			}
            cs.setString(6, emp.getCorreo());
            cs.setString(7, emp.getTelefono());
            cs.setString(8, emp.getDireccion());
            cs.setDate(9, new java.sql.Date(emp.getFechaNacimiento().getTime()));
            
            cs.executeUpdate();
            this.closeConnection();
            return true;
        } catch (Exception e) {
            System.out.println("editarEmpleados() " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarEmpleados(int idEmpleados) {
        try {
            String sql = "call sp_eliminar_empleados(?)";
            this.openConnection();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, idEmpleados);
            
            cs.execute();
            this.closeConnection();
            return true;
        } catch (Exception e) {
            System.out.println("eliminarEmpleados() " + e.getMessage());
            return false;
        }
    }
}
