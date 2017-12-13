package it.universita.actionListeners;

import it.universita.business.SessionManager;
import it.universita.business.UtenteBusiness;
import it.universita.model.Docente;
import it.universita.model.Persona;
import it.universita.model.Studente;
import it.universita.view.LoginFrame;
import it.universita.view.StudenteFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by roberto on 06/12/2017.
 */
public class LoginListener implements ActionListener {

    private LoginFrame finestra;

    public LoginListener(LoginFrame finestra) {
        this.finestra = finestra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Evento catturato!");

        if("RANDOM_MENU_ITEM".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null,"Hai premuto la voce di menu random");
        }
        if(e.getSource() instanceof JButton
                || e.getSource() instanceof JTextField
                || e.getSource() instanceof  JPasswordField) {

            //String username = "mario.rossi";
            //byte[] password = "Passw0rd1".getBytes();

            String username = finestra.getTxtUsername().getText();
            byte[] password = new String(finestra.getTxtPassword().getPassword()).getBytes();

            Persona p = UtenteBusiness.getInstance().login(username, password);

            if (p != null) {
                System.out.println("LOGIN OK!");

                if (p instanceof Docente) {
                    //apriremo la view del docente
                    System.out.println("Benvenuto docente " + p.getNome() + " " + p.getCognome() + "!");
                    Docente d = (Docente) p;
                    System.out.println("FASCIA: " + d.getFascia());
                    JOptionPane.showMessageDialog(null,"Benvenuto docente " + p.getNome() + " " + p.getCognome() + "!");
                } else if (p instanceof Studente) {
                    //apriremo la view dello studente
                    System.out.println("Benvenuto studente " + p.getNome() + " " + p.getCognome() + "!");
                    Studente s = (Studente) p;
                    System.out.println("MATRICOLA: " + s.getMatricola());
                    //JOptionPane.showMessageDialog(null,"Benvenuto studente " + p.getNome() + " " + p.getCognome() + "!");

                    SessionManager.getInstance().getSession().put("studente", s);
                    new StudenteFrame();
                    finestra.setVisible(false);
                }

            } else {
                System.out.println("Il login non è andato a buon fine...");
                JOptionPane.showMessageDialog(null,"Il login non è andato a buon fine...");
            }
        }
    }
}
