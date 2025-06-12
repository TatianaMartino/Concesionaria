package com.sample.core.service.reserva;

import domain.Pedido;

public interface ReservaService {
	
	public void guardarPedido(Pedido pedido) throws Exception;
	
	public void buscarPorId(int id);

}
