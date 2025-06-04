package com.sample.core.dao.encargado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import domain.Encargado;
import com.sample.core.exceptions.ErrorException;

public class EncargadoDaoImp implements EncargadoDao {
	private Conexion conexion = Conexion.getInstance();

	private static final String queryList = "SELECT id,nombre,apellido,usuario,contrasena,correo, id_sucursal FROM Encargado";

	private static final String queryAddEncargado = "INSERT INTO Encargado (nombre, apellido, usuario, contrasena, correo, id_sucursal) VALUES (?,?,?,?,?,?)";

	@Override
	public List<Encargado> list() throws Exception {
		ResultSet rs = null;
		List<Encargado> encargados = null;
		Encargado encargado = null;
		PreparedStatement st = null;
		try {
			st = conexion.dameConnection().prepareStatement(queryList);
			rs = st.executeQuery();
			encargados = new ArrayList<Encargado>();
			while (rs.next()) {
				encargado = new Encargado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
				encargados.add(encargado);
			}

		} catch (Exception e) {
			throw new ErrorException("Hubo un error al realizar la consulta", e);
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return encargados;
	}

	@Override
	public void save(String nombre, String apellido, String usuario, String contra, String correo, int idSucursal)
			throws Exception {

		PreparedStatement st = conexion.dameConnection().prepareStatement(queryAddEncargado);
		st.setString(1, nombre);
		st.setString(2, apellido);
		st.setString(3, usuario);
		st.setString(4, contra);
		st.setString(5, correo);
		st.setInt(6, idSucursal);
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
