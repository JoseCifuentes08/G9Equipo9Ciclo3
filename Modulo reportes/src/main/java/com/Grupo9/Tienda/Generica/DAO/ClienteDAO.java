package com.Grupo9.Tienda.Generica.DAO;

import java.sql.*;
import java.util.ArrayList;
import com.Grupo9.Tienda.Generica.DTO.ClientesVO;


public class ClienteDAO {
	/**
	 * Permite registrar un Usuario nuevo
	 * 
	 * @param cliente
	 */
	
	public void registrarCliente(ClientesVO cliente) {

		Conexion conex = new Conexion();

		try {

			Statement estatuto = conex.getConnection().createStatement();
			

			String sentencia = "INSERT INTO clientes VALUES(" 
					+ cliente.getCedula_cliente() + "," + "'"
					+ cliente.getEmail_cliente() + "'," + "'" 
					+ cliente.getNombre_cliente() + "'," + "'" 
					+ cliente.getTelefono_cliente() + "'," + "'"  
					+ cliente.getDireccion_cliente() + "'" 
					+ ");";

			estatuto.executeUpdate(sentencia);
			System.out.println("Registrado " + sentencia);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR (SQL) --------------");
			System.out.println("No se pudo insertar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el cliente");
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


	public ArrayList<ClientesVO> consultarClientes(Integer cedula_cliente) {	

		ArrayList<ClientesVO> listaclientes = new ArrayList<ClientesVO>();		

		Conexion conex = new Conexion();
		try {

			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM clientes where cedula_cliente = ? ");		

			consulta.setInt(1, cedula_cliente);			

			ResultSet res = consulta.executeQuery();			

			if (res.next()) {
				ClientesVO Cliente = new ClientesVO();
				Cliente.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				Cliente.setEmail_cliente(res.getString("email_cliente"));
				Cliente.setNombre_cliente(res.getString("nombre_cliente"));
				Cliente.setTelefono_cliente(res.getString("telefono_cliente"));
				Cliente.setDireccion_cliente(res.getString("direccion_cliente"));

				listaclientes.add(Cliente);
			}

			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo consultar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listaclientes;
	}


	public ArrayList<ClientesVO> listaDeClientes() {

		ArrayList<ClientesVO> listaclientes = new ArrayList<ClientesVO>();
		
		Conexion conex = new Conexion();

		try {

			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");

			ResultSet res = consulta.executeQuery();

			while (res.next()) {
				ClientesVO Cliente = new ClientesVO();
				Cliente.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				Cliente.setEmail_cliente(res.getString("email_cliente"));
				Cliente.setNombre_cliente(res.getString("nombre_cliente"));
				Cliente.setTelefono_cliente(res.getString("telefono_cliente"));
				Cliente.setDireccion_cliente(res.getString("direccion_cliente"));

				listaclientes.add(Cliente);
			}
			
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo consultar todos los clientes");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los clientes");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return listaclientes;
	}

	public void eliminarCliente(Integer cedula_cliente) {
		
		Conexion conex = new Conexion();

		try {

			Statement consulta = conex.getConnection().createStatement();
			
			String sentencia = "delete from clientes where cedula_cliente=" + cedula_cliente + ";";
			
			System.out.println("Registrado " + sentencia);
			
			consulta.execute(sentencia);
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo eliminar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

	public void actualizarClientes(ClientesVO cliente) {
		
		Conexion conex = new Conexion();

		try {

			Statement estatuto = conex.getConnection().createStatement();

			String sentencia = "UPDATE clientes "
					+ "SET email_cliente = '"+cliente.getEmail_cliente()+"',"
					+ "nombre_cliente = '"+cliente.getNombre_cliente()+"',"
					+ "telefono_cliente = '"+cliente.getTelefono_cliente()+"',"
					+ "direccion_cliente = '"+cliente.getDireccion_cliente()+"' "
					+ "WHERE cedula_cliente = "+cliente.getCedula_cliente()+";";
			
			estatuto.executeUpdate(sentencia);

			System.out.println("Registrado " + sentencia);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo actualizar  el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}


}
