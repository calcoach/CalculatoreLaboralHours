/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import horaslaborales.ManagingRegistry;
import horaslaborales.Sesion;

/**
 *
 * @author Alejandro
 */
public class InfoPane extends javax.swing.JPanel {

    /**
     * Creates new form HomePane
     */
    Sesion user;
    ManagingRegistry managing;
    public InfoPane(Sesion user) {
        initComponents();
        this.user = user;
        managing = new ManagingRegistry(user);
        preconfig();
    }
    
         
     
    
    private void preconfig(){
        
        
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUser = new javax.swing.JLabel();
        closeSesion = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelUser.setText("user");
        add(labelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 70, 20));

        closeSesion.setBackground(new java.awt.Color(0, 204, 0));
        closeSesion.setForeground(new java.awt.Color(255, 255, 255));
        closeSesion.setText("Cerrrar Sesion");
        closeSesion.setBorder(null);
        add(closeSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 120, 20));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_User_50px_2.png"))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 60, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Pension");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Son los aportes que realiza el trabajador");
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 340, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cesantias");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Son los aportes que realiza el trabajador");
        jScrollPane2.setViewportView(jTextArea2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 340, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Deducciones ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("Son los aportes que realiza el trabajador");
        jScrollPane3.setViewportView(jTextArea3);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 340, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeSesion;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel labelUser;
    // End of variables declaration//GEN-END:variables
}
