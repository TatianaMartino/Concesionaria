package com.sample.core.service.vendedor;

import java.util.List;

import com.sample.core.dao.vendedor.VendedorDao;
import com.sample.core.dao.vendedor.VendedorDaoImp;

import domain.Vendedor;

public class VendedorServiceImpl implements VendedorService {

	private VendedorDao vendedorDao = new VendedorDaoImp();

	@Override
	public void existeVendedor(String usuario) throws Exception {
		vendedorDao.existeUsuario(usuario);
	}

	@Override
	public void existeVendedoryPassword(String usuario, String password) throws Exception {
		vendedorDao.existeUsuarioPassword(usuario, password);
	}

	



}
