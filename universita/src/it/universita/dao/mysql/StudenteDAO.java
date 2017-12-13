package it.universita.dao.mysql;

import it.universita.dao.interfaces.IBaseDAO;
import it.universita.dbinterface.DbConnection;
import it.universita.model.Corso;
import it.universita.model.Esame;
import it.universita.model.Studente;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by roberto on 29/11/2017.
 * Qui dentro mettiamo tutte le query che
 * riguardano la tabella studente
 */
public class StudenteDAO implements IBaseDAO<Studente>{

    //singleton design pattern
    private static StudenteDAO instance;

    public static StudenteDAO getInstance() {
        if(instance == null)
            instance = new StudenteDAO();
        return instance;
    }

    @Override
    public Studente findById(int id) {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM studente WHERE persona_idpersona="+id);

        if(risultato.size() == 0) return null;

        Studente s = new Studente();

        String[] riga = risultato.get(0);
        s.setIdPersona(Integer.parseInt(riga[0]));
        s.setMatricola(riga[1]);

        ArrayList<Esame> esamiSostenuti = new ArrayList<Esame>();

        ArrayList<String[]> risultato2 =  DbConnection.getInstance().eseguiQuery("SELECT C.titolo, E.voto, E.lode, E.data " +
                "FROM esame as E " +
                "JOIN corso as C " +
                "on E.corso_idcorso = C.idcorso " +
                "WHERE E.studente_persona_idpersona="+id);

        if(risultato2.size() != 0) {
            Iterator<String[]> i = risultato2.iterator();
            while(i.hasNext()) {
                String[] riga2 = i.next();
                Esame e = new Esame();
                Corso c = new Corso();
                c.setTitolo(riga2[0]);
                e.setCorso(c);
                e.setVoto(Integer.parseInt(riga2[1]));
                e.setLode("1".equals(riga2[2]));
                e.setDate(riga2[3]);
                esamiSostenuti.add(e);
            }
        }

        s.setEsamiSostenuti(esamiSostenuti);

        return s;

    }

    @Override
    public ArrayList<Studente> findAll() {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM studente");

        ArrayList<Studente> listaStudenti = new ArrayList<Studente>();

        Iterator<String[]> i = risultato.iterator();

        while(i.hasNext()) {
            String[] riga = i.next();
            Studente s = new Studente();
            s.setIdPersona(Integer.parseInt(riga[0]));
            s.setMatricola(riga[1]);
            listaStudenti.add(s);
        }

        return listaStudenti;

    }

}
