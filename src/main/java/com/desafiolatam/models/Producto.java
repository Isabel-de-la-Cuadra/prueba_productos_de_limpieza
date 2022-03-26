package com.desafiolatam.models;

public class Producto {

	private int id_producto;
	private String nombre_producto;
	private int precio_producto;
	private String descripcion_producto;
	private int id_categoria;
	
	public Producto() {
		super();
	}

	public Producto(String nombre_producto, int precio_producto, String descripcion_producto, int id_categoria) {
		super();
		this.nombre_producto = nombre_producto;
		this.precio_producto = precio_producto;
		this.descripcion_producto = descripcion_producto;
		this.id_categoria = id_categoria;
	}

	public Producto(int id_producto, String nombre_producto, int precio_producto, String descripcion_producto,
			int id_categoria) {
		super();
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.precio_producto = precio_producto;
		this.descripcion_producto = descripcion_producto;
		this.id_categoria = id_categoria;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public int getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(int precio_producto) {
		this.precio_producto = precio_producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre_producto=" + nombre_producto + ", precio_producto="
				+ precio_producto + ", descripcion_producto=" + descripcion_producto + ", id_categoria=" + id_categoria
				+ "]";
	}
}
