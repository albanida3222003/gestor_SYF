package com.unu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.unu.beans.Contratos;
import com.unu.beans.Empleados;
import com.unu.model.ContratosModel;
import com.unu.model.EmpleadosModel;

@WebServlet("/EmpleadosController")
public class EmpleadosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpleadosModel empleadosModel = new EmpleadosModel();
	private ContratosModel contratosModel = new ContratosModel();

	public EmpleadosController() {
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
				case "registrarEmpleado":
					registrarEmpleado(request, response);
					break;
				case "registrarContrato":
					registrarContrato(request, response);
					break;
				case "editar":
					obtener(request, response);
					break;
				case "modificar":
					editar(request, response);
					break;
				case "eliminar":
					eliminar(request, response);
					break;
				case "nuevo":
					request.getRequestDispatcher("/empleados/empleadosFormulario.jsp").forward(request, response);
					break;
				default:
					listar(request, response);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("processRequest() " + e.getMessage());
		}
	}

	// Método para listar empleados
	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Empleados> empleados = empleadosModel.listarEmpleados();
			request.setAttribute("empleados", empleados);
			List<Contratos> contratos = contratosModel.listarContratos();
			request.setAttribute("contratos", contratos);
			request.getRequestDispatcher("/empleados/listarEmpleados.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("listar() " + e.getMessage());
		}
	}

	// Método para registrar un empleado
	protected void registrarEmpleado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Datos del empleado
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String dni = request.getParameter("dni");
			String sexo = request.getParameter("sexo");
			String correo = request.getParameter("correo");
			String telefono = request.getParameter("telefono");
			String direccion = request.getParameter("direccion");
			java.sql.Date fechaNacimiento = java.sql.Date.valueOf(request.getParameter("fechaNacimiento"));

			// Crear objeto empleado
			Empleados emp = new Empleados(0, nombre, apellido, dni, sexo, correo, telefono, direccion, fechaNacimiento);

			// Registrar empleado
			boolean registradoEmpleado = empleadosModel.registrarEmpleados(emp);

			if (registradoEmpleado) {
				// Si el empleado se registra con éxito, redirige a registrar contrato
				
				request.setAttribute("idEmpleado", empleadosModel.obtenerEmpleado(0).getIdEmpleados());
				request.getRequestDispatcher("/empleados/contratoFormulario.jsp").forward(request, response);
			} else {
				response.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			System.out.println("registrarEmpleado() " + e.getMessage());
		}
	}

	// Método para registrar el contrato
	protected void registrarContrato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));

			// Datos del contrato
			java.sql.Date fechaComienzo = java.sql.Date.valueOf(request.getParameter("fechaComienzo"));
			java.sql.Date fechaFin = java.sql.Date.valueOf(request.getParameter("fechaFin"));
			String vigencia = "Activo"; // Valor fijo
			int departamento = Integer.parseInt(request.getParameter("departamento"));

			// Crear objeto contrato
			Contratos contrato = new Contratos(0, fechaComienzo, fechaFin, vigencia, idEmpleado, departamento);

			// Registrar contrato
			boolean registradoContrato = contratosModel.insertarContrato(contrato);

			if (registradoContrato) {
				response.sendRedirect("EmpleadosController?operacion=listar");
			} else {
				response.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			System.out.println("registrarContrato() " + e.getMessage());
		}
	}

	// Método para editar un empleado
	protected void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String dni = request.getParameter("dni");
			String sexo = request.getParameter("sexo");
			String correo = request.getParameter("correo");
			String telefono = request.getParameter("telefono");
			String direccion = request.getParameter("direccion");
			java.sql.Date fechaNacimiento = java.sql.Date.valueOf(request.getParameter("fechaNacimiento"));
			Empleados emp = new Empleados(idEmpleado, nombre, apellido, dni, sexo, correo, telefono, direccion,
					fechaNacimiento);

			if (empleadosModel.editarEmpleados(emp) > 0) {
				request.getSession().setAttribute("exito", "empleado modificado");
			} else {
				request.getSession().setAttribute("exito", "empleado NO modificado");
			}
			response.sendRedirect(request.getContextPath() + "/EmpleadoController?operacion=listar");
		} catch (Exception e) {
			System.out.println("editar() " + e.getMessage());
		}
	}

	protected void obtener(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
			Empleados emp = empleadosModel.obtenerEmpleado(idEmpleado);

			if (emp != null) {
				request.setAttribute("empleado", emp);

				request.getRequestDispatcher("/empleados/editarEmpleados.jsp").forward(request, response);

			} else {
				response.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			System.out.println("obtener() " + e.getMessage());
			response.sendRedirect("error.jsp");
		}
	}

	// Método para eliminar un empleado
	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));

			boolean eliminado = empleadosModel.eliminarEmpleados(idEmpleado);
			if (eliminado) {
				response.sendRedirect("EmpleadosController?operacion=listar");
			} else {
				response.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			System.out.println("eliminar() " + e.getMessage());
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
}
