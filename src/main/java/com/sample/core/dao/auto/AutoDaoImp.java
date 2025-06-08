package com.sample.core.dao.auto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Disponibilidad;

import com.sample.core.dao.config.Conexion;
import domain.Auto;

import com.sample.core.exceptions.ErrorException;

public class AutoDaoImp implements AutoDao {

	private Conexion conexion = Conexion.getInstance();

	private static final String queryAddAuto = "INSERT INTO autos (modelo, marca, descripcion, stock, precio, sucursal_id, disponibilidad) VALUES (?,?,?,?,?,?,?)";

	private static final String queryList = "SELECT id, modelo, marca, descripcion, stock, precio, sucursal_id, disponibilidad FROM autos";

	private static final String queryConsultarAuto = "SELECT id, modelo, marca, descripcion, stock, precio, sucursal_id, disponibilidad FROM autos where id=?";

	private static final String querydeleteAuto = "DELETE FROM autos WHERE id = ?";

	private static final String queryCambiarEstadoAuto = "UPDATE autos set disponibilidad = ? where id = ?";



	// verifica si existe una sucursal en la base de datos con un determinado id.
	private boolean existeSucursal(int sucursalId) throws SQLException {
		String query = "SELECT COUNT(*) FROM sucursal WHERE id = ?"; // Count es para contar las filas que hay en la
																		// tabla sucursal donde el id sea igual al
																		// sucursalId que se pasó como parámetro.
		try (PreparedStatement stmt = conexion.dameConnection().prepareStatement(query)) {
			stmt.setInt(1, sucursalId); // Asigna el valor del parámetro sucursalId al "?" de la consulta SQL.
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1) > 0; // Devuelve el resultado del COUNT(*)) y devuelve true si es mayor que 0, o
												// sea, si existe una sucursal con ese ID.
				}
			}
		}
		return false; // Si no hay resultados o si algo falla dentro del try, devuelve false al final
						// del método.
	}

	@Override
	public List<Auto> listarAutos() throws Exception {

		ResultSet rs = null;
		List<Auto> autos = null;
		Auto auto = null; // acá se van a guardar los datos
		PreparedStatement st = null;

		try {
			st = conexion.dameConnection().prepareStatement(queryList);
			rs = st.executeQuery();
			autos = new ArrayList<Auto>();
			while (rs.next()) {
				auto = new Auto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getString(8));
				autos.add(auto);
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

		return autos;
	}

	@Override
	public Auto consultarAuto(int id) throws Exception {
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = conexion.dameConnection().prepareStatement(queryConsultarAuto);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				return new Auto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getString(8));
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
	public void save(String modelo, String marca, String descripcion, int stock, int precio, int sucursal_id, Disponibilidad disponibilidad) throws Exception {

		// Verificar si la sucursal existe
		if (!existeSucursal(sucursal_id)) {
			throw new SQLException("La sucursal con id " + sucursal_id + " no existe.");
		}
		
		PreparedStatement ps = null;
		try {
			// Usar PreparedStatement en lugar de Statement para prevenir inyecciones SQL
			ps = conexion.dameConnection().prepareStatement(queryAddAuto);
			ps.setString(1, modelo);
			ps.setString(2, marca);
			ps.setString(3, descripcion);
			ps.setInt(4, stock);
			ps.setInt(5, precio);
			ps.setInt(6, sucursal_id);
			ps.setString(7, disponibilidad.name());  // Convierte enum a String

			// Desactivar auto commit para manejo transaccional
			ps.getConnection().setAutoCommit(false);

			ps.executeUpdate();

			// Confirmar la transacción
			ps.getConnection().commit();
		} catch (SQLException e) {
			if (ps != null) {
				try {
					ps.getConnection().rollback();
				} catch (SQLException rollbackEx) {
					rollbackEx.printStackTrace();
				}
			}
			throw new SQLException("Error al guardar el auto: " + e.getMessage(), e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
		
		
		/*Connection conn = null;
		PreparedStatement ps = null;

		try {
		    conn = conexion.dameConnection();
		    conn.setAutoCommit(false);
		    
			// Usar PreparedStatement en lugar de Statement para prevenir inyecciones SQL
			ps = conexion.dameConnection().prepareStatement(queryAddAuto);
			ps.setString(1, modelo);
			ps.setString(2, marca);
			ps.setString(3, descripcion);
			ps.setInt(4, stock);
			ps.setInt(5, precio);
			ps.setInt(6, sucursal_id);
			ps.setString(7, disponibilidad.name());  // Convierte enum a String
			ps.executeUpdate();

			 conn.commit();
			 System.out.println("Se creo el auto.");
		} catch (SQLException e) {
			 if (conn != null) {
			        try {
			            conn.rollback();
			        } catch (SQLException rollbackEx) {
			            rollbackEx.printStackTrace();
			        }
			}
			throw new SQLException("Error al guardar el auto: " + e.getMessage(), e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	*/

	@Override
	public void delete(int id) throws Exception {
		Connection connection = this.conexion.dameConnection();
		PreparedStatement st = connection.prepareStatement(querydeleteAuto);
		st.setInt(1, id);

		try {
			// Desactivar auto-commit para manejar transacciones manualmente
			connection.setAutoCommit(false);

			int registros = st.executeUpdate();

			System.out.println("Registros eliminados: " + registros); // Asegúrate de que sea 1, si no es así, algo está
																		// fallando

			if (registros == 0) {
				throw new Exception("Hubo un error al eliminar el auto.");
			}

			// Confirmar la transacción si todo salió bien
			connection.commit();
		} catch (SQLException e) {
			// Si ocurre un error, hacer un rollback
			connection.rollback();
			throw new Exception("Error al eliminar el auto: " + e.getMessage(), e);
		} finally {
			// Restaurar auto-commit y cerrar recursos
			connection.setAutoCommit(true);
			st.close();
		}

	}

	public void CambiarEstado(int id, Disponibilidad disponibilidadAuto) throws Exception {

		PreparedStatement ps = null;
		try {
			ps = conexion.dameConnection().prepareStatement(queryCambiarEstadoAuto);
			ps.setString(1, disponibilidadAuto.name());
			ps.setInt(2, id);
		    ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace(); // imprime el error
		} finally {
			ps.close();

		}
	};

	private void finalizarConexion(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
