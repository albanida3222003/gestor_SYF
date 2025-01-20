package com.unu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.unu.beans.Consumidor;
import com.unu.beans.Proveedores;
import com.unu.model.ConsumidorModel;
import com.unu.model.ProveedoresModel;

public class ProveedoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProveedoresModel proveedoresModel = new ProveedoresModel();

	public ProveedoresController() {
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
					request.getRequestDispatcher("/proveedores/registrarProveedores.jsp").forward(request, response);
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
		processRequest(request, response);
	}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Proveedores> proveedores = proveedoresModel.listarProveedores();
			request.setAttribute("proveedores", proveedores);
			request.getRequestDispatcher("/proveedores/listarProveedores.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("listar() " + e.getMessage());
		}
	}

	protected void insertar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Proveedores proveedor = new Proveedores();
			proveedor.setNombre(request.getParameter("nombre"));
			proveedor.setCorreo(request.getParameter("correo"));
			proveedor.setTelefono(request.getParameter("telefono"));
			proveedor.setDireccion(request.getParameter("direccion"));

			boolean resultado = proveedoresModel.insertarProveedor(proveedor);
			response.sendRedirect("ProveedoresController?operacion=listar");
		} catch (Exception e) {
			System.out.println("insertar() " + e.getMessage());
		}
	}

	protected void obtener(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int idproveedor = Integer.parseInt(request.getParameter("idProveedor"));
			Proveedores proveedor = proveedoresModel.obtenerProveedor(idproveedor);
			request.setAttribute("proveedor", proveedor);
			request.getRequestDispatcher("/proveedores/editarProveedores.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("obtener() " + e.getMessage());
		}
	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Proveedores proveedor = new Proveedores();
			proveedor.setIdproveedor(Integer.parseInt(request.getParameter("id")));
			proveedor.setNombre(request.getParameter("nombre"));
			proveedor.setCorreo(request.getParameter("correo"));
			proveedor.setTelefono(request.getParameter("telefono"));
			proveedor.setDireccion(request.getParameter("direccion"));

			boolean resultado = proveedoresModel.actualizarProveedor(proveedor);
			response.sendRedirect("ProveedoresController?operacion=listar");
		} catch (Exception e) {
			System.out.println("actualizar() " + e.getMessage());
		}
	}
}
