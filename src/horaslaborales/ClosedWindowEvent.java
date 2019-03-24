/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import Interface.HistoryPane;
import Interface.SesionWindow;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowListener;

/**
 *
 * @author Alejandro
 */
public class ClosedWindowEvent implements WindowListener, MouseListener, MouseMotionListener{
    
    //ViewHistory window;
    HistoryPane pane;
    SesionWindow ses; 
    
    
    public ClosedWindowEvent( ){
        //this.window = window;
    }

    public ClosedWindowEvent(SesionWindow ses) {
        this.ses = ses;
    }
    
    
    
    public ClosedWindowEvent(HistoryPane pane){
        this.pane=pane;
    }

    @Override
    public void windowOpened(java.awt.event.WindowEvent e) {

    }

    @Override
    public void windowClosing(java.awt.event.WindowEvent e) {

    }

    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {
       this.pane.updateTable();
        
    }

    @Override
    public void windowIconified(java.awt.event.WindowEvent e) {

    }

    @Override
    public void windowDeiconified(java.awt.event.WindowEvent e) {

    }

    @Override
    public void windowActivated(java.awt.event.WindowEvent e) {

    }

    @Override
    public void windowDeactivated(java.awt.event.WindowEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        this.ses.dispose();
        System.out.println("aqui");
    }

    @Override
    public void mousePressed(MouseEvent e) {
         this.ses.dispose();
         System.out.println("aqui");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       this.ses.dispose();
       System.out.println("aqui");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       this.ses.dispose();
    }

    @Override
    public void mouseExited(MouseEvent e) {
             this.ses.dispose();
       System.out.println("aqui");                                                                                                        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
      System.out.println("aqui");   
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
