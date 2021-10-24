package com.Grupo9.Tienda.Generica.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo9.Tienda.Generica.DAO.ProveedorDAO;
import com.Grupo9.Tienda.Generica.DTO.ProveedoresVO;

@RestController
public class ProveedorController {
	

	/*
	 * @GetMapping obtener o buscar
	 * @PostMapping insertar o agregar
	 * @PutMapping modificar o actualizar
	 * @DeleteMapping eliminar o borrar
	 * */

	@PostMapping("/registrarproveedores")
	public void registrarProveedor(ProveedoresVO proveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.registrarProveedor(proveedor);
	}

	@GetMapping("/consultarproveedores")
	public ArrayList<ProveedoresVO> consultarProveedore(Integer nit_proveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.consultarProveedores(nit_proveedor);
	}

	@GetMapping("/listarproveedores")
	public ArrayList<ProveedoresVO> listaDeProveedores() {
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.listaDeProveedores();
	}
	
	@DeleteMapping("/eliminarproveedores")
	public void eliminarProveedor(Integer nit_proveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.eliminarProveedor(nit_proveedor);
	}
	
	@PutMapping("/actualizarproveedores")
	public void actualizarProveedor(ProveedoresVO proveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.actualizarProveedores(proveedor);
	}

}
