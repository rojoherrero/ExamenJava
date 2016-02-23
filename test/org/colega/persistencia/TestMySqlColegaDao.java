package org.colega.persistencia;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbcp2.BasicDataSource;
import org.colega.modelo.entidades.Colega;
import org.junit.Test;



public class TestMySqlColegaDao {

	@Test
	public void test() {
		// Datos de entrada
		
		Colega colega = new Colega(12345, "Witiza", "Toledo", new Date());

		// Datos esperados de salida
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/colegajdbc"); // cadena de
																// conexion
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");

		// Sut
		MySqlColegaDao sut = new MySqlColegaDao(ds);

		// Ejecucion
		try {
			sut.nuevoColega(colega);
			Colega colegaObtenido = sut.colegaPorId(colega.getId());

		// Asertos
			assertEquals(colega, colegaObtenido);
			
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Se produce un SQLException, y no deberia");
		}

		//fail("Not yet implemented");
	}

}
	
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/

