package com.sample.core.service.traslado;

import java.util.List;

import domain.Traslado;

public interface TrasladoService {

	void crearTraslado(Traslado traslado) throws Exception;
    List<Traslado> listarPedidosRecibidos(int sucursalOrigenId) throws Exception;
    void aceptarTraslado(int idTraslado) throws Exception;

}
