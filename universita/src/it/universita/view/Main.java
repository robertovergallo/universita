package it.universita.view;

import it.universita.business.SessionManager;
import it.universita.business.UtenteBusiness;
import it.universita.dbinterface.DbConnection;
import it.universita.model.Docente;
import it.universita.model.Persona;
import it.universita.model.Studente;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by roberto on 28/11/2017.
 */
public class Main {

    public static void main(String args[]) {


        LoginFrame loginFrame = new LoginFrame();
        SessionManager.getInstance().getSession().put("finestra_login", loginFrame);




        /*
        System.out.println("Ci sono!");

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM studente");

        System.out.println("Numero di righe: " + risultato.size());

        for(int i=0;i<risultato.size();i++) {
            String[] riga = risultato.get(i);
            System.out.println("ID PERSONA: "+riga[0]);
            System.out.println("MATRICOLA: "+riga[1]);
            System.out.println("-------------------");
        }

        */

    }
}
