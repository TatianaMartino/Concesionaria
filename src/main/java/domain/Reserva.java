package domain;

import utils.Disponibilidad;
import utils.SituacionPedidos;

public class Reserva {

	private String id;
	private int monto;

	private SituacionPedidos situacion; // enum de Situacion

	Auto auto;

	Disponibilidad disponibilidad;

	Cliente cliente;

	public Reserva(Auto auto, Disponibilidad disponibilidad, Cliente cliente, SituacionPedidos situacion) {
		super();
		this.auto = auto;
		this.disponibilidad = disponibilidad;
		this.cliente = cliente; // obtener datos del cliente
		this.situacion = situacion; // obtener estado del pago
	}

	public String generarCodigo() {

		return "abcdefg";
	}
	
	public Auto getAuto() {
	    return auto;
	}

	public void setAuto(Auto auto) {
	    this.auto = auto;
	}

	public Cliente getCliente() {
	    return cliente;
	}

	public void setCliente(Cliente cliente) {
	    this.cliente = cliente;
	}

	public Disponibilidad getDisponibilidad() {
	    return disponibilidad;
	}

	public void setDisponibilidad(Disponibilidad disponibilidad) {
	    this.disponibilidad = disponibilidad;
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

	public SituacionPedidos getSituacion() {
		return situacion;
	}

	public void setSituacion(SituacionPedidos situacion) {
		this.situacion = situacion;
	}
}
