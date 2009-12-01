package upc.view;

import java.util.Vector;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;
import upc.control.ControlData;
import upc.control.ParametroUnidad;
import upc.data.Unidad;

/**
 *
 * @author pablo.sierralta
 */
public class DialogManageUnidad extends javax.swing.JDialog {

    private ControlData controlData = null;
    private TableModelVector modelUnidad = null;
    private final String[] headerUnidad = {"Nombre", "Abreviatura", "Input 1", "Input 2", "Output 1", "Output 2"};

    /** Creates new form DialogManageUnidad */
    public DialogManageUnidad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        controlData = new ControlData();
        modelUnidad = new TableModelVector(headerUnidad, new Vector());
        modelUnidad.setEditable(true);

        loadUnidades();
        initComponents();
    }

    private void loadUnidades() {
        //Vector lstUnidad = controlData.getUnidadArray();

        Vector lstUnidad = controlData.getArregloUnidadParametro();

        modelUnidad.setDataVector(lstUnidad);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUnidades = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(upc.view.LingoApplication.class).getContext().getResourceMap(DialogManageUnidad.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tablaUnidades.setModel(modelUnidad);
        tablaUnidades.setName("tablaUnidades"); // NOI18N
        jScrollPane1.setViewportView(tablaUnidades);

        jPanel1.setName("jPanel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(upc.view.LingoApplication.class).getContext().getActionMap(DialogManageUnidad.class, this);
        btnClose.setAction(actionMap.get("returnFrame")); // NOI18N
        btnClose.setName("btnClose"); // NOI18N
        btnClose.setPreferredSize(new java.awt.Dimension(90, 23));

        btnSave.setAction(actionMap.get("actionSaveUnidad")); // NOI18N
        btnSave.setName("btnSave"); // NOI18N
        btnSave.setPreferredSize(new java.awt.Dimension(90, 23));

        btnDelete.setAction(actionMap.get("actionDeleteUnidad")); // NOI18N
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.setPreferredSize(new java.awt.Dimension(90, 23));

        btnSave1.setAction(actionMap.get("actionAddUnidad")); // NOI18N
        btnSave1.setText(resourceMap.getString("btnSave1.text")); // NOI18N
        btnSave1.setName("btnSave1"); // NOI18N
        btnSave1.setPreferredSize(new java.awt.Dimension(90, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void actionAddUnidad() {
        Vector data = new Vector(modelUnidad.getColumnCount());
        data.add("");
        data.add("");
        data.add("0");
        data.add("0");
        data.add("0");
        data.add("0");
        modelUnidad.addRow(data);
    }

    @Action
    public void actionSaveUnidad() {
        Vector lstTable = modelUnidad.getDataVector();
        Vector<ParametroUnidad> lstParametroUnidad = new Vector<ParametroUnidad>(lstTable.size());
        Vector<Unidad> lstUnidad = new Vector<Unidad>(lstTable.size());

        boolean validate = true;

        for (int i = 0; i < lstTable.size(); i++) {
            Vector data = modelUnidad.getSelectedRow(i);
            String nombre = String.valueOf(data.get(0));
            String abrev = String.valueOf(data.get(1));
            Double inputEmpleado = Double.valueOf(String.valueOf(data.get(2)));
            Double inputMercados = Double.valueOf(String.valueOf(data.get(3)));
            Double outputVentasPersonas = Double.valueOf(String.valueOf(data.get(4)));
            Double outputVentasNegocios = Double.valueOf(String.valueOf(data.get(5)));

            if (nombre.isEmpty() || abrev.isEmpty() || inputEmpleado.isNaN() || inputMercados.isNaN() || outputVentasPersonas.isNaN() || outputVentasNegocios.isNaN()) {
                JOptionPane.showMessageDialog(this, "Los datos de la fila " + i + " deben de estar completos", "Error de datos de Tabla", JOptionPane.ERROR_MESSAGE);
                validate = false;
            } else {
                ParametroUnidad beanParametroUnidad = new ParametroUnidad(nombre, abrev, inputEmpleado, inputMercados, outputVentasPersonas, outputVentasNegocios);
                lstParametroUnidad.add(beanParametroUnidad);
                Unidad beanUnidad = new Unidad(nombre, abrev);
                lstUnidad.add(beanUnidad);
            }
        }

        if (validate == true) {
            controlData.limpiarParametroUnidad();
            controlData.guardarParametroUnidad(lstParametroUnidad);
            controlData.limpiarUnidad();
            controlData.guardarUnidad(lstUnidad);
            controlData.crearEspacioResultado(modelUnidad.getRowCount());
            JOptionPane.showMessageDialog(this, "Los datos guardados correctamente", "Confirmación de cambios", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Action
    public void actionCloseDialog() {
        this.dispose();
    }

    @Action
    public void actionDeleteUnidad() {
        modelUnidad.removeRow(tablaUnidades.getSelectedRow());
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUnidades;
    // End of variables declaration//GEN-END:variables
}
