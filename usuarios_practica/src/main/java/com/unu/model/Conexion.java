package com.unu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String url = "jdbc:mysql://localhost:3306/bd_syf_1_2";
	private String usuario = "root";
	private String contrasena = "root";
	protected Connection conexion;

	public void openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			if (conexion != null && !conexion.isClosed()) {
				conexion.close();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
