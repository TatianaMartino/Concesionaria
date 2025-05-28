package com.sample.core.dao.cliente;

import java.util.List;

import domain.Cliente;

public interface ClienteDao {
	
	public void guardar_datos(String nombre, String apellido, String correo, String dni, String codigo_postal, String dato_tarjeta, String telefono) throws Exception;

	public List<Cliente> listarCliente() throws Exception;
	
	public Cliente consultarCliente(int id) throws Exception;

}
