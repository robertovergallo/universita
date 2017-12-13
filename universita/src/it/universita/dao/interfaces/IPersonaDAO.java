package it.universita.dao.interfaces;

import it.universita.model.Persona;

/**
 * Created by roberto on 05/12/2017.
 */
public interface IPersonaDAO extends IBaseDAO<Persona> {

    Persona findUserByUsernameAndPassword(String username, byte[] password);
}
