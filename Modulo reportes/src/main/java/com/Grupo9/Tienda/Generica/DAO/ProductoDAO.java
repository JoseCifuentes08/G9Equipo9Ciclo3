package com.Grupo9.Tienda.Generica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Grupo9.Tienda.Generica.DTO.ProductosVO;

public class ProductoDAO {

	public void registrarProducto(ProductosVO product) {

		Conexion conex = new Conexion();

		try {

			Statement estatuto = conex.getConnection().createStatement();
			

			String sentencia = "INSERT INTO productos VALUES(" 
					+ product.getCodigo_producto() + "," 
					+ product.getIva_compra() + ","
					+ product.getNit_proveedor() + ",'" 
					+ product.getNombre_producto()+ "'," 
					+ product.getPrecio_compra() + "," 
					+ product.getPrecio_venta() + "" 
					+ ");";
			

			estatuto.executeUpdate(sentencia);

			System.out.println("Registrado " + sentencia);

			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {

			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo insertar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {

			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}


	public ArrayList<ProductosVO> consultarProducto(Integer product) {	

		ArrayList<ProductosVO> listaproductos = new ArrayList<ProductosVO>();		

		Conexion conex = new Conexion();
		try {

			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM productos where codigo_producto = ? ");		

			consulta.setInt(1, product);			

			ResultSet res = consulta.executeQuery();			

			if (res.next()) {
				ProductosVO newproducto = new ProductosVO();
				newproducto.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
				newproducto.setIva_compra(Double.parseDouble(res.getString("iva_compra")));
				newproducto.setNit_proveedor(Integer.parseInt(res.getString("nit_proveedor")));
				newproducto.setNombre_producto(res.getString("nombre_producto"));
				newproducto.setPrecio_compra(Double.parseDouble(res.getString("precio_compra")));
				newproducto.setPrecio_venta(Double.parseDouble(res.getString("precio_venta")));

				listaproductos.add(newproducto);
			}

			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {

			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo consultar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listaproductos;
	}


	public ArrayList<ProductosVO> listaDeProductos() {

		ArrayList<ProductosVO> listaproductos = new ArrayList<ProductosVO>();

		Conexion conex = new Conexion();

		try {

			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos");

			ResultSet res = consulta.executeQuery();

			while (res.next()) {
				ProductosVO newproducto = new ProductosVO();
				newproducto.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
				newproducto.setIva_compra(Double.parseDouble(res.getString("iva_compra")));
				newproducto.setNit_proveedor(Integer.parseInt(res.getString("nit_proveedor")));
				newproducto.setNombre_producto(res.getString("nombre_producto"));
				newproducto.setPrecio_compra(Double.parseDouble(res.getString("precio_compra")));
				newproducto.setPrecio_venta(Double.parseDouble(res.getString("precio_venta")));

				listaproductos.add(newproducto);
			}

			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {

			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo consultar todos los productos");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {

			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los productos");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return listaproductos;
	}

	public void eliminarProducto(Integer codigo_producto) {
		
		Conexion conex = new Conexion();

		try {
			
			Statement consulta = conex.getConnection().createStatement();

			String sentencia = "delete from productos where codigo_producto=" + codigo_producto + ";";

			System.out.println("Producto eliminado " + sentencia);

			consulta.execute(sentencia);

			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {

			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo eliminar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {

			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

	public void actualizarProducto(ProductosVO product) {
		
		Conexion conex = new Conexion();

		try {

			Statement estatuto = conex.getConnection().createStatement();
			
			String sentencia = "UPDATE productos "
					+ "SET iva_compra = "+product.getIva_compra()+","
					+ "nombre_producto = '"+product.getNombre_producto()+"',"
					+ "nit_proveedor = "+product.getNit_proveedor()+","
					+ "precio_compra = "+product.getPrecio_compra()+","
					+ "precio_venta = "+product.getPrecio_venta()+""
					+ "WHERE codigo_producto = "+product.getCodigo_producto()+";";
			

			estatuto.executeUpdate(sentencia);

			System.out.println("Productos actualizados " + sentencia);

			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {

			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo actualizar  el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {

			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}
	
	
	public void eliminarTodoProducto() {
		

		Conexion conex = new Conexion();

		try {

			Statement consulta = conex.getConnection().createStatement();
			

			String sentencia = "delete from productos;";
			
			System.out.println("Datos eliminados " + sentencia);
			

			consulta.execute(sentencia);
			

			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {

			System.out.println("------------------- ERROR SQL --------------");
			System.out.println("No se pudo eliminar todos los productos");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {

			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar todos los productos");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

}
