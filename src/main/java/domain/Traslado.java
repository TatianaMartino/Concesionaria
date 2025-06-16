package domain;

public class Traslado {
	
	private int id;
    private int autoId;
    private int sucursalOrigenId;
    private int sucursalDestinoId;
    private String estado;

    public Traslado(int id, int autoId, int sucursalOrigenId, int sucursalDestinoId) {
        this.id = id;
        this.autoId = autoId;
        this.sucursalOrigenId = sucursalOrigenId;
        this.sucursalDestinoId = sucursalDestinoId;
    }

    public Traslado(int autoId, int sucursalOrigenId, int sucursalDestinoId) {
        this(0, autoId, sucursalOrigenId, sucursalDestinoId);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAutoId() {
		return autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public int getSucursalOrigenId() {
		return sucursalOrigenId;
	}

	public void setSucursalOrigenId(int sucursalOrigenId) {
		this.sucursalOrigenId = sucursalOrigenId;
	}

	public int getSucursalDestinoId() {
		return sucursalDestinoId;
	}

	public void setSucursalDestinoId(int sucursalDestinoId) {
		this.sucursalDestinoId = sucursalDestinoId;
	}
    
    

}
