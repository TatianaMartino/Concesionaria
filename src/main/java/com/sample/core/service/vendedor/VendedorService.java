package com.sample.core.service.vendedor;

import java.util.List;

import domain.Vendedor;

public interface VendedorService {

	public void existeVendedor(String usuario) throws Exception;
	
	public void existeVendedoryPassword(String usuario, String password) throws Exception;
	

}
