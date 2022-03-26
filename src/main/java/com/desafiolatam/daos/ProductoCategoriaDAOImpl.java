package com.desafiolatam.daos;

import java.util.ArrayList;

import com.desafiolatam.models.Categoria;
import com.desafiolatam.models.Producto;
import com.desafiolatam.models.ProductoCategoria;

public class ProductoCategoriaDAOImpl implements ProductoCategoriaDAO{

	private ProductoDAO productoDAO = new ProductoDAOImpl();
	private CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
	
	
	@Override
	public ArrayList<ProductoCategoria> listarProductoCategoria() {
		
		ArrayList<ProductoCategoria> listaProductoCategoria = new ArrayList<>();
		
		ArrayList<Producto> listaProductos = productoDAO.obtenerListaProductos();
		
		for(Producto producto: listaProductos) {
			Categoria categoria = categoriaDAO.mostrarCategoria(producto.getId_categoria());
			
			ProductoCategoria productoCategoria = new ProductoCategoria();
			productoCategoria.setProducto(producto);
			productoCategoria.setCategoria(categoria);
			
			listaProductoCategoria.add(productoCategoria);
		}

		return listaProductoCategoria;
	}

}
