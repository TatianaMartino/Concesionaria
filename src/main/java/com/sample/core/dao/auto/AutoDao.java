package com.sample.core.dao.auto;

import java.util.List;

import domain.Auto;
import utils.Disponibilidad;

public interface AutoDao {

	public void save(String modelo, String marca, String descripcion, int stock, int precio, int sucursal_id, Disponibilidad disponibilidad, int stockBase) throws Exception;
	
	public List<Auto> listarAutos() throws Exception;
	
	public Auto consultarAuto(int id) throws Exception;
	
	public void delete (int id) throws Exception;
	
	public void CambiarEstado(int id, Disponibilidad disponibilidadAuto) throws Exception;
	
	public List<Auto> listarAutosReservados() throws Exception;
	


}
