package org.colega.modelo.negocio;

import java.sql.SQLException;
import java.util.Collection;
import org.colega.modelo.entidades.Colega;
import org.colega.persistencia.ColegaDao;

public class GestionColegaImpl implements GestionColega {

	private ColegaDao colegaDao;

	public GestionColegaImpl(ColegaDao colegaDao) {
		super();
		this.colegaDao = colegaDao;
	}

	@Override
	public void nuevoColega(Colega colega) throws SQLException {
		colegaDao.nuevoColega(colega);

	}

	@Override
	public void borrarColega(int id) throws SQLException {
		colegaDao.borrarColega(id);

	}

	@Override
	public void modificarColega(Colega colega) throws SQLException {
		colegaDao.modificarColega(colega);

	}

	@Override
	public Collection<Colega> todosMisColegas() throws SQLException {
		Collection<Colega> listaColega = colegaDao.todosLosColegas();
		return listaColega;
	}

}
