package com.sample.core.dao.traslado;

import java.util.List;

import domain.Traslado;

public interface TrasladoDao {
	
	 public void crear(Traslado traslado) throws Exception;
	
    public List<Traslado> listarPorSucursalOrigen(int sucursalOrigen_id) throws Exception;
    
    public void aceptarTraslado(int trasladoId) throws Exception;
}
