package com.sample.core.service.cliente;

import com.sample.core.dao.cliente.ClienteDao;
import com.sample.core.dao.cliente.ClienteDaoImp;

public class ClienteServiceImp implements ClienteService{
	
	//
	ClienteDao clienteDao = new ClienteDaoImp(); 

	@Override
	public void guardar_datos(String nombre, String apellido, String correo, String dni, String codigo_postal, String dato_tarjeta, String telefono) throws Exception {
		clienteDao.guardar_datos(nombre, apellido, correo, dni, codigo_postal, dato_tarjeta, telefono);
	
	}
	

}
