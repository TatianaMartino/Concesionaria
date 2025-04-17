package domain;

public class Sucursal {
	
	private int id;
	private String direccion;
	private String codigoPostal;
	private int idEncargado;
	
	
	//Getters y Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public int getIdEncargado() {
		return idEncargado;
	}
	public void setIdEncargado(int idEncargado) {
		this.idEncargado = idEncargado;
	}
	
}
