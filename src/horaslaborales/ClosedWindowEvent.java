/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.awt.event.WindowListener;

/**
 *
 * @author Alejandro
 */
public class ClosedWindowEvent implements WindowListener{
    
    ViewHistory window;
    public ClosedWindowEvent(ViewHistory window){
        this.window = window;
    }

    @Override
    public void windowOpened(java.awt.event.WindowEvent e) {

    }

    @Override
    public void windowClosing(java.awt.event.WindowEvent e) {

    }

    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {

        window.updateTable();
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
    
}
