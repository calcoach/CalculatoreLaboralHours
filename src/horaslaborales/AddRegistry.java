/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class AddRegistry extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    Registry registry;

    public AddRegistry() {
        initComponents();
        ManagingRegistry.getSalary(jTextField1, "prueba");
        //Edit Table contents
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Tipo Hora", "Cantidad", "Costo"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });

    }

    public AddRegistry(Registry reg) {
        initComponents();
        ManagingRegistry.getSalary(jTextField1, "prueba");
        //Edit Table contents
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Tipo Hora", "Cantidad", "Costo"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });

        this.registry = reg;
        preChargedData();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void preChargedData() {
        if (registry != null) {
            this.jDateChooser1.setDate(registry.getStartDay());
            jDateChooser1.setSelectableDateRange(registry.getStartDay(), registry.getStartDay());
            
        }
    }

    private void showData(Calculadora calc) {

        if (jTable1.getSize().height > 0) {

        }

        double[] costo = calc.calcularSueldo();
        calc.contT = 0;
        int[] horas = calc.calcularHoras();
        DefaultTableModel table = (DefaultTableModel) this.jTable1.getModel();
        table.setNumRows(0);
        table.addRow(new Object[]{"Ordinaria", horas[0], costo[0]});
        table.addRow(new Object[]{"R.Nocturna", horas[1], costo[1]});
        table.addRow(new Object[]{"Extra Diurna", horas[2], costo[2]});
        table.addRow(new Object[]{"Extra Nocturna", horas[3], costo[3]});
        table.addRow(new Object[]{"TOTAL", horas[4], costo[4]});
        
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        selectTypeDay = new javax.swing.JComboBox<>();
        saveRegistry = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(171, 235, 198));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 120, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Sueldo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 70, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Fecha/Hora Fin");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 160, 30));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 24, 1));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 50, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Fecha/Hora Inicio");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 170, 30));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 24, 1));
        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 50, 30));

        jTable1.setBackground(new java.awt.Color(130, 224, 170));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(171, 235, 198));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, 110));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tipo de dia");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        jButton1.setBackground(new java.awt.Color(40, 180, 99));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Calculator_24px.png"))); // NOI18N
        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 120, 40));

        jDateChooser1.setBackground(new java.awt.Color(171, 235, 198));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 110, 30));

        jDateChooser2.setBackground(new java.awt.Color(171, 235, 198));
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 110, 30));

        selectTypeDay.setBackground(new java.awt.Color(171, 235, 198));
        selectTypeDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes a Sabado", "Dominical Festivo", "Inicia dia Ordinario Termina Dominical/Festivo", "Inicia Dominical Festivo Termina Dia Ordinario" }));
        selectTypeDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTypeDayActionPerformed(evt);
            }
        });
        getContentPane().add(selectTypeDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 270, 30));

        saveRegistry.setBackground(new java.awt.Color(40, 180, 99));
        saveRegistry.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        saveRegistry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Save_24px.png"))); // NOI18N
        saveRegistry.setText("Guardar en Registro");
        saveRegistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRegistryActionPerformed(evt);
            }
        });
        getContentPane().add(saveRegistry, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, -1, 40));

        jButton2.setBackground(new java.awt.Color(40, 180, 99));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Cancel_24px.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 130, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/maxresdefault.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Calculadora calc;

        try {

            if (!this.jTextField1.getText().isEmpty()) {

                if (((int) this.jSpinner1.getValue() != 0 | (int) this.jSpinner2.getValue() != 0)
                        & (this.jSpinner1.getValue() != this.jSpinner2.getValue())) {

                    calc = new Calculadora((int) this.jSpinner1.getValue(), (int) jSpinner2.getValue(),
                            Integer.valueOf(this.jTextField1.getText()));

                    if (this.selectTypeDay.getSelectedItem() != null) {
                        calc.setDia(selectTypeDay.getSelectedIndex() + 1);

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Selecccione el dia");
                        return;
                    }

                    showData(calc);

                } else {
                    JOptionPane.showMessageDialog(null, "Escriba un rango de horas valido : (1-24)");
                }
            }

        } catch (java.lang.NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        /* ActionEvent ev = null;
        if((this.jSpinner2.getValue()!=null)&((int)jSpinner2.getValue()!=0)) {
            jButton1ActionPerformed(ev);
        }*/


    }//GEN-LAST:event_jSpinner1StateChanged

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        /* ActionEvent ev = null;
        this.jButton1ActionPerformed(ev);*/
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
        // TODO add your handling code here:
        ActionEvent ev = null;
        //this.jButton1ActionPerformed(ev);
    }//GEN-LAST:event_jSpinner2StateChanged

    private void selectTypeDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTypeDayActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_selectTypeDayActionPerformed

    private void saveRegistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRegistryActionPerformed
        // TODO add your handling code here:
        Calculadora calc = new Calculadora((int) this.jSpinner1.getValue(), (int) jSpinner2.getValue(),
                Integer.valueOf(this.jTextField1.getText()));
        calc.setDia(selectTypeDay.getSelectedIndex() + 1);
        if (registry == null) {

            boolean h = ManagingRegistry.saveRegistry(this.jDateChooser1, jSpinner1, this.jDateChooser2, jSpinner2, calc);
            if(h)
                dispose();
        } else {
            
            ManagingRegistry.updateRegistry(jDateChooser1, jSpinner1, jDateChooser2, jSpinner2, calc);
        }
         ManagingRegistry.updateLastSalary(jTextField1, "prueba");
        
    }//GEN-LAST:event_saveRegistryActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddRegistry.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddRegistry.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddRegistry.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddRegistry.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddRegistry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton saveRegistry;
    private javax.swing.JComboBox<String> selectTypeDay;
    // End of variables declaration//GEN-END:variables
}