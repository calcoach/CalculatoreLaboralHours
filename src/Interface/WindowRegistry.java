/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import horaslaborales.ODBCSesion;
import horaslaborales.Question;
import java.awt.Component;
import javax.swing.JPanel;
import models.NewRegistry;

/**
 *
 * @author Alejandro
 */
public class WindowRegistry extends javax.swing.JFrame {

    /**
     * Creates new form WindowRegistry
     */
    int numquestion = 0;
    NewRegistry reg = new NewRegistry();

    public WindowRegistry() {
        initComponents();

        chargeQuestion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        questionpane = new javax.swing.JPanel();
        next = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre y Apellido*");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 130, 30));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 203, 34));

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Los campos con ( * )son obligatorios. ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 250, -1));

        back.setBackground(new java.awt.Color(0, 153, 51));
        back.setText("Atras");
        back.setBorder(null);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 100, 30));

        questionpane.setBackground(new java.awt.Color(255, 255, 255));
        questionpane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(questionpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 480, 260));

        next.setBackground(new java.awt.Color(0, 153, 51));
        next.setText("SIGUIENTE ");
        next.setBorder(null);
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        jPanel2.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 100, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 670, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        questionpane.removeAll();
        if (numquestion > 0) {
            numquestion--;
        }

        chargeQuestion();

    }//GEN-LAST:event_backActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:

        if (!checkInputs((Question)questionpane.getComponent(0))) {

            questionpane.removeAll();
            if (numquestion <= 2) {

                numquestion++;
            }
        }

        chargeQuestion();
    }//GEN-LAST:event_nextActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        reg.setNameUser(this.jTextField1.getText());
    }//GEN-LAST:event_jTextField1KeyReleased

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
            java.util.logging.Logger.getLogger(WindowRegistry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowRegistry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowRegistry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowRegistry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowRegistry().setVisible(true);
            }
        });
    }

    private void chargeQuestion() {

        switch (numquestion) {
            case 1:
                Question2 q2 = new Question2(reg);
                questionpane.add(q2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 260));
                break;

            case 2:

                Question3 q3 = new Question3(reg);
                questionpane.add(q3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 260));
                this.next.setText("Finalizar");
                break;

            case 3:

                System.out.println(reg.getMensualBonuses());
                System.out.println(reg.getTerminationPayment());
                System.out.println(reg.getSalary());
                ODBCSesion odb = new ODBCSesion("Prueba.db");
                //PROGRAMAR RESPUESTA AL CREAR USUARIO
                if (!reg.getNameUser().equals(null)) {

                    odb.createUser(reg);
                    SesionWindow w = new SesionWindow();
                    w.setVisible(true);
                    w.setLocationRelativeTo(null);
                }

                break;

            default:
                Question1 q1 = new Question1(reg);
                questionpane.add(q1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 260));

                break;

        }
        questionpane.updateUI();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton next;
    private javax.swing.JPanel questionpane;
    // End of variables declaration//GEN-END:variables

    private boolean checkInputs(Question question) {

        return question.hasNullInputs();
    }
}
