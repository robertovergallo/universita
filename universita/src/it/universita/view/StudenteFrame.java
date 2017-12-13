package it.universita.view;

import it.universita.business.SessionManager;
import it.universita.model.Studente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by roberto on 12/12/2017.
 */
public class StudenteFrame extends JFrame {

    public StudenteFrame() {
        super("Finestra studente");
        getContentPane().setLayout(new BorderLayout());

        Studente s = (Studente)SessionManager.getInstance().getSession().get("studente");


        //getContentPane().add(new JLabel("area di lavoro"), BorderLayout.CENTER);

        String[][] data = new String[3][3];
        data[0][0] = "a";
        data[0][1] = "b";
        data[0][2] = "c";
        data[1][0] = "d";
        data[1][1] = "e";
        data[1][2] = "f";
        data[2][0] = "g";
        data[2][1] = "h";
        data[2][2] = "i";

        String[] columnNames = new String[]{"nome", "email", "newsletter"};

        TableModel tm = new DefaultTableModel(data, columnNames);

        EsamiSostenutiTableModel estm = new EsamiSostenutiTableModel(s.getEsamiSostenuti());

        JTable esamiSostenuti = new JTable(estm);
        getContentPane().add(esamiSostenuti, BorderLayout.CENTER);


        getContentPane().add(new JLabel("BENVENUTO "+s.getNome()+" "+s.getCognome()+" (matr. " + s.getMatricola()+")"), BorderLayout.NORTH);
        JButton btnLogout = new JButton("Logout");
        getContentPane().add(btnLogout, BorderLayout.SOUTH);

        StudenteFrame _this = this;
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int[] selez = esamiSostenuti.getSelectedRows();
                SessionManager.getInstance().getSession().put("studente", null);
                _this.setVisible(false);
                LoginFrame finestraLogin = (LoginFrame)SessionManager.getInstance().getSession().get("finestra_login");
                finestraLogin.setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024,768);
        setVisible(true);
    }
}
