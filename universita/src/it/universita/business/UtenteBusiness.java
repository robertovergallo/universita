package it.universita.business;

import it.universita.dao.mysql.PersonaDAO;
import it.universita.model.Persona;

/**
 * Created by roberto on 29/11/2017.
 */
public class UtenteBusiness {

    private static UtenteBusiness instance;

    public static UtenteBusiness getInstance() {
        if(instance == null)
            instance = new UtenteBusiness();
        return instance;
    }

    public Persona login(String username, byte[] password) {

        Persona p = PersonaDAO.getInstance().findUserByUsernameAndPassword(username, password);

        return p;
    }
}
