/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputs;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro
 */
public class VerifiedAddTurn {
    
    JTextField nameTurn;
    JComboBox time1;
    JComboBox time2;
    boolean firsMessageShow;

    public VerifiedAddTurn(JTextField nameTurn, JComboBox time1, JComboBox time2) {
        this.nameTurn = nameTurn;
        this.time1 = time1;
        this.time2 = time2;
    }
    
    public boolean verifiedEntries() {

        if ( nameTurnNotNull()  &  turnIsCorrect()) {
            
            return true;
        } else {
            this.firsMessageShow = false;
            return false;
        }
    }

    private boolean nameTurnNotNull() {
        
        if(!this.nameTurn.getText().equals("")){
            
            return true;
        } else if(!firsMessageShow){
            JOptionPane.showMessageDialog(null, "Escriba el nombre de turno");
            this.firsMessageShow = true;
            
        }
        return false;
    }

    private boolean turnIsCorrect() {

        if(!(this.time1.getSelectedIndex() == time2.getSelectedIndex())){
            
            
            return true;
        } else if(!firsMessageShow){
            JOptionPane.showMessageDialog(null, "Horas iguales");
            this.firsMessageShow = true;
            
        }
        return false;
    }
}
