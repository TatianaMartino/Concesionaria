package com.sample.core.service.cliente;

import com.sample.core.dao.cliente.ClienteDao;
import com.sample.core.dao.cliente.ClienteDaoImp;

public class ClienteServiceImp implements ClienteService{
	
	//
	ClienteDao clientedao = new ClienteDaoImp(); 

	@Override
	public void guardar_datos(String nombre, String apellido, String correo, String dni, String codigo_postal,
			String dato_tarjeta, String telefono) throws Exception {
		
		clientedao.guardar_datos(nombre, apellido, correo, dni, codigo_postal, dato_tarjeta, telefono);
		
	}
	

}
