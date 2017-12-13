package it.universita.model;

/**
 * Created by roberto on 29/11/2017.
 */
public class Docente extends Persona{

    private int idPersona;
    private int fascia;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getFascia() {
        return fascia;
    }

    public void setFascia(int fascia) {
        this.fascia = fascia;
    }
}
