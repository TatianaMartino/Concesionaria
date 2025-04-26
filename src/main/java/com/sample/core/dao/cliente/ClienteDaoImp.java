package com.sample.core.dao.cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sample.core.dao.config.Conexion;

public class ClienteDaoImp implements ClienteDao {

	private Conexion conexion = Conexion.getInstance();

	private static final String queryAddCliente = "INSERT INTO Cliente (nombre, apellido, correo, dni, codigo_postal, dato_tarjeta, telefono) VALUES (?,?,?,?,?,?)";

	@Override
	public void guardar_datos(String nombre, String apellido, String correo, String dni, String codigo_postal,
			String dato_tarjeta, String telefono) throws Exception {

		PreparedStatement st = conexion.dameConnection().prepareStatement(queryAddCliente);
		st.setString(1, nombre);
		st.setString(2, apellido);
		st.setString(3, correo);
		st.setString(4, dni);
		st.setString(5, codigo_postal);
		st.setString(6, dato_tarjeta);
		st.setString(7, telefono);
		st.executeUpdate();
		finalizarConexion(st);
	}

	private void finalizarConexion(PreparedStatement st) {
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
