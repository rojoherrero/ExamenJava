package org.colega.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import org.colega.modelo.entidades.Colega;


public interface ColegaDao {

	// visualización, inserción, borrado y actualización

	// inserción
	void nuevoColega(Colega colega) throws SQLException;

	// inserción,
	void borrarColega(int isbn) throws SQLException;
	
	//Borrado
	void modificarColega(Colega colega) throws SQLException;
	
	Colega colegaPorId(int id) throws SQLException;
	
	//visualización
	Collection<Colega> todosLosColegas() throws SQLException;

}
