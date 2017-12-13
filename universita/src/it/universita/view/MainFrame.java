package it.universita.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by roberto on 11/12/2017.
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        super("Esempio tabella");

        Object[][] data = new Object[3][3];
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

        setLayout(new BorderLayout());
        TableModel tm = new DefaultTableModel(data, columnNames);

        ArrayList<MyTableModel.MyTableRow> mdl = new ArrayList<MyTableModel.MyTableRow>();
        MyTableModel mtm = new MyTableModel(mdl);
        mdl.add(mtm.new MyTableRow(0,"Roberto",true));
        mdl.add(mtm.new MyTableRow(1,"Daniele",false));
        mdl.add(mtm.new MyTableRow(2,"Giovanni",true));
        JTable table = new JTable(mtm);
        //table.setRowSelectionAllowed(false);

        getContentPane().add(new JLabel("Benvenuto"), BorderLayout.NORTH);
        getContentPane().add(table, BorderLayout.CENTER);
        JButton logout = new JButton("Logout");
        getContentPane().add(logout, BorderLayout.SOUTH);
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] rws = table.getSelectedRows();
                ArrayList<MyTableModel.MyTableRow> mdl2 = (ArrayList<MyTableModel.MyTableRow>) table.getModel();
            }
        });

    }
}
