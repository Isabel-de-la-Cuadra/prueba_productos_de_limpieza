package com.desafiolatam.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.facade.CategoriaFacade;
import com.desafiolatam.facade.ProductoFacade;
import com.desafiolatam.models.Categoria;
import com.desafiolatam.models.Producto;

@WebServlet("/crearProducto")
public class CrearProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductoFacade productoFacade;
	CategoriaFacade categoriaFacade;

	public CrearProducto() {
		productoFacade = new ProductoFacade();
		categoriaFacade = new CategoriaFacade();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Crear variable de session y evitar que ingresen directo por la URL
		HttpSession session = request.getSession();
		String sessionNombre = (String) session.getAttribute("Nombre");
		if (sessionNombre != null) {
			ArrayList<Categoria> categorias = categoriaFacade.obtenerListaCategoria();
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("crearProducto.jsp").forward(request, response);
		} else {
			request.setAttribute("msgError", "No tienes permiso para ingresar a esta parte");
			request.getRequestDispatcher("/inicio").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// capturar como string todo y luego parsear

		String nombre_producto = request.getParameter("nombre_producto");
		String precioProducto = request.getParameter("precio_producto");
		String descripcion_producto = request.getParameter("descripcion_producto");
		String idCategoria = request.getParameter("id_categoria");

		if (nombre_producto != null && precioProducto != null && descripcion_producto != null && idCategoria != null
				&& !nombre_producto.isEmpty() && !precioProducto.isEmpty() && !descripcion_producto.isEmpty()) {

			int precio_producto = Integer.parseInt(precioProducto);
			int id_categoria = Integer.parseInt(idCategoria);

			Producto producto = new Producto();

			producto.setNombre_producto(nombre_producto);
			producto.setPrecio_producto(precio_producto);
			producto.setDescripcion_producto(descripcion_producto);
			producto.setId_categoria(id_categoria);

			int resultado = productoFacade.crearProducto(producto);

			if (resultado == 1) {
				request.setAttribute("msgExito", "Creación exitosa");
				doGet(request, response);

			} else {
				request.setAttribute("msgError", "Error al crear el producto");
				doGet(request, response);
			}
		} else {
			request.setAttribute("msgError", "Faltan datos, por favor, vuelve a ingresar");
			doGet(request, response);
		}
	}

}
