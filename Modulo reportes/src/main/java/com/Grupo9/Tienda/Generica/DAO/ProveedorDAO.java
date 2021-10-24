package com.Grupo9.Tienda.Generica.DAO;

import java.sql.*;
import java.util.ArrayList;
import com.Grupo9.Tienda.Generica.DTO.ProveedoresVO;


public class ProveedorDAO {
	
	/**
	 * Permite registrar un Usuario nuevo
	 * 
	 * @param proveedor
	 */
	
	public void registrarProveedor(ProveedoresVO proveedor) {

		Conexion conex = new Conexion();

		try {

			Statement estatuto = conex.getConnection().createStatement();
			

			String sentencia = "INSERT INTO proveedores VALUES(" 
					+ proveedor.getNit_proveedor() + "," + "'"
					+ proveedor.getNombre_proveedor() + "'," + "'" 
					+ proveedor.getDireccion_proveedor() + "'," + "'" 
					+ proveedor.getTelefono_proveedor() + "'," + "'"  
					+ proveedor.getCiudad_proveedor() + "'" 
					+ ");";

			estatuto.executeUpdate(sentencia);
			System.out.println("Registrado " + sentencia);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR (SQL) --------------");
			System.out.println("No se pudo insertar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el proveedor");
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


	public ArrayList<ProveedoresVO> consultarProveedores(Integer nit_proveedor) {	

		ArrayList<ProveedoresVO> listaproveedores = new ArrayList<ProveedoresVO>();		

		Conexion conex = new Conexion();
		try {

			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM proveedores where nit_proveedor = ? ");		

			consulta.setInt(1, nit_proveedor);			

			ResultSet res = consulta.executeQuery();			

			if (res.next()) {
				ProveedoresVO Proveedor = new ProveedoresVO();
				Proveedor.setNit_proveedor(Integer.parseInt(res.getString("nit_proveedor")));
				Proveedor.setNombre_proveedor(res.getString("nombre_proveedor"));
				Proveedor.setDireccion_proveedor(res.getString("direccion_proveedor"));
				Proveedor.setTelefono_proveedor(res.getString("telefono_proveedor"));
				Proveedor.setCiudad_proveedor(res.getString("ciudad_proveedor"));

				listaproveedores.add(Proveedor);
			}

			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo consultar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listaproveedores;
	}


	public ArrayList<ProveedoresVO> listaDeProveedores() {

		ArrayList<ProveedoresVO> listaproveedores = new ArrayList<ProveedoresVO>();
		
		Conexion conex = new Conexion();

		try {

			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");

			ResultSet res = consulta.executeQuery();

			while (res.next()) {
				ProveedoresVO Proveedor = new ProveedoresVO();
				Proveedor.setNit_proveedor(Integer.parseInt(res.getString("nit_proveedor")));
				Proveedor.setNombre_proveedor(res.getString("nombre_proveedor"));
				Proveedor.setDireccion_proveedor(res.getString("direccion_proveedor"));
				Proveedor.setTelefono_proveedor(res.getString("telefono_proveedor"));
				Proveedor.setCiudad_proveedor(res.getString("ciudad_proveedor"));

				listaproveedores.add(Proveedor);
			}
			
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo consultar todos los proveedores");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los proveedores");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return listaproveedores;
	}

	public void eliminarProveedor(Integer nit_proveedor) {
		
		Conexion conex = new Conexion();

		try {

			Statement consulta = conex.getConnection().createStatement();
			
			String sentencia = "delete from proveedores where nit_proveedor=" + nit_proveedor + ";";
			
			System.out.println("Registrado " + sentencia);
			
			consulta.execute(sentencia);
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo eliminar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

	public void actualizarProveedores(ProveedoresVO proveedor) {
		
		Conexion conex = new Conexion();

		try {

			Statement estatuto = conex.getConnection().createStatement();

			String sentencia = "UPDATE proveedores "
					+ "SET nombre_proveedor = '"+proveedor.getNombre_proveedor()+"',"
					+ "direccion_proveedor = '"+proveedor.getDireccion_proveedor()+"',"
					+ "telefono_proveedor = '"+proveedor.getTelefono_proveedor()+"',"
					+ "ciudad_proveedor = '"+proveedor.getCiudad_proveedor()+"' "
					+ "WHERE nit_proveedor = "+proveedor.getNit_proveedor()+";";
			
			estatuto.executeUpdate(sentencia);

			System.out.println("Registrado " + sentencia);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo actualizar  el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

}
