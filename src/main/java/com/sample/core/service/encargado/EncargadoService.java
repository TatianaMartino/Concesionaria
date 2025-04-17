package com.sample.core.service.encargado;

import java.util.List;

import domain.Encargado;

public interface EncargadoService {

	public List<Encargado> listarEncargado() throws Exception; // crear una lista

	public void crearEncargado(String nombre, String apellido, String usuario, String contrasena, String correo,
			int idsucursal) throws Exception; // crear un metodo

}
