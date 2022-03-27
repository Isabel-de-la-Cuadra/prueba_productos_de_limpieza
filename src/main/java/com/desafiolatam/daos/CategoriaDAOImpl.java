package com.desafiolatam.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.desafiolatam.basedatos.BaseDatos;
import com.desafiolatam.models.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO{

	BaseDatos conexionBD = new BaseDatos();
	Connection conexion = null;
	Statement stmt = null;
	ResultSet resultado = null;
	
	@Override
	public int crearCategoria(Categoria categoria) {
		//No es necesario para el proyecto actual
		int resultado = 0;

		String query = "INSERT INTO categoria (nombre_categoria) values ('" + categoria.getNombre_categoria() + "')";
		System.out.println("en el método crearCategoria de CategoriaDAOImpl, la query " + query);

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);

			if (resultado == 1) {
				System.out.println("Inserción correcta");
			} else {
				System.out.println("Error al insertar");
			}
		} catch (Exception e) {
			System.out.println("en el catch del método crearCategoría de CategoriaDAOImpl " + e);
		}

		return resultado;
	}

	@Override
	public Categoria mostrarCategoria(int id_categoria) {
		
		Categoria categoria = new Categoria();

		String query = "SELECT * FROM categoria WHERE id_categoria = " + id_categoria;

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				int id_categoria1 = resultado.getInt(1);
				String nombre_categoria = resultado.getString(2);

				categoria = new Categoria(id_categoria1, nombre_categoria);
			}
		} catch (Exception e) {
			System.out.println("en el catch del método mostrarCategoria de CategoriaDAOImpl " + e);
		}

		return categoria;
	}

	@Override
	public int modificarCategoria(Categoria categoria) {
		//Terminar de implementar en otro momento
		int resultado = 0;

		String query = "UPDATE categoria SET nombre_categoria = ? "
				+ "WHERE id_categoria = ? ";
				
		System.out.println("en el método modificarCategoria de CategoriaDAOImpl, la query " + query);

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);

			if (resultado == 1) {
				System.out.println("Modificación correcta");
			} else {
				System.out.println("Error al modificar");
			}
		} catch (Exception e) {
			System.out.println("en el catch del método modificarCategoria de CategoriaDAOImpl " + e);
		}

		return resultado;
	}

	@Override
	public int eliminarCategoria(int id_categoria) {
		//Por terminar de implementar en otro momento
		
		int resultado = 0;
		
		String query = "DELETE FROM categoria WHERE id_categoria = " + id_categoria;
				
		System.out.println("en el método eliminarCategoria de CategoriaDAOImpl, la query " + query);

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);

			if (resultado == 1) {
				System.out.println("Eliminación correcta");
			}else {
				System.out.println("Error al eliminar");
			}
		}catch (Exception e) {
			System.out.println("en el catch del método eliminarCategoria de CategoriaDAOImpl " + e);
		}
		
		return resultado;
	}

	@Override
	public ArrayList<Categoria> obtenerListaCategoria() {
		
		ArrayList<Categoria> listaCategorias = new ArrayList<>();

		String query = "SELECT * FROM categoria ";

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				int idCategoria = resultado.getInt(1);
				String nombreCategoria = resultado.getString(2);
				
				Categoria categoria = new Categoria(idCategoria, nombreCategoria);
				
				listaCategorias.add(categoria);
			}
		} catch (Exception e) {
			System.out.println("en el catch del método obtenerListaCategoria de CategoriaDAOImpl " + e);
		}

		return listaCategorias;
	}

	@Override
	public Categoria obtenerCategoriaId(int id_categoria) {
		
		Categoria categoria = new Categoria();
		
		String query = "SELECT * FROM categoria WHERE id_categoria = " + id_categoria;
		
		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query); 
			
			while (resultado.next()) {
				int idCategoria = resultado.getInt(1);
				String nombreCategoria = resultado.getString(2);
				
				categoria = new Categoria(idCategoria, nombreCategoria);
				
			}
			
		}catch (Exception e) {
			System.out.println("en el catch DAOImpl" + e);
		}
		
		return categoria;
	}

}
