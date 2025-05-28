package com.sample.core.service.cliente;

import java.util.List;

import com.sample.core.dao.cliente.ClienteDao;
import com.sample.core.dao.cliente.ClienteDaoImp;

import domain.Cliente;

public class ClienteServiceImp implements ClienteService{
	
	ClienteDao clienteDao = new ClienteDaoImp(); 

	@Override
	public void guardar_datos(String nombre, String apellido, String correo, String dni, String codigo_postal, String dato_tarjeta, String telefono) throws Exception {
		clienteDao.guardar_datos(nombre, apellido, correo, dni, codigo_postal, dato_tarjeta, telefono);
	
	}

	@Override
	public List<Cliente> listarCliente() throws Exception {
		return clienteDao.listarCliente();
	}
	
	@Override
	public Cliente consultarCliente(int id) throws Exception{
		return clienteDao.consultarCliente(id);
	}

	

}
