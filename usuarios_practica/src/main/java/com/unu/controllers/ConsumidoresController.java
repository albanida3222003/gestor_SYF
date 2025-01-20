package com.unu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.unu.beans.Contratos;
import com.unu.beans.Proveedores;
import com.unu.beans.Consumidor;
import com.unu.model.ConsumidorModel;
import com.unu.model.EmpleadosModel;

public class ConsumidoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConsumidorModel consumidorModel = new ConsumidorModel();

	public ConsumidoresController() {
		super();
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
					request.getRequestDispatcher("/consumidores/registrarConsumidores.jsp").forward(request, response);
					break;
				case "insertar":
					insertar(request, response);
					break;
				case "editar":
					actualizar(request, response);
					break;
				case "obtener":
					obtener(request, response);
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
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Consumidor> consumidor = consumidorModel.listarConsumidores();
			request.setAttribute("consumidores", consumidor);
			request.getRequestDispatcher("/consumidores/listarConsumidores.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("listar() " + e.getMessage());
		}
	}

	protected void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        Consumidor consumidor = new Consumidor();
	        consumidor.setNombre(request.getParameter("nombre"));
	        consumidor.setTelefono(request.getParameter("telefono"));
	        consumidor.setCorreo(request.getParameter("correo"));
	        consumidor.setDireccion(request.getParameter("direccion"));

	        boolean resultado = consumidorModel.insertarConsumidor(consumidor);
	        if (resultado) {
	            response.sendRedirect("ConsumidoresController?operacion=listar");
	        } else {
	            request.setAttribute("mensaje", "Error al insertar consumidor");
	            request.getRequestDispatcher("/consumidores/registrarConsumidores.jsp").forward(request, response);
	        }
	    } catch (Exception e) {
	        System.out.println("insertar() " + e.getMessage());
	    }
	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        Consumidor consumidor = new Consumidor();
	        consumidor.setIdconsumidor(Integer.parseInt(request.getParameter("id")));
	        consumidor.setNombre(request.getParameter("nombre"));
	        consumidor.setTelefono(request.getParameter("telefono"));
	        consumidor.setCorreo(request.getParameter("correo"));
	        consumidor.setDireccion(request.getParameter("direccion"));

	        boolean resultado = consumidorModel.actualizarConsumidor(consumidor);
	        if (resultado) {
	            response.sendRedirect("ConsumidoresController?operacion=listar");
	        } else {
	            request.setAttribute("mensaje", "Error al actualizar consumidor");
	            request.getRequestDispatcher("/consumidores/editarConsumidores.jsp").forward(request, response);
	        }
	    } catch (Exception e) {
	        System.out.println("actualizar() " + e.getMessage());
	    }
	}

	protected void obtener(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        int idConsumidor = Integer.parseInt(request.getParameter("idConsumidor"));
	        Consumidor consumidor = consumidorModel.obtener(idConsumidor);
	        
	        if (consumidor != null) {
	            request.setAttribute("consumidor", consumidor);
	            request.getRequestDispatcher("/consumidores/editarConsumidores.jsp").forward(request, response);
	            
	        } else {
	            response.sendRedirect("ConsumidoresController?operacion=listar");
	        }
	    } catch (Exception e) {
	        System.out.println("obtener() " + e.getMessage());
	    }
	}

}
