/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Dates.CalendarString;
import Dates.CompareDates;
import Inputs.VerifiedAddRegistry;
import Inputs.VerifiedAddVacationsInability;
import horaslaborales.IOPanel;
import horaslaborales.ManagingDataUser;
import horaslaborales.InterfaceHistory;
import models.Registry;
import horaslaborales.Sesion;
import horaslaborales.VacationsInabilityCalculator;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public final class InabilityPane extends javax.swing.JPanel implements IOPanel {

    /**
     * Creates new form RegistryPane
     */
    Registry registry;
    InterfaceHistory managing;
    ManagingDataUser managingData;
    Sesion user;
    VerifiedAddVacationsInability verifiedRegistry;
    AddRegistry wregistry;

    public InabilityPane(Sesion user, AddRegistry wregistry) {
        this.user = user;
        this.wregistry = wregistry;
        initComponents();
        managing = new InterfaceHistory(user);
        managingData = new ManagingDataUser(user);
        preConfiguredWindow();

    }

    public InabilityPane(Registry reg, Sesion user, AddRegistry wregistry) {
        initComponents();
        this.user = user;
        this.registry = reg;
        this.wregistry = wregistry;

        managing = new InterfaceHistory(user);
        managingData = new ManagingDataUser(user);

        preConfiguredWindow();
        preChargedData();
    }

    @Override
    public void preConfiguredWindow() {

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Inicio", "Fin", "Valor"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });

        verifiedRegistry = new VerifiedAddVacationsInability(date1, date2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @Override
    public void preChargedData() {
        /*if (registry != null) {
            this.date1.setDate(registry.getStartDay());
            date1.setSelectableDateRange(registry.getStartDay(), registry.getStartDay());
 
            date2.setEnabled(true);
            verifiedRegistry.updateDates();
            
        }*/
    }

    public void showData(VacationsInabilityCalculator cal) {

        if (jTable1.getSize().height > 0) {

            jTable1.removeAll();
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{new CalendarString(date1.getCalendar()).getStringDate(),
            new CalendarString(date2.getCalendar()).getStringDate(), cal.getRevenue()});
        jTable1.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salary = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        calculate = new javax.swing.JButton();
        date1 = new com.toedter.calendar.JDateChooser();
        date2 = new com.toedter.calendar.JDateChooser();
        saveRegistry = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        startToday = new javax.swing.JCheckBox();
        finishToday = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salary.setEditable(false);
        salary.setBackground(new java.awt.Color(171, 235, 198));
        salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryActionPerformed(evt);
            }
        });
        salary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                salaryKeyPressed(evt);
            }
        });
        add(salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 110, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Sueldo");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 70, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Fecha Fin");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 160, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Fecha Inicio");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 170, 30));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 480, 110));

        calculate.setBackground(new java.awt.Color(0, 204, 51));
        calculate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        calculate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Calculator_24px.png"))); // NOI18N
        calculate.setText("Verificar");
        calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }
        });
        add(calculate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 120, 40));

        date1.setBackground(new java.awt.Color(171, 235, 198));
        date1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date1PropertyChange(evt);
            }
        });
        add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 110, 30));

        date2.setBackground(new java.awt.Color(171, 235, 198));
        date2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date2PropertyChange(evt);
            }
        });
        add(date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 110, 30));

        saveRegistry.setBackground(new java.awt.Color(0, 204, 51));
        saveRegistry.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        saveRegistry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Save_24px.png"))); // NOI18N
        saveRegistry.setText("Guardar en Registro");
        saveRegistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRegistryActionPerformed(evt);
            }
        });
        add(saveRegistry, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, -1, 40));

        cancel.setBackground(new java.awt.Color(0, 204, 51));
        cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Cancel_24px.png"))); // NOI18N
        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 130, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("$");
        jLabel6.setAlignmentX(1.0F);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 30, 30));

        startToday.setText("Hoy");
        startToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTodayActionPerformed(evt);
            }
        });
        add(startToday, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        finishToday.setText("Hoy");
        finishToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishTodayActionPerformed(evt);
            }
        });
        add(finishToday, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void salaryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salaryKeyPressed

    }//GEN-LAST:event_salaryKeyPressed

    private void calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateActionPerformed
        // TODO add your handling code here:

        VacationsInabilityCalculator calc;
        jTable1.removeAll();
        jTable1.updateUI();
        // verifiedRegistry.verifiedDates();   

        if (verifiedRegistry.verifiedEntries()) {
            calc = new VacationsInabilityCalculator(date1.getCalendar(), date2.getCalendar(), 2, this.managingData.getSalary());
            // calc.setDia(verifiedRegistry.selectTypeDay());
            showData(calc);
        }

    }//GEN-LAST:event_calculateActionPerformed

    private void date1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date1PropertyChange
        // TODO add your handling code here:

        /* if(verifiedRegistry!=null){
            verifiedRegistry.updateDates();
            date2.setEnabled(true);
        }*/

    }//GEN-LAST:event_date1PropertyChange

    private void date2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date2PropertyChange
        // TODO add your handling code here:
        /*if (this.jDateChooser1.getCalendar() == null) {

            if (selectTypeDay.getSelectedIndex() > 1) {
                Calendar c = jDateChooser2.getCalendar();
                c.add(Calendar.DAY_OF_MONTH, -1);
                jDateChooser2.setCalendar(c);
            }

        }*/
    }//GEN-LAST:event_date2PropertyChange

    private void saveRegistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRegistryActionPerformed
        // TODO add your handling code here:
        VacationsInabilityCalculator calc;

        if (verifiedRegistry.verifiedEntries()) {

            calc = new VacationsInabilityCalculator(date1.getCalendar(), date2.getCalendar(), 2, managingData.getSalary());

            boolean rs = managingData.insertVacationsInability(new CalendarString(date1.getCalendar()).getStringDate(),
                    new CalendarString(date2.getCalendar()).getStringDate(), calc.getRevenue(), 2);

            //Validar rango de fechas
            if (rs) {
                wregistry.dispose();
            } else {

                JOptionPane.showMessageDialog(null, "Fecha ocupada");
            }

        }

    }//GEN-LAST:event_saveRegistryActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        wregistry.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void startTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTodayActionPerformed
        // TODO add your handling code here:
        Calendar calendarNow;
        calendarNow = Calendar.getInstance();
        this.date1.setCalendar(calendarNow);

    }//GEN-LAST:event_startTodayActionPerformed

    private void finishTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishTodayActionPerformed
        // TODO add your handling code here:
        Calendar calendarNow;
        calendarNow = Calendar.getInstance();
        this.date2.setCalendar(calendarNow);
    }//GEN-LAST:event_finishTodayActionPerformed

    private void salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calculate;
    private javax.swing.JButton cancel;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JCheckBox finishToday;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField salary;
    private javax.swing.JButton saveRegistry;
    private javax.swing.JCheckBox startToday;
    // End of variables declaration//GEN-END:variables

}
