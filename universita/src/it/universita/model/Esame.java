package it.universita.model;

/**
 * Created by roberto on 12/12/2017.
 */
public class Esame {

    private int voto;
    private boolean lode;
    private String date;
    private Corso corso;
    private Boolean selezionato;

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public boolean isLode() {
        return lode;
    }

    public void setLode(boolean lode) {
        this.lode = lode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }
}
