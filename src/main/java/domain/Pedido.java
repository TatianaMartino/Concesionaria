package domain;

import utils.Disponibilidad;

public class Pedido {

	Auto auto;

	Disponibilidad disponibilidad;

	public Pedido(Auto auto, Disponibilidad disponibilidad) {
		super();
		this.auto = auto;
		this.disponibilidad = disponibilidad;

		// obtener datos cliente
		/*
		 * String nombre = req.getParameter("nombre"); String apellido =
		 * req.getParameter("apellido"); String correo = req.getParameter("correo");
		 * String dni = req.getParameter("dni"); String codigo_postal =
		 * req.getParameter("codigo_postal"); String dato_tarjeta =
		 * req.getParameter("dato_tarjeta"); String telefono =
		 * req.getParameter("telefono");
		 */
	}

	public String generarCodigo() {

		return "abcdefg";
	}
}
