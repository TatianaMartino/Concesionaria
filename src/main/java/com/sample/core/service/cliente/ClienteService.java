package com.sample.core.service.cliente;

import java.util.List;

import domain.Cliente;

public interface ClienteService {

	public List<Cliente> listarCliente() throws Exception;

	public Cliente consultarCliente(int id) throws Exception;

	public void guardar_datos(String nombre, String apellido, String correo, String dni, String codigo_postal, String dato_tarjeta, String telefono) throws Exception;

}
