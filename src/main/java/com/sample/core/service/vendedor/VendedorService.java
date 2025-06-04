package com.sample.core.service.vendedor;

import java.util.List;

import domain.Vendedor;

public interface VendedorService {

	public List<Vendedor> listarEncargado() throws Exception; // crear una lista

	public void crearEncargado(String nombre, String apellido, String usuario, String contrasena, String correo,
			int idsucursal) throws Exception; // crear un metodo

}
