package com.sample.core.dao.auto;

import java.util.List;

import domain.Auto;

public interface AutoDao {

	public void save(String modelo, String marca, String descripcion, int stock, int precio, int sucursal_id, String disponibilidad) throws Exception;
	
	public List<Auto> listarAutos() throws Exception;
	
	public Auto consultarAuto(int id) throws Exception;
	
	public void delete (int id) throws Exception;
}
