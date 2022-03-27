package com.desafiolatam.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.facade.ProductoFacade;
import com.desafiolatam.models.ProductoCategoria;

@WebServlet("/listarProductos")
public class ListarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductoFacade productoFacade;

	public ListarProductos() {
		
		productoFacade = new ProductoFacade();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Crear variable de session y evitar que ingresen directo por la URL
		HttpSession session = request.getSession();
		String sessionNombre = (String) session.getAttribute("Nombre");
		if (sessionNombre != null) {
			ArrayList<ProductoCategoria> lista = productoFacade.obtenerListaProductoCategoria();
			request.setAttribute("listaProductos", lista);
			request.getRequestDispatcher("listarProductos.jsp").forward(request, response);

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
