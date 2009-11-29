package upc.view;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import upc.control.ControlData;
import upc.control.ControlLingo;
import upc.data.Parameters;

/**
 *
 * @author pablo.sierralta
 */
public class DialogShowReport extends javax.swing.JDialog {

    private ControlLingo controlLingo = null;
    private ControlData controlData = null;
    private TableModelVector modelResultado = null;
    private final String[] headerResultado = {"DMU", "Puntaje"};


    /** Creates new form DialogShowReport */
    public DialogShowReport(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        modelResultado = new TableModelVector(headerResultado, new Vector());
        controlLingo = new ControlLingo();
        controlData = new ControlData();
        initComponents();
        getRootPane().setDefaultButton(btnReport);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        btnReport1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(upc.view.LingoApplication.class).getContext().getResourceMap(DialogShowReport.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(upc.view.LingoApplication.class).getContext().getActionMap(DialogShowReport.class, this);
        btnClose.setAction(actionMap.get("returnFrame")); // NOI18N
        btnClose.setName("btnClose"); // NOI18N
        btnClose.setPreferredSize(new java.awt.Dimension(90, 23));

        btnReport.setAction(actionMap.get("actionShowUnidadReport")); // NOI18N
        btnReport.setName("btnReport"); // NOI18N
        btnReport.setPreferredSize(new java.awt.Dimension(90, 23));

        btnReport1.setAction(actionMap.get("actionExportUnidadReport")); // NOI18N
        btnReport1.setText(resourceMap.getString("btnReport1.text")); // NOI18N
        btnReport1.setName("btnReport1"); // NOI18N
        btnReport1.setPreferredSize(new java.awt.Dimension(90, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReport1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReport1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(modelResultado);
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

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
    public void actionShowUnidadReport() {
        controlLingo.executeLingoFile(
                Parameters.getProperty("lingoFile.Access.path"),
                Parameters.getProperty("lingoLog.path"));
        try {
            Thread.sleep(100);
            System.out.println("waiting 200 ms");
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
        Vector resultado = controlData.getResultadoArray();
        modelResultado.addRow((Vector)resultado.get(0));
        modelResultado.setDataVector(resultado);
        System.out.println("setDataVector");
    }

    @Action
    public void actionExportUnidadReport() {
        controlLingo.executeLingoFile(
                Parameters.getProperty("lingoFileExcel.path"),
                Parameters.getProperty("lingoLog.path"));
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnReport1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
