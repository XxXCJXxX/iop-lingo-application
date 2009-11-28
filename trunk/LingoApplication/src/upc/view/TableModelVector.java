package upc.view;

import java.util.Vector;
import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pablo.sierralta
 */
public class TableModelVector extends AbstractTableModel {

    private Vector dataVector;
    private String[] columnIdentifiers;
    private boolean editable = false;
    private boolean[] colEditables;

    TableModelVector() {
        super();
    }

    TableModelVector(String[] columnIdentifiers, Vector dataVector) {
        this.columnIdentifiers = columnIdentifiers;
        this.dataVector = dataVector;
    }

    public Object getValueAt(int row, int col) {
        return ((Vector) dataVector.get(row)).get(col);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (colEditables != null) {
            return colEditables[columnIndex];
        } else {
            return editable;
        }
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public void setColEditables(boolean[] colEditables) {
        this.colEditables = colEditables;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    public void setColumnIdentifiers(String[] columnIdentifiers) {
        this.columnIdentifiers = columnIdentifiers;
    }

    public String[] getColumnIdentifiers() {
        return columnIdentifiers;
    }

    public void setDataVector(Vector dataVector) {
        this.dataVector = dataVector;
    }

    public Vector getDataVector() {
        return dataVector;
    }

    public int getColumnCount() {
        return columnIdentifiers.length;
    }

    @Override
    public String getColumnName(int col) {
        return "" + columnIdentifiers[col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public int getRowCount() {
        return dataVector.size();
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    @Override
    public TableModelListener[] getTableModelListeners() {
        return super.getTableModelListeners();
    }
}
