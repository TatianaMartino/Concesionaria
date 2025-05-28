package com.sample.core.dao.cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;

import domain.Cliente;

import com.sample.core.exceptions.ErrorException;

public class ClienteDaoImp implements ClienteDao {

	private Conexion conexion = Conexion.getInstance();

	private static final String queryAddCliente = "INSERT INTO cliente (nombre, apellido, correo, dni, codigo_postal, dato_tarjeta, telefono) VALUES (?,?,?,?,?,?,?)";

	private static final String queryList = "SELECT id, nombre, apellido, correo, dni, codigo_postal, dato_tarjeta, telefono FROM cliente";
	
	private static final String queryConsultarCliente = "SELECT id, nombre, apellido, correo, dni, codigo_postal, dato_tarjeta, telefono FROM cliente where id=?";


	
	@Override
	public List<Cliente> listarCliente() throws Exception {

		ResultSet rs = null;
		List<Cliente> clientes = null;
		Cliente cliente = null; // acá se van a guardar los datos
		PreparedStatement st = null;

		try {
			st = conexion.dameConnection().prepareStatement(queryList);
			rs = st.executeQuery();
			clientes = new ArrayList<Cliente>();
			while (rs.next()) {
				cliente = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				clientes.add(cliente);
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

		return clientes;
	}
	
	@Override
	public Cliente consultarCliente(int id) throws Exception {
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conexion.dameConnection().prepareStatement(queryConsultarCliente);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				return new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
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
		return null;
	}

	@Override
	public void guardar_datos(String nombre, String apellido, String correo, String dni, String codigo_postal,
			String dato_tarjeta, String telefono) throws Exception {

		PreparedStatement st = null;
		try {
		st = conexion.dameConnection().prepareStatement(queryAddCliente);
		st.setString(1, nombre);
		st.setString(2, apellido);
		st.setString(3, correo);
		st.setString(4, dni);
		st.setString(5, codigo_postal);
		st.setString(6, dato_tarjeta);
		st.setString(7, telefono);
		st.executeUpdate();
		finalizarConexion(st);
		
		// Confirmar la transacción
					st.getConnection().commit();
				} catch (SQLException e) {
					if (st != null) {
						try {
							st.getConnection().rollback();
						} catch (SQLException rollbackEx) {
							rollbackEx.printStackTrace();
						}
					}
					throw new SQLException("Error al guardar el cliente: " + e.getMessage(), e);
				} finally {
					if (st != null) {
						try {
							st.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
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
