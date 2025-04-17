	package com.sample.core.service;

import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.auto.AutoDao;
import com.sample.core.dao.auto.AutoDaoImp;

import domain.Auto;

public class AutoServiceImpl implements AutoService {
	
	private AutoDao AutoDao = new AutoDaoImp();

	@Override
	public void crearAuto(String modelo, String marca, String descripcion, int stock, int precio, int sucursal_id, String disponibilidad) throws Exception {
		AutoDao.save(modelo, marca, descripcion, stock, precio, sucursal_id, disponibilidad);
		
	}

	@Override
	public List<Auto> listarAutos() throws Exception {
		return AutoDao.listarAutos();
	}

	@Override
	public Auto consultarAuto(int id) throws Exception {
		return AutoDao.consultarAuto(id);
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}


}