package com.sample.core.service.vendedor;

import java.util.List;

import com.sample.core.dao.vendedor.VendedorDao;
import com.sample.core.dao.vendedor.VendedorDaoImp;

import domain.Vendedor;

public class VendedorServiceImpl implements VendedorService {

	private VendedorDao vendedorDao = new VendedorDaoImp();

	@Override
	public void existeUsuario(String usuario) throws Exception {
		vendedorDao.existeUsuario(usuario);
	}

	@Override
	public void existeUsuarioPassword(String usuario, String password) throws Exception {
		vendedorDao.existeUsuarioPassword(usuario, password);
	}

	@Override
	public Vendedor login(String usuario, String password) throws Exception {
		return vendedorDao.buscarPorUsuarioYPassword(usuario, password);
	}


}
