package com.grupo9.misiontic2022.tiendagenerica.DAO;

import java.sql.*;

/**
 * Clase que permite conectar con la base de datos
 * 
 *
 */
public class Conexion {
	
	/** Parametros de conexion */
	static String nombre_base_datos = "tiendagenerica";
	static String usuariobd = "Jose";
	static String clavebd = "1026296938";
	static String url = "jdbc:mysql://192.168.0.47/" + nombre_base_datos;
	
	//objeto sin inicializar de la conexiÃ³n
	Connection connection = null;

	/** Constructor de DbConnection */
	public Conexion() {
		try {
			// obtenemos el driver de para mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			// obtenemos la conexiÃ³n
			connection = DriverManager.getConnection(url, usuariobd, clavebd);
			
			//si hay conexiÃ³n correcta mostrar informaciÃ³n en consola
			if (connection != null) {
				System.out.println("ConexiÃ³n a base de datos " + nombre_base_datos + " OK\n");
			}
		
		} catch (SQLException e) {
			//error de la base de datos
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			//error en carga de clases
			System.out.println(e);
		} catch (Exception e) {
			//cualquier otro error
			System.out.println(e);
		}
	}

	/** Permite retornar la conexiÃ³n */
	public Connection getConnection() {
		return connection;
	}
	
	//cerrando la conexiÃ³n
	public void desconectar() {
		connection = null;
	}
}

