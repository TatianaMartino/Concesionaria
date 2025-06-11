package com.sample.core.service.vendedor;

import java.util.List;

import com.sample.core.dao.vendedor.VendedorDao;
import com.sample.core.dao.vendedor.VendedorDaoImp;

import domain.Vendedor;

public class VendedorServiceImpl implements VendedorService {

	private VendedorDao encargadoDao = new VendedorDaoImp();

	@Override
	public void existeVendedor(String usuario) throws Exception {
		encargadoDao.existeUsuario(usuario);
	}

	@Override
	public void existeVendedoryPassword(String usuario, String password) throws Exception {
		encargadoDao.existeUsuarioPassword(usuario, password);
	}

	



}
