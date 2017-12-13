package it.universita.dao.interfaces;

import it.universita.model.Docente;

/**
 * Created by roberto on 29/11/2017.
 */
public interface IDocenteDAO extends IBaseDAO<Docente> {

    boolean setFascia(Docente d, int fascia);
}
