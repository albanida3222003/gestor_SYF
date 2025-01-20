package com.unu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.unu.beans.Contratos;
import com.unu.beans.Proveedores;
import com.unu.model.ContratosModel;

public class ContratosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContratosModel contratosModel = new ContratosModel();
	
    public ContratosController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String operacion = request.getParameter("operacion");

		try {
			if (operacion == null) {
				//listar(request, response);
			} else {
				switch (operacion) {
				case "listar":
					//listar(request, response);
					break;
				case "nuevo":
					request.getRequestDispatcher("/contratos/registrarContratos.jsp").forward(request, response);
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
    
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Contratos con = new Contratos();
			con.setFechaComienzo(java.sql.Date.valueOf(request.getParameter("fechaComienzo")));
			con.setFechaFin(java.sql.Date.valueOf(request.getParameter("fechaFin")));
			con.setIdDepartamento(Integer.parseInt(request.getParameter("departamento")));
			con.setVigencia(request.getParameter("vigencia"));
			con.setIdEmpleado(Integer.parseInt(request.getParameter("empleado")));
			
			boolean resultado = contratosModel.insertarContrato(con);
			response.sendRedirect("EmpleadosController?operacion=listar");
		} catch (Exception e) {
			System.out.println("insertar() " + e.getMessage());
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
