package com.unu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.unu.beans.Consumidor;
import com.unu.beans.Ventas;
import com.unu.model.ConsumidorModel;
import com.unu.model.VentasModel;

public class VentasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VentasModel ventasModel = new VentasModel();
	private ConsumidorModel consumidorModel = new ConsumidorModel();
	
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
