package com.sample.core.dao.vendedor;

import java.util.List;

import domain.Vendedor;

public interface VendedorDao{
	
	public List<Vendedor> list() throws Exception;
	
	public void save(String nombre, String apellido, String usuario, String contra, String correo, int idSucursal) throws Exception;

}
