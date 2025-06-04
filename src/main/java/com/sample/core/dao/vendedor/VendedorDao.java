package com.sample.core.dao.encargado;

import java.util.List;

import domain.Encargado;

public interface EncargadoDao{
	
	public List<Encargado> list() throws Exception;
	
	public void save(String nombre, String apellido, String usuario, String contra, String correo, int idSucursal) throws Exception;

}

