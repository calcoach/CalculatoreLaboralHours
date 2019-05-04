/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import horaslaborales.Sesion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro
 */
public class Prueba extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    Sesion user;

    public Prueba(Sesion ses) {
        initComponents();
        this.user = ses;
        MouseEvent ev = null;
        this.btn_HomeMousePressed(ev);

        preconfig();
    }
    
    private void preconfig(){
        labelUser.setText(user.getUser());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parent = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();
        closeSesion = new javax.swing.JButton();
        background = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        btn_Home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_About = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_Config = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_History = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_Turns = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        parent.setBackground(new java.awt.Color(255, 255, 255));
        parent.setMinimumSize(new java.awt.Dimension(1000, 600));
        parent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(11, 198, 62));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_User_96px_1.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 100, 100));

        labelUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelUser.setForeground(new java.awt.Color(255, 255, 255));
        labelUser.setText("User");
        jPanel1.add(labelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 70, 30));

        closeSesion.setBackground(new java.awt.Color(255, 51, 51));
        closeSesion.setText("Cerrar Sesion");
        closeSesion.setBorderPainted(false);
        closeSesion.setFocusable(false);
        closeSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeSesionActionPerformed(evt);
            }
        });
        jPanel1.add(closeSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        parent.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 690));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        parent.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 920, 590));

        sidepane.setBackground(new java.awt.Color(0, 204, 51));
        sidepane.setMinimumSize(new java.awt.Dimension(600, 200));
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Home.setBackground(new java.awt.Color(0, 204, 51));
        btn_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_HomeMousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Home_24px.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inicio");

        javax.swing.GroupLayout btn_HomeLayout = new javax.swing.GroupLayout(btn_Home);
        btn_Home.setLayout(btn_HomeLayout);
        btn_HomeLayout.setHorizontalGroup(
            btn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        btn_HomeLayout.setVerticalGroup(
            btn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_HomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26))
        );

        sidepane.add(btn_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 140, 70));

        btn_About.setBackground(new java.awt.Color(0, 204, 51));
        btn_About.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_AboutMousePressed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_About_24px.png"))); // NOI18N

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Informacion");

        javax.swing.GroupLayout btn_AboutLayout = new javax.swing.GroupLayout(btn_About);
        btn_About.setLayout(btn_AboutLayout);
        btn_AboutLayout.setHorizontalGroup(
            btn_AboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_AboutLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        btn_AboutLayout.setVerticalGroup(
            btn_AboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_AboutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(25, 25, 25))
        );

        sidepane.add(btn_About, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 140, 70));

        btn_Config.setBackground(new java.awt.Color(0, 204, 51));
        btn_Config.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ConfigMousePressed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Settings_24px_1.png"))); // NOI18N

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Configuraciones");

        javax.swing.GroupLayout btn_ConfigLayout = new javax.swing.GroupLayout(btn_Config);
        btn_Config.setLayout(btn_ConfigLayout);
        btn_ConfigLayout.setHorizontalGroup(
            btn_ConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ConfigLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_ConfigLayout.setVerticalGroup(
            btn_ConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_ConfigLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(25, 25, 25))
        );

        sidepane.add(btn_Config, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 170, -1));

        btn_History.setBackground(new java.awt.Color(0, 204, 51));
        btn_History.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_HistoryMousePressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Calendar_24px.png"))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Registros");

        javax.swing.GroupLayout btn_HistoryLayout = new javax.swing.GroupLayout(btn_History);
        btn_History.setLayout(btn_HistoryLayout);
        btn_HistoryLayout.setHorizontalGroup(
            btn_HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_HistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        btn_HistoryLayout.setVerticalGroup(
            btn_HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_HistoryLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(25, 25, 25))
        );

        sidepane.add(btn_History, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 140, 70));

        btn_Turns.setBackground(new java.awt.Color(0, 204, 51));
        btn_Turns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_TurnsMousePressed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Calendar_24px_1.png"))); // NOI18N

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Turnos");

        javax.swing.GroupLayout btn_TurnsLayout = new javax.swing.GroupLayout(btn_Turns);
        btn_Turns.setLayout(btn_TurnsLayout);
        btn_TurnsLayout.setHorizontalGroup(
            btn_TurnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_TurnsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        btn_TurnsLayout.setVerticalGroup(
            btn_TurnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_TurnsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(26, 26, 26))
        );

        sidepane.add(btn_Turns, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 150, 70));

        parent.add(sidepane, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 820, -1));

        getContentPane().add(parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1110, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_HomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMousePressed
        // TODO add your handling code here:
        setColor(btn_Home);
        resetColor(btn_History);
        resetColor(btn_About);
        resetColor(btn_Config);
        resetColor(btn_Turns);
        
        showHome();
    }//GEN-LAST:event_btn_HomeMousePressed

    private void btn_HistoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HistoryMousePressed
        // TODO add your handling code here:
        setColor(btn_History);
        resetColor(btn_Home);
        resetColor(btn_About);
        resetColor(btn_Config);
        resetColor(btn_Turns);
        
        showHistory();
    }//GEN-LAST:event_btn_HistoryMousePressed

    private void btn_ConfigMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ConfigMousePressed
        // TODO add your handling code here:
        setColor(btn_Config);
        resetColor(btn_Home);
        resetColor(btn_History);
        resetColor(btn_About);
        resetColor(btn_Turns);
        
        showConfig();
    }//GEN-LAST:event_btn_ConfigMousePressed

    private void btn_TurnsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TurnsMousePressed
        // TODO add your handling code here:
        setColor(btn_Turns);
        resetColor(btn_Home);
        resetColor(btn_History);
        resetColor(btn_About);
        resetColor(btn_Config);
        
        showTurns();
    }//GEN-LAST:event_btn_TurnsMousePressed

    private void btn_AboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AboutMousePressed
        // TODO add your handling code here:
        setColor(btn_About);
        resetColor(btn_Home);
        resetColor(btn_History);
        resetColor(btn_Config);
        resetColor(btn_Turns);
        
        showAbout();
    }//GEN-LAST:event_btn_AboutMousePressed

    private void closeSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeSesionActionPerformed
        // TODO add your handling code here:
        close();
        SesionWindow sw = new SesionWindow();
        sw.setLocationRelativeTo(null);
        sw.setVisible(true);
    }//GEN-LAST:event_closeSesionActionPerformed

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
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel btn_About;
    private javax.swing.JPanel btn_Config;
    private javax.swing.JPanel btn_History;
    private javax.swing.JPanel btn_Home;
    private javax.swing.JPanel btn_Turns;
    private javax.swing.JButton closeSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelUser;
    private javax.swing.JPanel parent;
    private javax.swing.JPanel sidepane;
    // End of variables declaration//GEN-END:variables

    private void resetColor(JPanel panel) {

        panel.setBackground(new Color(0, 204, 51));
    }

    private void setColor(JPanel panel) {

        panel.setBackground(new Color(79, 223, 86));
    }

   

    private void showAbout() {

        background.removeAll();
        InfoPane info = new InfoPane(this.user);
        info.setVisible(true);
        background.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        background.updateUI();
    }

    private void showConfig() {

        background.removeAll();
        ConfigPane config = new ConfigPane(this.user);
        config.setVisible(true);
        background.add(config, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));
        background.updateUI();

    }

    private void showHistory() {
        background.removeAll();
        HistoryPane history = new HistoryPane(user);
        background.setVisible(true);
        background.add(history, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));
        background.updateUI();

    }

    private void showHome() {

        background.removeAll();
        HomePane home = new HomePane(this.user);
        home.setVisible(true);
        background.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));
       
        background.updateUI();
    }
    
    private void showTurns(){
        
        background.removeAll();
        TurnsPane turns = new TurnsPane(this.user);
        turns.setVisible(true);
        
        background.add(turns, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));
        background.updateUI();
    }

    private void close() {
        dispose();
    }

}
