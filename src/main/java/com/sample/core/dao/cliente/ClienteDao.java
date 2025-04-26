package com.sample.core.dao.cliente;

public interface ClienteDao {
	
	public void guardar_datos(String nombre, String apellido, String correo, String dni, String codigo_postal, String dato_tarjeta, String telefono) throws Exception;

}
