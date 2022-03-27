package com.desafiolatam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginProcesa")
public class LoginProcesa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Creación de usuario y contraseña tipo
		String admin = "admin";
		String contrasena = "admin";

		// captura de valores ingresados por el usuario
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		System.out.println("Usuario en ProcesaLogin.java" + usuario);
		System.out.println("Password en ProcesaLogin.java" + password);

		// validar los parámetros
		if (usuario.isEmpty() || usuario == null || password.isEmpty() || password == null) {
			request.setAttribute("msgError", "Datos faltantes, por favor verifica");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {

			if (usuario.equals(admin) && password.equals(contrasena)) {

				//Creación de la sesión de usuario
				HttpSession session = request.getSession(true);
				session.setAttribute("Nombre", usuario);
				
				Cookie cookie = new Cookie("nombre", admin);
				cookie.setMaxAge(9000);
				cookie.setComment("Cookie guardada para persistir el nombre del usuario y usarlo");
				response.addCookie(cookie);
				
				request.getRequestDispatcher("bienvenida.jsp").forward(request, response);

			} else {
				request.setAttribute("msgError", "La información ingresada no es correcta, por favor verifícala");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
