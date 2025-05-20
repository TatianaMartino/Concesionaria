package domain;

import utils.Disponibilidad;
import utils.Situacion;

public class Pedido {

	private String id;
	private int monto;

	private Situacion situacion; // enum de Situacion

	Auto auto;

	Disponibilidad disponibilidad;

	Cliente cliente;

	public Pedido(Auto auto, Disponibilidad disponibilidad, Cliente cliente, Situacion situacion) {
		super();
		this.auto = auto;
		this.disponibilidad = disponibilidad;
		this.cliente = cliente; // obtener datos del cliente
		this.situacion = situacion; // obtener estado del pago
	}

	public String generarCodigo() {

		return "abcdefg";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public Situacion getSituacion() {
		return situacion;
	}

	public void setSituacion(Situacion situacion) {
		this.situacion = situacion;
	}
}
