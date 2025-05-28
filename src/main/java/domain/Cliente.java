package domain;

public class Cliente {
	
	private String id;
	private String nombre;
	private String apellido;
	private String correo;
	private String dni;
	private String codigo_postal;
	private String dato_tarjeta;
	private String telefono;
	
	public Cliente(String nombre, String apellido, String correo, String dni, String codigo_postal, String dato_tarjeta, String telefono){
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.dni = dni;
		this.codigo_postal = codigo_postal;
		this.dato_tarjeta = dato_tarjeta;
		this.telefono = telefono;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getDato_tarjeta() {
		return dato_tarjeta;
	}

	public void setDato_tarjeta(String dato_tarjeta) {
		this.dato_tarjeta = dato_tarjeta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	

}
