package org.colega.modelo.negocio;

import java.sql.SQLException;
import java.util.Collection;

import org.colega.modelo.entidades.Colega;

public interface GestionColega {
	void nuevoColega(Colega colega) throws SQLException;

	
	void borrarColega(int isbn) throws SQLException;

	
	void modificarColega(Colega colega) throws SQLException;
	
	Collection<Colega> todosMisColegas() throws SQLException;
}
