package com.unu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.unu.beans.Consumidor;
import com.unu.beans.Proveedores;
import com.unu.beans.Ventas;
import com.unu.model.ConsumidorModel;
import com.unu.model.ProductosModel;
import com.unu.model.VentasModel;

public class VentasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VentasModel ventasModel = new VentasModel();
	private ConsumidorModel consumidorModel = new ConsumidorModel();
	private ProductosModel productosModel = new ProductosModel();

	public VentasController() {
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
					request.getRequestDispatcher("/ventas/registrarVentas.jsp").forward(request, response);
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
		processRequest(request, response);
	}

	protected void insertar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Ventas ventas = new Ventas();
			ventas.setFecha(java.sql.Date.valueOf(request.getParameter("fecha")));
			ventas.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
			int aux = Integer.parseInt(request.getParameter("producto"));
			if (aux == 2) {
				ventas.setPrecio(new BigDecimal("0.30"));
			} else {
				ventas.setPrecio(new BigDecimal("0.25"));
			}

			ventas.setIdProducto(Integer.parseInt(request.getParameter("producto")));
			ventas.setIdConsumidor(Integer.parseInt(request.getParameter("consumidor")));
			ventas.setIdEmpleado(Integer.parseInt(request.getParameter("empleado")));
			System.out.println(ventas);
			boolean resultado = ventasModel.insertarVenta(ventas);
			response.sendRedirect("VentasController?operacion=listar");
		} catch (Exception e) {
			System.out.println("insertar() " + e.getMessage());
		}
	}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Consumidor> consumidores = consumidorModel.listarConsumidores();
			request.setAttribute("consumidores", consumidores);
			List<Ventas> ventas = ventasModel.listarVentas();
			request.setAttribute("ventas", ventas);
			request.getRequestDispatcher("/ventas/listarVentas.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("listar() " + e.getMessage());
		}
	}
}
