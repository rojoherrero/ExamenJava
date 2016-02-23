package org.colega.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import org.colega.modelo.entidades.Colega;


public interface ColegaDao {

	// visualizaci�n, inserci�n, borrado y actualizaci�n

	// inserci�n
	void nuevoColega(Colega colega) throws SQLException;

	// inserci�n,
	void borrarColega(int isbn) throws SQLException;
	
	//Borrado
	void modificarColega(Colega colega) throws SQLException;
	
	Colega colegaPorId(int id) throws SQLException;
	
	//visualizaci�n
	Collection<Colega> todosLosColegas() throws SQLException;

}
