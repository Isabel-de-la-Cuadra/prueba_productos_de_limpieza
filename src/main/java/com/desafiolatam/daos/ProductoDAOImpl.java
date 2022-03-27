package com.desafiolatam.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.desafiolatam.basedatos.BaseDatos;
import com.desafiolatam.models.Producto;

public class ProductoDAOImpl implements ProductoDAO {

	BaseDatos conexionBD = new BaseDatos();
	Connection conexion = null;
	Statement stmt = null;
	ResultSet resultado = null;

	@Override
	public int crearProducto(Producto producto) {

		int resultado = 0;

		String query = "INSERT INTO producto (nombre_producto, precio_producto, descripcion_producto, id_categoria) values ('"
				+ producto.getNombre_producto() + "', '" + producto.getPrecio_producto() + "', '"
				+ producto.getDescripcion_producto() + "', '" + producto.getId_categoria() + "')";

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
			System.out.println("en el catch del método crearProducto de ProductoDAOImpl " + e);
		}

		return resultado;
	}

	@Override
	public Producto mostrarProducto(int id_producto) {

		Producto producto = new Producto();

		String query = "SELECT * FROM producto WHERE id_producto = " + id_producto;

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				int idProducto = resultado.getInt(1);
				String nombreProducto = resultado.getString(2);
				int precioProducto = resultado.getInt(3);
				String descripcionProducto = resultado.getString(4);
				int idCategoria = resultado.getInt(5);

				producto = new Producto(idProducto, nombreProducto, precioProducto, descripcionProducto, idCategoria);

			}
		} catch (Exception e) {
			System.out.println("en el catch del método mostrarProducto de ProductoDAOImpl " + e);
		}

		return producto;
	}

	@Override
	public int modificarProducto(Producto producto) {

		int resultado = 0;

		String query = "UPDATE producto SET id_producto = '" + producto.getId_producto() + "', nombre_producto = '"
				+ producto.getNombre_producto() + "', precio_producto = '" + producto.getPrecio_producto()
				+ "', descripcion_producto = '" + producto.getDescripcion_producto() + "', id_categoria = '"
				+ producto.getId_categoria() + "' WHERE id_producto = " + producto.getId_producto();

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
			System.out.println("En el catch del método modificarProducto de ProductoDAOImpl " + e);
		}

		return resultado;
	}

	@Override
	public int eliminarProducto(int id_producto) {

		int resultado = 0;

		String query = "DELETE FROM producto WHERE id_producto = " + id_producto;

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);

			if (resultado == 1) {
				System.out.println("Eliminación correcta");
			} else {
				System.out.println("Error al eliminar");
			}
		} catch (Exception e) {
			System.out.println("En el catch del método eliminarProducto de ProductoDAOImpl " + e);
		}

		return resultado;
	}

	@Override
	public ArrayList<Producto> obtenerListaProductos() {

		ArrayList<Producto> listaProductos = new ArrayList<>();

		String query = "SELECT * " + "FROM producto ";

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				int id_Producto = resultado.getInt(1);
				String nombre_Producto = resultado.getString(2);
				int precio_Producto = resultado.getInt(3);
				String descripcion_Producto = resultado.getString(4);
				int id_Categoria = resultado.getInt(5);

				Producto producto = new Producto(id_Producto, nombre_Producto, precio_Producto, descripcion_Producto,
						id_Categoria);
				listaProductos.add(producto);

			}
		} catch (Exception e) {
			System.out.println("en el catch del método obtenerListaProducto de ProductoDAOImpl " + e);
		}
		return listaProductos;
	}

	@Override
	public Producto obtenerProductoId(int id_producto) {

		Producto producto = new Producto();

		String query = "SELECT * FROM producto WHERE id_producto = " + id_producto;

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				int id_Producto = resultado.getInt(1);
				String nombre_Producto = resultado.getString(2);
				int precio_Producto = resultado.getInt(3);
				String descripcion_Producto = resultado.getString(4);
				int id_Categoria = resultado.getInt(5);

				producto = new Producto(id_Producto, nombre_Producto, precio_Producto, descripcion_Producto,
						id_Categoria);

			}

		} catch (Exception e) {
			System.out.println("en el catch DAOImpl" + e);
		}

		return producto;
	}

}
