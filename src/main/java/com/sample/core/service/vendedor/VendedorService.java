package com.sample.core.service.vendedor;

import java.util.List;

import domain.Vendedor;

public interface VendedorService {

	public void existeUsuario(String usuario) throws Exception;

	public void existeUsuarioPassword(String usuario, String password) throws Exception;
	
	public Vendedor login(String usuario, String password) throws Exception;
	

}
