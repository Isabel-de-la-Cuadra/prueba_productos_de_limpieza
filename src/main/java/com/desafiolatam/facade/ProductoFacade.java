package com.desafiolatam.facade;

import java.util.ArrayList;

import com.desafiolatam.daos.ProductoCategoriaDAOImpl;
import com.desafiolatam.daos.ProductoDAOImpl;
import com.desafiolatam.models.Producto;
import com.desafiolatam.models.ProductoCategoria;

public class ProductoFacade {

	public int crearProducto(Producto producto) {

		ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl();
		int resultadoCrearProducto = productoDAOImpl.crearProducto(producto);
		return resultadoCrearProducto;
	}

	public Producto mostrarProducto(int id_producto) {

		ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl();
		Producto resultadoMostrarProducto = productoDAOImpl.mostrarProducto(id_producto);
		return resultadoMostrarProducto;

	};

	public int modificarProducto(Producto producto) {
		
		ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl();
		int resultadoModificarProducto = productoDAOImpl.modificarProducto(producto);
		return resultadoModificarProducto;
	};

	public int eliminarProducto(int id_producto) {
		
		ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl();
		int resultadoEliminarProducto = productoDAOImpl.eliminarProducto(id_producto);
		return resultadoEliminarProducto;
	};

	public ArrayList<ProductoCategoria> obtenerListaProductoCategoria() {
	
		ProductoCategoriaDAOImpl productoCategoriaDAOImpl = new ProductoCategoriaDAOImpl();
		ArrayList<ProductoCategoria> listaProductoCategoria = productoCategoriaDAOImpl.listarProductoCategoria();
		return listaProductoCategoria;

	};

	public Producto obtenerProductoId(int id_producto) {
		//Por implementar en otro momento
		return null;

	};

}
