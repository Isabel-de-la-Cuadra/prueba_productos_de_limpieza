package com.desafiolatam.daos;

import java.util.ArrayList;

import com.desafiolatam.models.Producto;

public interface ProductoDAO {

	public int crearProducto(Producto producto);
	public Producto mostrarProducto (int id_producto);
	public int modificarProducto (Producto producto);
	public int eliminarProducto (int id_producto);
	public ArrayList<Producto>obtenerListaProductos();
	public Producto obtenerProductoId(int id_producto);
}
