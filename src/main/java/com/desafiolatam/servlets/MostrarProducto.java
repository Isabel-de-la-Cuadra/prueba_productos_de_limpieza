package com.desafiolatam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Por eliminar, no lo usaremos

@WebServlet("/mostrarProducto")
public class MostrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Crear variable de session y evitar que ingresen directo por la URL
		HttpSession session = request.getSession();
		String sessionNombre = (String) session.getAttribute("Nombre");
		if (sessionNombre != null) {
			request.getRequestDispatcher("mostrarProducto.jsp").forward(request, response);
		} else {
			request.setAttribute("msgError", "No tienes permiso para ingresar a esta parte");
			request.getRequestDispatcher("/inicio").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
