package com.sample.core.service.cliente;

public interface ClienteService {
	
	public void guardar_datos(String nombre, String apellido, String correo, String dni, String codigo_postal, String dato_tarjeta, String telefono) throws Exception;


}
