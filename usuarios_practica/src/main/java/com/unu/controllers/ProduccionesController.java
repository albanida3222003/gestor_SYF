package com.unu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.unu.beans.Consumidor;
import com.unu.beans.Producciones;
import com.unu.beans.Proveedores;
import com.unu.beans.Ventas;
import com.unu.model.ProduccionesModel;

public class ProduccionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProduccionesModel produccionesModel = new ProduccionesModel();

	public ProduccionesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String operacion = request.getParameter("operacion");

		try {
			if (operacion == null) {
				listar(request, response);
			} else {
				switch (operacion) {
				case "listar":
					listar(request, response);
					break;
				case "nuevo":
					request.getRequestDispatcher("/producciones/registrarProducciones.jsp").forward(request, response);
					break;
				case "insertar":
					insertar(request, response);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("processRequest() " + e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Producciones> pro = produccionesModel.listarProducciones();
			request.setAttribute("producciones", pro);
			request.getRequestDispatcher("/producciones/listarProducciones.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("listar() " + e.getMessage());
		}
	}
	
	protected void insertar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Producciones pro = new Producciones();
			java.sql.Date fechaNacimiento = java.sql.Date.valueOf(request.getParameter("fecha"));
			pro.setFechaProduccion(fechaNacimiento);
			pro.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
			pro.setIdDetalleSuministro(1);
			pro.setIdEmpleado(Integer.parseInt(request.getParameter("empleado")));
			pro.setIdProducto(Integer.parseInt(request.getParameter("producto")));
			boolean resultado = produccionesModel.crearProduccion(pro);
			response.sendRedirect("ProduccionesController?operacion=listar");
		} catch (Exception e) {
			System.out.println("insertar() " + e.getMessage());
		}
	}
}
