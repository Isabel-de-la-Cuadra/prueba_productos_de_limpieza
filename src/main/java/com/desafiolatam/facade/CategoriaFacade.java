package com.desafiolatam.facade;

import java.util.ArrayList;

import com.desafiolatam.daos.CategoriaDAOImpl;
import com.desafiolatam.models.Categoria;

public class CategoriaFacade {
	
	public ArrayList<Categoria> obtenerListaCategoria() {
		
		CategoriaDAOImpl categoriaDAOImpl = new CategoriaDAOImpl();
		ArrayList<Categoria> listaCategorias = categoriaDAOImpl.obtenerListaCategoria();
		
		return listaCategorias;
	}

}
