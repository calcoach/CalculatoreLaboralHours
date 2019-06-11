/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputs;

import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class VerifiedAddVacationsInability {
    
    
    JDateChooser time1;
    JDateChooser time2;
    boolean message;

    public VerifiedAddVacationsInability(JDateChooser time1, JDateChooser time2) {
       
        this.time1 = time1;
        this.time2 = time2;
        message = false;
    }
    
    public boolean verifiedEntries(){
        
        if(time1NotNull()& time2NotNull() & datesAreCorrect()){
            return true;
        } else{
            
            message = false;
            return false;         
        }
        
    }
    
    private boolean time1NotNull(){
        
        if(time1.getCalendar()!=null){
            
            return true;
        } else {
            
            if(!message){
                JOptionPane.showMessageDialog(null, "Seleccione fecha inicio");
                message = true;
            }
            return false;
        }
    }
    
    private boolean time2NotNull(){
        
        if(time1.getCalendar()!=null){
            
            return true;
        } else {
            
            if(!message){
                JOptionPane.showMessageDialog(null, "Seleccione fecha inicio");
                message = true;
            }
            return false;
        }
    }

    private boolean datesAreCorrect() {
    
        Calendar date1 = time1.getCalendar();
        Calendar date2 = time2.getCalendar();
        
        int day1 = date1.get(Calendar.DAY_OF_YEAR);
        int day2 = date2.get(Calendar.DAY_OF_YEAR);
        
        if(!message & day2<day1){
            
            JOptionPane.showMessageDialog(null, "Fecha invalida: fin menor que inicio ");
            message = true;
            return false;
        }
        
        if(!message & (day2-day1)>365){
            
            JOptionPane.showMessageDialog(null, "Ragno de fecha invalida. MAyor a un año");
            message = true;
            return false;
        }
        return true;
    }
    
            
    
    
}
