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

	private static final String queryFindByUser = "SELECT id, usuario, password FROM vendedor where usuario = ?";

	private static final String queryFindByUserAndPassword = "SELECT id, usuario, password, id_sucursal FROM vendedor where usuario = ? and password = ?";

	private static final String queryConsultarUsuario = "SELECT id, usuario, password FROM vendedor where id=?";


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

	
	@Override
	public Vendedor buscarPorUsuarioYPassword(String usuario, String password) throws Exception {
	    PreparedStatement st = null;
	    ResultSet rs = null;
	    Vendedor vendedor = null;

	    try {
	        st = conexion.dameConnection().prepareStatement(queryFindByUserAndPassword);
	        st.setString(1, usuario);
	        st.setString(2, password);

	        rs = st.executeQuery();

	        if (rs.next()) {
	            vendedor = new Vendedor();
	            vendedor.setId(rs.getInt("id"));
	            vendedor.setUsuario(rs.getString("usuario"));
	            vendedor.setPassword(rs.getString("password"));
	            vendedor.setIdsucursal(rs.getInt("id_sucursal")); 
	        } else {
	            throw new Exception("Usuario o contraseña incorrectos");
	        }
	    } finally {
	        if (rs != null) rs.close();
	        if (st != null) st.close();
	    }

	    return vendedor;
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
