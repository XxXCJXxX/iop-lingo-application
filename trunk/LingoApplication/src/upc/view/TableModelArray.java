package upc.view;

import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pablo.sierralta
 */
public class TableModelArray extends AbstractTableModel {

    private String[] columnNames = null;
    private Object[][] data = null;
    private boolean editable = false;
    private boolean[] colEditables;

    public TableModelArray() {
        super();
    }

    public TableModelArray(String[] columnNames, Object[][] data) {
        this.columnNames = columnNames;
        this.data = data;
    }

    public TableModelArray(String[] columnNames, Object[][] data, boolean editable) {
        this.columnNames = columnNames;
        this.data = data;
        this.editable = editable;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (colEditables != null) {
            return colEditables[columnIndex];
        } else {
            return editable;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public void setColEditables(boolean[] colEditables) {
        this.colEditables = colEditables;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
}
