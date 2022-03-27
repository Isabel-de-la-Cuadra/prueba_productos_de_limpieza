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

@WebServlet("/modificarProducto")
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductoFacade productoFacade;
	CategoriaFacade categoriaFacade;

	public ModificarProducto() {
		productoFacade = new ProductoFacade();
		categoriaFacade = new CategoriaFacade();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Crear variable de session y evitar que ingresen directo por la URL
		HttpSession session = request.getSession();
		String sessionNombre = (String) session.getAttribute("Nombre");

		//Si el nombre de la sesión no es nulo, hay acceso a la página 
		if (sessionNombre != null) {
			
			String idProducto = request.getParameter("id_producto");
			
			if (idProducto != null && !idProducto.isEmpty()) {

				int id_producto = Integer.parseInt(idProducto);

				Producto producto = productoFacade.mostrarProducto(id_producto);
				
				ArrayList<Categoria> categorias = categoriaFacade.obtenerListaCategoria();
				
				request.setAttribute("categorias", categorias);
				request.setAttribute("producto", producto);
				request.getRequestDispatcher("modificarProducto.jsp").forward(request, response);

			} 
			
		} else {
			request.setAttribute("msgError", "No tienes permiso para ingresar a esta parte");
			request.getRequestDispatcher("/inicio").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		// capturar como string todo y luego parsear
		String idProducto = request.getParameter("id_producto");
		String nombre_producto = request.getParameter("nombre_producto");
		String precioProducto = request.getParameter("precio_producto");
		String descripcion_producto = request.getParameter("descripcion_producto");
		String idCategoria = request.getParameter("id_categoria");
		
		if (nombre_producto != null && precioProducto != null && descripcion_producto != null && idCategoria != null
				&& !nombre_producto.isEmpty() && !precioProducto.isEmpty() && !descripcion_producto.isEmpty()) {

			int id_producto = Integer.parseInt(idProducto);
			int precio_producto = Integer.parseInt(precioProducto);
			int id_categoria = Integer.parseInt(idCategoria);
		
			Producto producto = new Producto();
		
			producto.setId_producto(id_producto);
			producto.setNombre_producto(nombre_producto);
			producto.setPrecio_producto(precio_producto);
			producto.setDescripcion_producto(descripcion_producto);
			producto.setId_categoria(id_categoria);
			
			int resultado = productoFacade.modificarProducto(producto);

			if (resultado == 1) {
				request.setAttribute("msgExito", "Modificación exitosa");
				doGet(request, response);

			} else {
				request.setAttribute("msgError", "Error al modificar el producto");
				doGet(request, response);
			}
		} else {
			request.setAttribute("msgError", "Faltan datos, por favor, vuelve a ingresar");
			doGet(request, response);
		}

	}

}
