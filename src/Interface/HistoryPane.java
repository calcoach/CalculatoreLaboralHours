/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import horaslaborales.AddRegistry;
import horaslaborales.ClosedWindowEvent;
import horaslaborales.ManagingRegistry;
import horaslaborales.Sesion;
import java.io.File;
import java.util.Vector;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class HistoryPane extends javax.swing.JPanel {

    /**
     * Creates new form HistoryPane
     */
    File file;
    Sesion user;
    ManagingRegistry managing;

    public HistoryPane(Sesion user ) { 
        initComponents();
        this.user = user;
        managing = new ManagingRegistry(user);

        managing.chargueYearRegistries(selectYear);
        int m = selectYear.getItemCount();
        selectYear.setSelectedIndex(m - 1);
        managing.chargueMonthRegistries(this.selectMonth, jTable1, this.selectYear);
        int n = selectMonth.getItemCount();
        selectMonth.setSelectedIndex(n - 1);
        this.jTable1.setVisible(true);
        

    }

    private void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private Scene createScene() {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ALICEBLUE);

        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showSaveDialog(scene.getWindow());
        if (file != null) {

            managing.saveRegistryToExcel(jTable1, file.getAbsolutePath());
        }

        return (scene);
    }

    public void updateTable() {

        System.out.println(selectYear.getItemCount());
        managing.chargueYearRegistries(selectYear);
        int m = selectYear.getItemCount();

        selectYear.setSelectedIndex(m - 1);
        java.awt.event.ActionEvent evt = null;
        selectMonthActionPerformed(evt);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        selectMonth = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        selectYear = new javax.swing.JComboBox<>();
        AddRegistry = new javax.swing.JButton();
        editRegistry = new javax.swing.JButton();
        deleteRegistry = new javax.swing.JButton();
        exportToExcel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Horas Ordinarias", "Horas R. Nocturno", "H. Extras Diurno", "H. Extras Nocturno", "Sueldo dia"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 840, 290));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Seleccionar mes");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 130, -1));

        selectMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMonthActionPerformed(evt);
            }
        });
        add(selectMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Seleccionar año");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 110, -1));

        selectYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectYearActionPerformed(evt);
            }
        });
        add(selectYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 90, 30));

        AddRegistry.setBackground(new java.awt.Color(0, 204, 51));
        AddRegistry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Plus_Math_24px.png"))); // NOI18N
        AddRegistry.setText("Agregar Registro");
        AddRegistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRegistryActionPerformed(evt);
            }
        });
        add(AddRegistry, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 160, 40));

        editRegistry.setBackground(new java.awt.Color(0, 204, 51));
        editRegistry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Pencil_24px.png"))); // NOI18N
        editRegistry.setText("Editar Registro");
        editRegistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRegistryActionPerformed(evt);
            }
        });
        add(editRegistry, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 150, 40));

        deleteRegistry.setBackground(new java.awt.Color(0, 204, 51));
        deleteRegistry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Trash_Can_24px_1.png"))); // NOI18N
        deleteRegistry.setText("Eliminar Registro");
        deleteRegistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRegistryActionPerformed(evt);
            }
        });
        add(deleteRegistry, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 160, 40));

        exportToExcel.setBackground(new java.awt.Color(0, 204, 51));
        exportToExcel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        exportToExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Export_24px_1.png"))); // NOI18N
        exportToExcel.setText("Exportar a Excel");
        exportToExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportToExcelActionPerformed(evt);
            }
        });
        add(exportToExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 160, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void selectMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectMonthActionPerformed
        // TODO add your handling code here:
        managing.chargueMonthRegistries(selectMonth, jTable1, selectYear);
    }//GEN-LAST:event_selectMonthActionPerformed

    private void selectYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectYearActionPerformed
        // TODO add your handling code here:
        selectMonth.removeAllItems();
        managing.chargueMonthRegistries(selectMonth, jTable1, selectYear);

    }//GEN-LAST:event_selectYearActionPerformed

    private void AddRegistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRegistryActionPerformed
        // TODO add your handling code here:
        AddRegistry window = new AddRegistry(this.user);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.addWindowListener(new ClosedWindowEvent(this));
    }//GEN-LAST:event_AddRegistryActionPerformed

    private void editRegistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRegistryActionPerformed
        // TODO add your handling code here:
        int rowSelected = jTable1.getSelectedRow();

        if (rowSelected != -1) {
            DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
            Vector v = (Vector) m.getDataVector().get(rowSelected);
            AddRegistry editRegistry = new AddRegistry(managing.searchRegistry((String) v.get(0)), user);
            editRegistry.setVisible(true);
            editRegistry.addWindowListener(new ClosedWindowEvent(this));
            editRegistry.setLocationRelativeTo(null);

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el Registro en la tabla");
        }
    }//GEN-LAST:event_editRegistryActionPerformed

    private void deleteRegistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRegistryActionPerformed
        // TODO add your handling code here:
        int rowSelected = jTable1.getSelectedRow();

        if (rowSelected != -1) {
            DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
            Vector v = (Vector) m.getDataVector().get(rowSelected);
            managing.deleteRegistry((String) v.get(0));
            this.updateTable();

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el Registro en la tabla");
        }
    }//GEN-LAST:event_deleteRegistryActionPerformed

    private void exportToExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportToExcelActionPerformed
        // TODO add your handling code here:
        final JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0));
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });

        //show();
        //
    }//GEN-LAST:event_exportToExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddRegistry;
    private javax.swing.JButton deleteRegistry;
    private javax.swing.JButton editRegistry;
    private javax.swing.JButton exportToExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> selectMonth;
    private javax.swing.JComboBox<String> selectYear;
    // End of variables declaration//GEN-END:variables
}
