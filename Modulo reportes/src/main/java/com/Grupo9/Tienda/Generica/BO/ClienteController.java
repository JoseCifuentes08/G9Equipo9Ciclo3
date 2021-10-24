package com.Grupo9.Tienda.Generica.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo9.Tienda.Generica.DAO.ClienteDAO;
import com.Grupo9.Tienda.Generica.DTO.ClientesVO;

@RestController
public class ClienteController {
	
	
	/*
	 * @GetMapping obtener o buscar
	 * @PostMapping insertar o agregar
	 * @PutMapping modificar o actualizar
	 * @DeleteMapping eliminar o borrar
	 * */

	@PostMapping("/registrarcliente")
	public void registrarCliente(ClientesVO cliente) {
		ClienteDAO Dao = new ClienteDAO();
		Dao.registrarCliente(cliente);
	}

	@GetMapping("/consultarcliente")
	public ArrayList<ClientesVO> consultarUsuarios(Integer cedula_cliente) {
		ClienteDAO Dao = new ClienteDAO();
		return Dao.consultarClientes(cedula_cliente);
	}

	@GetMapping("/listarclientes")
	public ArrayList<ClientesVO> listaDeClientes() {
		ClienteDAO Dao = new ClienteDAO();
		return Dao.listaDeClientes();
	}
	
	@DeleteMapping("/eliminarcliente")
	public void eliminarCliente(Integer cedula_cliente) {
		ClienteDAO Dao = new ClienteDAO();
		Dao.eliminarCliente(cedula_cliente);
	}
	
	@PutMapping("/actualizarclientes")
	public void actualizarClientes(ClientesVO cliente) {
		ClienteDAO Dao = new ClienteDAO();
		Dao.actualizarClientes(cliente);
	}
	
	

}
