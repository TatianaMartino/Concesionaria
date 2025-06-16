package com.sample.core.service.reserva;

import java.util.List;

import domain.Auto;
import domain.Reserva;

public interface ReservaService {
	
	public void guardarPedido(Reserva reservao) throws Exception;
	
	public void buscarPorId(int id);
	
	public List<Reserva> listaReservas() throws Exception;


}
