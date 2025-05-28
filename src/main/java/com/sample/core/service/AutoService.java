package com.sample.core.service;

import java.util.List;

import domain.Auto;
import utils.Disponibilidad;

public interface AutoService {
	
	public List<Auto> listarAutos() throws Exception;
	
	public Auto consultarAuto(int id) throws Exception;
	
	public void crearAuto(String modelo, String marca, String descripcion, int stock, int precio, int sucursal_id, String disponibilidad) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public void CambiarDisponibilidad(int id, Disponibilidad disponibilidadAuto) throws Exception;


}
