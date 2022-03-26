package com.desafiolatam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.facade.ProductoFacade;
import com.desafiolatam.models.Producto;

@WebServlet("/eliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductoFacade productoFacade;

	public EliminarProducto() {
		productoFacade = new ProductoFacade();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Crear variable de session y evitar que ingresen directo por la URL
		HttpSession session = request.getSession();
		String sessionNombre = (String) session.getAttribute("Nombre");
		
		if (sessionNombre != null) {
			
			String idProducto = request.getParameter("id_producto");
			
			if (idProducto != null && !idProducto.isEmpty()) {

				int id_producto = Integer.parseInt(idProducto);
				
				Producto producto = productoFacade.mostrarProducto(id_producto);
				request.setAttribute("producto", producto);

			request.getRequestDispatcher("eliminarProducto.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("msgError", "No tienes permiso para ingresar a esta parte");
			request.getRequestDispatcher("/inicio").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Controlar ingreso como String y luego parseo

		String idProducto = request.getParameter("id_producto");

		if (idProducto != null && !idProducto.isEmpty()) {
			int id_producto = Integer.parseInt(idProducto);

			if (id_producto <= 0) {
				request.setAttribute("msgError", "Error al eliminar el producto");
				doGet(request, response);
			} else {

				int resultado = productoFacade.eliminarProducto(id_producto);

				if (resultado == 1) {
					request.setAttribute("msgExito", "Eliminación exitosa");
					doGet(request, response);

				} else {
					request.setAttribute("msgError", "Error al eliminar el producto");
					doGet(request, response);
				}
			}
		}else {
			request.setAttribute("msgError", "Faltan datos, por favor, vuelve a intentarlo");
			doGet(request, response);
		}
	}
}
