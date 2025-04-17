package com.sample.core.service.encargado;

import java.util.List;

import com.sample.core.dao.encargado.EncargadoDao;
import com.sample.core.dao.encargado.EncargadoDaoImp;
import domain.Encargado;

public class EncargadoServiceImpl implements EncargadoService {

	private EncargadoDao encargadoDao = new EncargadoDaoImp();

	@Override
	public List<Encargado> listarEncargado() throws Exception { // utiliza la lista creada en la interaz
																// EncargadoService

		return encargadoDao.list();
	}

	@Override
	public void crearEncargado(String nombre, String apellido, String usuario, String contrasena, String correo,
			int idsucursal) throws Exception { // utiliza el metodo creado en la interaz EncargadoService

		encargadoDao.save(nombre, apellido, usuario, contrasena, correo, idsucursal);

	}

}
