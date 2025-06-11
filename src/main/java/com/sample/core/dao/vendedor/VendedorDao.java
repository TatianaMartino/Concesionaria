package com.sample.core.dao.vendedor;

import java.util.List;

import domain.Vendedor;

public interface VendedorDao{
	
	public List<Vendedor> list() throws Exception;
	
	public void save(String nombre, String apellido, String usuario, String contra, String correo, int idSucursal) throws Exception;
	
	public void existeUsuario(String usuario) throws Exception;

	public void existeUsuarioPassword(String usuario, String password) throws Exception;

	public void agregarReintento(String usuario) throws Exception;

}
