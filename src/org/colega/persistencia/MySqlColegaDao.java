package org.colega.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import javax.sql.DataSource;

import org.colega.modelo.entidades.Colega;



public class MySqlColegaDao implements ColegaDao {

	private static final String INSERT_COLEGA = "INSERT INTO colega (id, nombre, ciudad, fecha) "
			+ "VALUES (?,?,?,?)";
	
	private static final String DELETE_COLEGA = "INSERT INTO colega WHERE id = ?";
	
	private static final String UPDATE_COLEGA = "UPDATE Lcolega SET nombre = ?, ciudad = ?, fecha = ? "
			+ "WHERE id = ?";
	
	private static final String SELECT_COLEGA = "SELECT * FROM Libros";
	
	private static final String SELECT_BY_ID = "SELECT * FROM colega WHERE id = ?";

	private DataSource ds;

	public MySqlColegaDao(DataSource ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void nuevoColega(Colega colega) throws SQLException {
		Connection connection = null;
		try {
			// 1-Obtener la conexion
			connection = ds.getConnection();
			// 2-Obtener el "statement"
			PreparedStatement ps = connection.prepareStatement(INSERT_COLEGA);
			ps.setInt(1, colega.getId());
			ps.setString(2, colega.getNombre());
			ps.setString(3, colega.getCiudad());
			long miliSegundosDesde1970 = colega.getFecha().getTime();			
			java.sql.Date fechaQueQuiero = new java.sql.Date(miliSegundosDesde1970); 
			ps.setDate(4, fechaQueQuiero);
			// 3-Ejecutar la sentencia
			ps.executeUpdate();
			// Opcional, solo cuando sea una sentencia de tipo query.
			// 4-Procesado de los resultados
		} finally {
			// 5-Cerrar la conexion
			if (connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public void borrarColega(int id) throws SQLException {
		Connection connection = null;
		try {
			// 1-Obtener la conexion
			connection = ds.getConnection();
			// 2-Obtener el "statement"
			PreparedStatement ps = connection.prepareStatement(DELETE_COLEGA);
			ps.setInt(1, id);
			// 3-Ejecutar la sentencia
			ps.executeUpdate();
			// Opcional, solo cuando sea una sentencia de tipo query.
			// 4-Procesado de los resultados

		} finally {
			// 5-Cerrar la conexion
			if (connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public void modificarColega(Colega colega) throws SQLException {
		Connection connection = null;
		try {
			// 1-Obtener la conexion
			connection = ds.getConnection();
			// 2-Obtener el "statement"
			PreparedStatement ps = connection.prepareStatement(UPDATE_COLEGA);
			ps.setInt(1, colega.getId());
			ps.setString(2, colega.getNombre());
			ps.setString(3, colega.getCiudad());
			long miliSegundosDesde1970 = colega.getFecha().getTime();			
			java.sql.Date fechaQueQuiero = new java.sql.Date(miliSegundosDesde1970); 
			ps.setDate(4, fechaQueQuiero);
			// 3-Ejecutar la sentencia
			ps.executeUpdate();
			// Opcional, solo cuando sea una sentencia de tipo query.
			// 4-Procesado de los resultados
		} finally {
			// 5-Cerrar la conexion
			if (connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public Collection<Colega> todosLosColegas() throws SQLException {
		Collection<Colega> resultado = new HashSet<>();
		Connection connection = null;
		try {
			// 1-Obtener la conexion
			connection = ds.getConnection();
			// 2-Obtener el "statement"
			PreparedStatement ps = connection.prepareStatement(SELECT_COLEGA);

			// 3-Ejecutar la sentencia
			ResultSet rs = ps.executeQuery();
			// Opcional, solo cuando sea una sentencia de tipo query.
			// 4-Procesado de los resultados

			// Procesar el libro hasta que no haya siguiente
			if(rs.first()){;
				do {
					// Procesar el libro
					resultado.add(new Colega(
											rs.getInt("id"), 
											rs.getString("nombre"), 
											rs.getString("ciudad"), 
											rs.getDate("fecha")));
				} while (rs.next());
			}
			return resultado;
		} finally {
			// 5-Cerrar la conexion
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public Colega colegaPorId(int id) throws SQLException {
		Connection connection = null;
		try {
			// 1-Obtener la conexion
			connection = ds.getConnection();
			// 2-Obtener el "statement"
			PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id);
			// 3-Ejecutar la sentencia
			ResultSet rs = ps.executeQuery();
			// Opcional, solo cuando sea una sentencia de tipo query.
			// 4-Procesado de los resultados
			if (rs.first()) {
				// Accede a los campos del registro y creo un nuevo objeto Libro
				return new Colega(id, rs.getString("nombre"), rs.getString("ciudad"), rs.getDate("fecha"));
			}
			return null;
		} finally {
			// 5-Cerrar la conexion
			if (connection != null) {
				connection.close();
			}
		}
	}

}
