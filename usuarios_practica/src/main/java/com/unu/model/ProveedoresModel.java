package com.unu.model;

import com.unu.beans.Proveedores;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresModel extends Conexion {
	private CallableStatement cs;
	private ResultSet rs;

	// Método para listar todos los proveedores
	public List<Proveedores> listarProveedores() {
		List<Proveedores> proveedores = new ArrayList<>();
		try {
			String sql = "CALL sp_listar_proveedores();";
			this.openConnection();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();

			while (rs.next()) {
				Proveedores proveedor = new Proveedores();
				proveedor.setIdproveedor(rs.getInt("idproveedor"));
				proveedor.setNombre(rs.getString("nombre"));
				proveedor.setCorreo(rs.getString("correo"));
				proveedor.setTelefono(rs.getString("telefono"));
				proveedor.setDireccion(rs.getString("direccion"));

				proveedores.add(proveedor);
			}
			this.closeConnection();
		} catch (Exception e) {
			System.out.println("listarProveedores() " + e.getMessage());
		}
		return proveedores;
	}

	// Método para insertar un proveedor
	public boolean insertarProveedor(Proveedores proveedor) {
		boolean resultado = false;
		try {
			String sql = "CALL sp_insertar_proveedor(?, ?, ?, ?);";
			this.openConnection();
			cs = conexion.prepareCall(sql);
			cs.setString(1, proveedor.getNombre());
			cs.setString(2, proveedor.getCorreo());
			cs.setString(3, proveedor.getTelefono());
			cs.setString(4, proveedor.getDireccion());

			int filasAfectadas = cs.executeUpdate();
			if (filasAfectadas > 0) {
				resultado = true;
			}
			this.closeConnection();
		} catch (Exception e) {
			System.out.println("insertarProveedor() " + e.getMessage());
		}
		return resultado;
	}

	// Método para actualizar un proveedor
	public boolean actualizarProveedor(Proveedores proveedor) {
		boolean resultado = false;
		try {
			String sql = "CALL sp_actualizar_proveedor(?, ?, ?, ?, ?);";
			this.openConnection();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, proveedor.getIdproveedor());
			cs.setString(2, proveedor.getNombre());
			cs.setString(3, proveedor.getCorreo());
			cs.setString(4, proveedor.getTelefono());
			cs.setString(5, proveedor.getDireccion());

			int filasAfectadas = cs.executeUpdate();
			if (filasAfectadas > 0) {
				resultado = true;
			}
			this.closeConnection();
		} catch (Exception e) {
			System.out.println("actualizarProveedor() " + e.getMessage());
		}
		return resultado;
	}

	public Proveedores obtenerProveedor(int idproveedor) {
		Proveedores proveedor = null;
		try {
			String sql = "CALL sp_obtener_proveedor(?);";
			this.openConnection();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idproveedor);
			rs = cs.executeQuery();

			if (rs.next()) {
				proveedor = new Proveedores();
				proveedor.setIdproveedor(rs.getInt("idproveedor"));
				proveedor.setNombre(rs.getString("nombre"));
				proveedor.setCorreo(rs.getString("correo"));
				proveedor.setTelefono(rs.getString("telefono"));
				proveedor.setDireccion(rs.getString("direccion"));
			}
			this.closeConnection();
		} catch (Exception e) {
			System.out.println("obtenerProveedor() " + e.getMessage());
		}
		return proveedor;
	}

	// Método para eliminar un proveedor
	public boolean eliminarProveedor(int idproveedor) {
		boolean resultado = false;
		try {
			String sql = "CALL sp_eliminar_proveedor(?);";
			this.openConnection();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idproveedor);

			int filasAfectadas = cs.executeUpdate();
			if (filasAfectadas > 0) {
				resultado = true;
			}
			this.closeConnection();
		} catch (Exception e) {
			System.out.println("eliminarProveedor() " + e.getMessage());
		}
		return resultado;
	}
}
