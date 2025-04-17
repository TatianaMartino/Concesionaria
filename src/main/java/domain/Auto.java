package domain;

public class Auto {

	private String id;
	private String modelo;
	private String marca;
	private String descripcion;
	private int stock;
	private int precio;
	private int sucursal_id;
	private String disponibilidad;
	
	public Auto(String id, String modelo, String marca, String descripcion,int stock, int precio, int sucursal_id, String disponibilidad) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.sucursal_id = sucursal_id;
		this.disponibilidad = disponibilidad;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getSucursal_id() {
		return sucursal_id;
	}

	public void setSucursal_id(int sucursal_id) {
		this.sucursal_id = sucursal_id;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	
	
}
