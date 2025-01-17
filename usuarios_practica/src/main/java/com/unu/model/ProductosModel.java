package com.unu.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unu.beans.Productos;

public class ProductosModel extends Conexion{
	private CallableStatement cs;
	private ResultSet rs;

	public List<Productos> listarProductos() {
		List<Productos> producto = null;
		try {
			String sql = "call sp_listar_producto();";
			producto = new ArrayList<Productos>();
			this.openConnection();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Productos pro = new Productos();
				pro.setIdproducto(rs.getInt("idproducto"));
				pro.setCapacidad_ml(rs.getInt("capacidad_ml"));
				pro.setColor(rs.getString("color"));
				pro.setMaterial(rs.getString("material"));
				
				producto.add(pro);
			}
			
			this.closeConnection();
		} catch (Exception e) {
			System.out.println("listarProductos() " + e.getMessage());
		}
		return producto;
	}
}
