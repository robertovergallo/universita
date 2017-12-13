package it.universita.dao.mysql;

import it.universita.dao.interfaces.IPersonaDAO;
import it.universita.dbinterface.DbConnection;
import it.universita.model.Docente;
import it.universita.model.Persona;
import it.universita.model.Studente;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by roberto on 05/12/2017.
 */
public class PersonaDAO implements IPersonaDAO {

    private static PersonaDAO instance;

    public static PersonaDAO getInstance() {
        if(instance == null)
            instance = new PersonaDAO();
        return instance;
    }

    @Override
    public Persona findById(int id) {
        return null;
    }

    @Override
    public ArrayList<Persona> findAll() {
        return null;
    }

    @Override
    public Persona findUserByUsernameAndPassword(String username, byte[] password) {

        Persona p = null;


        String query = "SELECT * FROM persona WHERE " +
                "username = '"+username+"' AND " +
                "password = '"+new String(password)+"'";
        ArrayList<String[]> ris = DbConnection.getInstance().eseguiQuery(query);

        if(ris.size() != 0) {
            //esiste un utente !!
            String[] utente = ris.get(0);
            int id = Integer.parseInt(utente[0]);

            //vediamo se è un docente
            Docente d = DocenteDAO.getInstance().findById(id);
            if(d==null) {
                //allora sarà uno studente?...
                Studente s = StudenteDAO.getInstance().findById(id);
                if(s!=null) {
                    p=s;
                }
            }
            else {
                p=d;
            }
            if(p!=null) {
                p.setNome(utente[1]);
                p.setCognome(utente[2]);
            }

        }

        return p;
    }
}
