package java.com.unu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class EmpleadoController
 */
public class EmpleadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()){
			if(request.getParameter("operacion") == null) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
			
			String operacion = request.getParameter("operacion");
			switch (operacion) {
			case "listar": 
				//listar(request, response);
				break;
			case "insertar": 
				//insertar(request, response);
				break;
			case "editar": 
				//obtener(request, response);
				break;
			case "modificar": 
				//modificar(request, response);
				break;
			case "eliminar": 
				//eliminar(request, response);
				break;
			}
			
		} catch (Exception e) {
			System.out.println("processRequest() " + e.getMessage());
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
