package it.universita.view;

import it.universita.model.Esame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by roberto on 12/12/2017.
 */
public class EsamiSostenutiTableModel extends AbstractTableModel {

    private ArrayList<Esame> esamiSostenuti;
    private String columnNames[] = {"Corso","Voto","Lode","Data"};

    public EsamiSostenutiTableModel(ArrayList<Esame> esamiSostenuti) {
        this.esamiSostenuti = esamiSostenuti;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        if(columnIndex == 2) return Boolean.class;
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return esamiSostenuti.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Esame e = esamiSostenuti.get(rowIndex);

        switch(columnIndex) {
            case 0: return e.getCorso().getTitolo();
            case 1: return e.getVoto();
            case 2: return e.isLode();
            case 3: return e.getDate();
            default: return null;
        }
    }
}
