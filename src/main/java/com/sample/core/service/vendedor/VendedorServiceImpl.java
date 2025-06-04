package com.sample.core.service.vendedor;

import java.util.List;

import com.sample.core.dao.vendedor.VendedorDao;
import com.sample.core.dao.vendedor.VendedorDaoImp;

import domain.Vendedor;

public class VendedorServiceImpl implements VendedorService {

	private VendedorDao encargadoDao = new VendedorDaoImp();

	@Override
	public List<Vendedor> listarEncargado() throws Exception { // utiliza la lista creada en la interaz
																// EncargadoService

		return encargadoDao.list();
	}

	@Override
	public void crearEncargado(String nombre, String apellido, String usuario, String contrasena, String correo,
			int idsucursal) throws Exception { // utiliza el metodo creado en la interaz EncargadoService

		encargadoDao.save(nombre, apellido, usuario, contrasena, correo, idsucursal);

	}

}
