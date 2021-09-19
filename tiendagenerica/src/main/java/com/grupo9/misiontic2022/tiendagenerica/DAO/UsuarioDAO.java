package com.grupo9.misiontic2022.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.grupo9.misiontic2022.tiendagenerica.DTO.UsuarioDTO;

/**
 * Clase que permite el acceso a la base de datos
 *
 */
public class UsuarioDAO {

	/**
	 * Permite registrar un Usuario nuevo
	 * 
	 * @param user
	 */

	public void registrarUsuario(UsuarioDTO user) {
		//llama y crea una instancia de la clase encargada de hacer la conexiÃ³n
		Conexion conex = new Conexion();

		try {
			//sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();
			
			//String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO usuarios VALUES(" 
					+ user.getCedula_usuario() + "," + "'"
					+ user.getEmail_usuario() + "'," + "'" 
					+ user.getNombre_usuario() + "'," + "'" 
					+ user.getPassword()+ "'," + "'" 
					+ user.getUsuario() + "'" 
					+ ");";
			
			//se ejecuta la sentencia en la base de datos
			estatuto.executeUpdate(sentencia);
			//impresiÃ³n en consola para verificaciÃ³n 
			System.out.println("Registrado " + sentencia);
			//cerrando la sentencia y la conexiÃ³n
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

	/**
	 * permite consultar el Usuario asociado al user enviado como parametro
	 * 
	 * @param documento
	 * @return
	 */
	public ArrayList<UsuarioDTO> consultarUsuario(String usuario) {
		
		//lista que contendra el o los usuarios obtenidos
		ArrayList<UsuarioDTO> listausuarios = new ArrayList<UsuarioDTO>();
		
		//instancia de la conexiÃ³n
		Conexion conex = new Conexion();

		try {
			//prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM usuarios where usuario = ? ");
			
			// se cambia el comodin ? por el dato que ha llegado en el parametro de la funcion
			consulta.setString(1, usuario);
			
			//ejecute la sentencia
			ResultSet res = consulta.executeQuery();
			
			//cree un objeto basado en la clase entidad con los datos encontrados
			if (res.next()) {
				UsuarioDTO Usuario = new UsuarioDTO();
				Usuario.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
				Usuario.setEmail_usuario(res.getString("email_usuario"));
				Usuario.setNombre_usuario(res.getString("nombre_usuario"));
				Usuario.setPassword(res.getString("password"));
				Usuario.setUsuario(res.getString("usuario"));

				listausuarios.add(Usuario);
			}
			
			//cerrar resultado, sentencia y conexiÃ³n
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listausuarios;
	}

	/**
	 * permite consultar la lista de todos los usuarios
	 * 
	 * @return
	 */
	public ArrayList<UsuarioDTO> listaDeUsuarios() {
		//lista que contendra el o los usuarios obtenidos
		ArrayList<UsuarioDTO> listausuarios = new ArrayList<UsuarioDTO>();
		
		//instancia de la conexiÃ³n
		Conexion conex = new Conexion();

		try {
			//prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
			
			//ejecute la sentencia
			ResultSet res = consulta.executeQuery();
			
			//cree un objeto para cada encontrado en la base de datos basado en la clase entidad con los datos encontrados
			while (res.next()) {
				UsuarioDTO Usuario = new UsuarioDTO();
				Usuario.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
				Usuario.setEmail_usuario(res.getString("email_usuario"));
				Usuario.setNombre_usuario(res.getString("nombre_usuario"));
				Usuario.setPassword(res.getString("password"));
				Usuario.setUsuario(res.getString("usuario"));

				listausuarios.add(Usuario);
			}
			
			//cerrar resultado, sentencia y conexiÃ³n
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los usuarios");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los usuarios");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return listausuarios;
	}

	public void eliminarUsuario(Integer cedula_usuario) {
		
		//instancia de la conexion
		Conexion conex = new Conexion();

		try {
			//sentencia inicializada
			Statement consulta = conex.getConnection().createStatement();
			
			//preparando sentencia a realizar
			String sentencia = "delete from usuarios where cedula_usuario=" + cedula_usuario + ";";
			
			//impresion de verificaciÃ³n
			System.out.println("Registrado " + sentencia);
			
			//ejecutando la sentencia en la base de datos
			consulta.execute(sentencia);
			
			//cerrando sentencia y conexiÃ³n
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

	public void actualizarUsuario(UsuarioDTO user) {
		
		//instancia de conexion
		Conexion conex = new Conexion();

		try {
			//inicializando sentencia
			Statement estatuto = conex.getConnection().createStatement();
			
			//String con la sentencia a ejecutar
			String sentencia = "UPDATE usuarios "
					+ "SET email_usuario = '"+user.getEmail_usuario()+"',"
					+ "nombre_usuario = '"+user.getNombre_usuario()+"',"
					+ "password = '"+user.getPassword()+"',"
					+ "usuario = '"+user.getUsuario()+"' "
					+ "WHERE cedula_usuario = "+user.getCedula_usuario()+";";
			
			//ejecuta la sentencia 
			estatuto.executeUpdate(sentencia);
			
			//verificaciÃ³n por consola de la sentencia
			System.out.println("Registrado " + sentencia);
			
			//cerrando sentencia y conexiÃ³n
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo actualizar  el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

}
