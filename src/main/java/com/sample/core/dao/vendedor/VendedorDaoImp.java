package com.sample.core.dao.vendedor;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import domain.Vendedor;
import com.sample.core.exceptions.ErrorException;

public class VendedorDaoImp implements VendedorDao {
	private Conexion conexion = Conexion.getInstance();

	private static final String queryAddEncargado = "INSERT INTO vendedor (nombre, apellido, usuario, password, correo, id_sucursal) VALUES (?,?,?,?,?,?)";

	private static final String queryFindByUser = "SELECT id, usuario, password FROM vendedor where usuario = ?";

	private static final String queryFindByUserAndPassword = "SELECT id, usuario, password FROM vendedor where usuario = ? and password = ?";

	private static final String queryConsultarUsuario = "SELECT id, usuario, password FROM vendedor where id=?";

	/*@Override
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
	}*/
	@Override
	public void existeUsuario(String usuario) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			st = conexion.dameConnection().prepareStatement(queryFindByUser);
			st.setString(1, usuario);

			rs = st.executeQuery();
			boolean encontro = rs.next();

			if (!encontro) {
				throw new Exception("El usuario " + usuario + "no exite en DB");
			}
		} catch (Exception e) {
			throw new Exception("No existe el usuario");
		} finally {
			st.close();
			rs.close();
		}
	}

	@Override
	public void existeUsuarioPassword(String usuario, String password) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			st = conexion.dameConnection().prepareStatement(queryFindByUserAndPassword);

			st.setString(1, usuario);
			st.setString(2, password);

			rs = st.executeQuery();
			boolean encontro = rs.next();

			if (!encontro) {
				throw new Exception("El usuario " + usuario + " no coincide con la password");
			}
		} catch (Exception e) {
			throw new Exception("login incorrecto");
		} finally {
			st.close();
			rs.close();
		}

	}
	
	/*public void agregarReintento(String usuario) throws Exception {

	}*/

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
