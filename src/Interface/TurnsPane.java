/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Inputs.VerifiedAddTurn;
import horaslaborales.ManagingDataUser;
import horaslaborales.InterfaceHistory;
import horaslaborales.Sesion;
import models.Turn;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class TurnsPane extends javax.swing.JPanel {

    /**
     * Creates new form HomePane
     */
    Sesion user;
    ManagingDataUser managing;
    ArrayList<Turn> turns;
    
    public TurnsPane(Sesion user) {
        initComponents();
        this.user = user;
        managing = new ManagingDataUser(user);
        preconfig();
    }
    
         
     
    
    private void preconfig(){
        
       jTable1.getTableHeader().setBackground(new java.awt.Color(0, 204, 51));
       jTable1.getTableHeader().setForeground(java.awt.Color.WHITE);
        
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       model.setNumRows(0);
       turns = managing.getTurns();
       
        for (Turn turn : turns) {
            
            model.addRow(new Object [] {turn.getNameTurn(), turn.getHourStart(), turn.getHourFinish()});
        }
        
        int numTurn = (model.getRowCount()>0)?model.getRowCount()+1:1;
        nameTurn.setText("T"+String.valueOf(numTurn));
       
        
    }
    
    private void update(){
        
        this.jTable1.removeAll();
        preconfig();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        hourStart = new javax.swing.JComboBox<>();
        hourFinish = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addTurn = new javax.swing.JButton();
        nameTurn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        deleteTurn = new javax.swing.JButton();
        nextDay = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Turnos");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Agregar Turnos Frecuentes");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Turno", "Hora Entrada", "Hora Salida"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(0, 204, 51));
        jTable1.setShowHorizontalLines(false);
        jScrollPane4.setViewportView(jTable1);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, 100));

        hourStart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12 am", "01 am", "02 am", "03 am", "04 am", "05 am", "06 am", "07 am", "08 am", "09 am", "10 am", "11 am", "12 pm", "01 pm", "02 pm", "03 pm", "04 pm", "05 pm", "06 pm", "07 pm", "08 pm", "09 pm", "10 pm", "11 pm" }));
        add(hourStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, 30));

        hourFinish.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12 am", "01 am", "02 am", "03 am", "04 am", "05 am", "06 am", "07 am", "08 am", "09 am", "10 am", "11 am", "12 pm", "01 pm", "02 pm", "03 pm", "04 pm", "05 pm", "06 pm", "07 pm", "08 pm", "09 pm", "10 pm", "11 pm" }));
        add(hourFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, 30));

        jLabel1.setText("Hora entrada");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel2.setText("Hora salida");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));

        addTurn.setBackground(new java.awt.Color(51, 0, 255));
        addTurn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Plus_Math_24px.png"))); // NOI18N
        addTurn.setText("Agregar");
        addTurn.setBorderPainted(false);
        addTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTurnActionPerformed(evt);
            }
        });
        add(addTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 110, 40));

        nameTurn.setEditable(false);
        nameTurn.setBackground(new java.awt.Color(255, 255, 255));
        nameTurn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameTurn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTurn.setText("T1");
        nameTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTurnActionPerformed(evt);
            }
        });
        add(nameTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 30, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nombre Turno");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        deleteTurn.setBackground(new java.awt.Color(255, 51, 51));
        deleteTurn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Trash_Can_24px_1.png"))); // NOI18N
        deleteTurn.setText("Elininar Turno");
        deleteTurn.setBorderPainted(false);
        deleteTurn.setFocusable(false);
        deleteTurn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        deleteTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTurnActionPerformed(evt);
            }
        });
        add(deleteTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 130, 30));

        nextDay.setText("Siguiente Dia");
        add(nextDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void addTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTurnActionPerformed
        // TODO add your handling code here:
        if(new VerifiedAddTurn(nameTurn, hourStart,hourFinish,nextDay).verifiedEntries()){
            
            managing.insertTurn(new Turn(nameTurn.getText(),(String)hourStart.getSelectedItem(),
                    (String)hourFinish.getSelectedItem()));
            
            preconfig();
        }
    }//GEN-LAST:event_addTurnActionPerformed

    private void deleteTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTurnActionPerformed
        // TODO add your handling code here:
        int item  = jTable1.getSelectedRow();
        
        if(item>=0){
            
            managing.deleteTurn(turns.get(item).getNum());
            preconfig();
        } else{
            JOptionPane.showMessageDialog(null, "Seleccione el turno a elimnar en la tabla");
        }
    }//GEN-LAST:event_deleteTurnActionPerformed

    private void nameTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTurnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTurnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTurn;
    private javax.swing.JButton deleteTurn;
    private javax.swing.JComboBox<String> hourFinish;
    private javax.swing.JComboBox<String> hourStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameTurn;
    private javax.swing.JCheckBox nextDay;
    // End of variables declaration//GEN-END:variables
}
