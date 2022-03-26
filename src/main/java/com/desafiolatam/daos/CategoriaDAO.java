package com.desafiolatam.daos;

import java.util.ArrayList;

import com.desafiolatam.models.Categoria;

public interface CategoriaDAO {

	public int crearCategoria(Categoria categoria);
	public Categoria mostrarCategoria (int id_categoria);
	public int modificarCategoria (Categoria categoria);
	public int eliminarCategoria (int id_categoria);
	public ArrayList<Categoria>obtenerListaCategoria();
	public Categoria obtenerCategoriaId(int id_categoria);
	
}
