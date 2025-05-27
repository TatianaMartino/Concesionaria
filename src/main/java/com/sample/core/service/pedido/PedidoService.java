package com.sample.core.service.pedido;

import domain.Pedido;

public interface PedidoService {
	
	public void guardarPedido(Pedido pedido) throws Exception;
	
	public void buscarPorId(int id);

}
