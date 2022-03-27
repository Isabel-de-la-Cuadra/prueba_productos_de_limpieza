package com.desafiolatam.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
	
	private String sServidor = "localhost"; //mi computador  o la ip 127.0.0.1
	private String sUsuario = "root"; //Usuario base de datos
	private String sPassword = "Admin1234"; //Clave de acceso a la base de datos
	private int iPuerto = 3306; //Puerto de conexión 
	private String sBaseDatos = "productosDeLimpieza"; //Nombre Base de Datos
	
	private String sServer = "";
	
	private static Connection conexion = null;
	
	public BaseDatos() {
		super();
	}

	public Connection datos() {
		//this.sBaseDatos = baseDatos;
		//recibir el nombre de la base de datos
		this.sServer = "jdbc:mysql://"+this.sServidor+":"+
						this.iPuerto+"/"+sBaseDatos;
		
		//registrar el driver mysql
		try {
			//Class.forName("com.mysql.jdbc.Driver");//Mysql
			Class.forName("com.mysql.cj.jdbc.Driver");//MariaDB
			
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.err.println("Error al registrar el driver Mysql: "+e);
			// Al detectar error termina el flujo
			//System.exit(0);
		}
		
		//conexion a mysql establecida
		
		try {
			conexion = DriverManager.getConnection(this.sServer,this.sUsuario,this.sPassword);
		} catch (SQLException e) {
			System.err.println("Error al conectar a Mysql: "+e);
			// Al detectar error termina el flujo
			//System.exit(0);
		}
		//System.out.println("Nos hemos conectado a la base de datos: "+ sBaseDatos);
		return conexion;
		
	}

}
