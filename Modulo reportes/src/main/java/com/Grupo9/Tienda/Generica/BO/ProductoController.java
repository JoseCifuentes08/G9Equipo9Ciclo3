package com.Grupo9.Tienda.Generica.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo9.Tienda.Generica.DAO.ProductoDAO;
import com.Grupo9.Tienda.Generica.DTO.ProductosVO;


@RestController
public class ProductoController {

	/*
	 * @GetMapping obtener o buscar
	 * @PostMapping insertar o agregar
	 * @PutMapping modificar o actualizar
	 * @DeleteMapping eliminar o borrar
	 * */

	@PostMapping("/registrarproducto")
	public void registrarProducto(ProductosVO product) {
		ProductoDAO Dao = new ProductoDAO();
		Dao.registrarProducto(product);
	}

	@GetMapping("/consultarproducto")
	public ArrayList<ProductosVO> consultarProducto(Integer code) {
		ProductoDAO Dao = new ProductoDAO();
		return Dao.consultarProducto(code);
	}

	@GetMapping("/listarproductos")
	public ArrayList<ProductosVO> listaDeProductoes() {
		ProductoDAO Dao = new ProductoDAO();
		return Dao.listaDeProductos();
	}
	
	@DeleteMapping("/eliminarproducto")
	public void eliminarProducto(Integer code) {
		ProductoDAO Dao = new ProductoDAO();
		Dao.eliminarProducto(code);
	}
	
	@DeleteMapping("/eliminartodoproducto")
	public void eliminarTodoProducto() {
		ProductoDAO Dao = new ProductoDAO();
		Dao.eliminarTodoProducto();
	}
	
	@PutMapping("/actualizarproducto")
	public void actualizarProducto(ProductosVO product) {
		ProductoDAO Dao = new ProductoDAO();
		Dao.actualizarProducto(product);
	}
}
