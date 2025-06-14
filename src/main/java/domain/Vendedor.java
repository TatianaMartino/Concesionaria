package domain;

public class Vendedor {

	private int id;
	private String nombre;
	private String apellido;
	private String usuario;
	private String password;
	private String correo;
	private int id_sucursal;

	public Vendedor(int id, String nombre, String apellido, String usuario, String password, String correo,
			int id_sucursal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		this.id_sucursal = id_sucursal;
	}


	public Vendedor() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getIdsucursal() {
		return id_sucursal;
	}

	public void setIdsucursal(int id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

}
