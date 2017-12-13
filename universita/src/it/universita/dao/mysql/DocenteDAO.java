package it.universita.dao.mysql;

import it.universita.dao.interfaces.IDocenteDAO;
import it.universita.dbinterface.DbConnection;
import it.universita.model.Docente;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by roberto on 29/11/2017.
 * Qui dentro mettiamo tutte le query che
 * riguardano la tabella studente
 */
public class DocenteDAO implements IDocenteDAO {

    //singleton design pattern
    private static DocenteDAO instance;

    public static DocenteDAO getInstance() {
        if(instance == null)
            instance = new DocenteDAO();
        return instance;
    }

    public boolean setFascia(Docente d, int fascia) {

        return DbConnection.getInstance().eseguiAggiornamento("UPDATE docente SET fascia = "+fascia+" " +
                                                                "WHERE persona_idpersona = "+d.getIdPersona());
    }

    public Docente findById(int id) {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM docente WHERE persona_idpersona="+id);

        if(risultato.size() == 0) return null;

        Docente d = new Docente();

        String[] riga = risultato.get(0);
        d.setIdPersona(Integer.parseInt(riga[0]));
        d.setFascia(Integer.parseInt(riga[1]));

        return d;

    }

    public ArrayList<Docente> findAll() {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM docente");

        ArrayList<Docente> listaDocent = new ArrayList<Docente>();

        Iterator<String[]> i = risultato.iterator();

        while(i.hasNext()) {
            String[] riga = i.next();
            Docente d = new Docente();
            d.setIdPersona(Integer.parseInt(riga[0]));
            d.setFascia(Integer.parseInt(riga[1]));
            listaDocent.add(d);
        }

        return listaDocent;

    }

}
