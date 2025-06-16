package com.sample.core.service.traslado;

import domain.Traslado;
import java.util.List;
import com.sample.core.dao.traslado.TrasladoDao;
import com.sample.core.dao.traslado.TrasladoDaoImp;

public class TrasladoServiceImp implements TrasladoService {

	private TrasladoDaoImp trasladoDao = new TrasladoDaoImp();

	@Override
	public void crearTraslado(Traslado traslado) throws Exception {
		trasladoDao.crear(traslado);
	}

	@Override
	public List<Traslado> listarPedidosRecibidos(int sucursalOrigenId) throws Exception {
		return trasladoDao.listarPorSucursalOrigen(sucursalOrigenId);
	}

	@Override
	public void aceptarTraslado(int idTraslado) throws Exception {
		trasladoDao.aceptarTraslado(idTraslado);
	}

}
