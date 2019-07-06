/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inputs;

import Dates.TypeDay;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class VerifiedAddRegistry {

    JComboBox time1;
    JComboBox time2;
    JDateChooser date1;
    JDateChooser date2;
    int selectTypeDay;
    boolean firsMessageShow;
    boolean nextDay = false;

    public VerifiedAddRegistry(JComboBox time1, JComboBox time2, JDateChooser date1,
            JDateChooser date2) {
        this.time1 = time1;
        this.time2 = time2;
        this.date1 = date1;
        this.date2 = date2;

    }

    public boolean daysDiferent() {

        ///Temporal
        if(!(calendarEntryNotNull() & calendarExitNotNull())){
            return false;
        }
        if (date1.getCalendar().get(Calendar.DAY_OF_MONTH) != date2.getCalendar().get(Calendar.DAY_OF_MONTH)) {
             return true;
        } else{
            
            return false;
        }
    }

    public boolean verifiedEntries() {

        if (calendarEntryNotNull() & calendarExitNotNull()) {

            if(timesDiferent() & turnIsCorrect()){
               return true; 
            }
              
        } 
            this.firsMessageShow = false;
            return false;
       
    }

    private boolean timesDiferent() {

        if (getTimeChooser(time1) != getTimeChooser(time2) | this.daysDiferent()) {
            return true;
        } else if (!this.firsMessageShow & !this.daysDiferent()) {
            JOptionPane.showMessageDialog(null, "Las horas son iguales ");
            this.firsMessageShow = true;
        } else {
            return true;
        }
        return false;
    }

    private boolean calendarEntryNotNull() {
        if (this.date1.getCalendar() != null) {
            return true;
        } else if (!this.firsMessageShow) {
            JOptionPane.showMessageDialog(null, "Seleccione la fecha de entrada");
            this.firsMessageShow = true;
        }
        return false;
    }

    private boolean calendarExitNotNull() {
        if (this.date2.getCalendar() != null) {
            return true;
        } else if (!this.firsMessageShow) {
            JOptionPane.showMessageDialog(null, "Seleccione la fecha de salida");
            this.firsMessageShow = true;
        }

        return false;
    }

    private int getTimeChooser(JComboBox combo) {

        int select = combo.getSelectedIndex();

        if (select == 0) {
            if (selectTypeDay() == 2 | selectTypeDay() == 3) {
                return 0;
            } else {
                return 24;
            }
        } else {
            return select;
        }
    }
    
    

    /*private boolean turnIsCorrect() {
        if (!((time2.getSelectedIndex() >= time1.getSelectedIndex()) & ((selectTypeDay() == 3)
                | (selectTypeDay() == 4)))) {

            return true;
            
        } else if (!(date2.getCalendar().get(Calendar.DATE) > date1.getCalendar().get(Calendar.DATE))
                & time2.getSelectedIndex() >= time1.getSelectedIndex()) {

            return true;

        } else if (!this.firsMessageShow) {
            JOptionPane.showMessageDialog(null, "Turno mayor o igual a 24 horas");
            this.firsMessageShow = true;
        
        } else if(this.daysDiferent()){
            return true;
        }
        
        return false;
    }*/
    
    private boolean turnIsCorrect(){
        if(!(time2.getSelectedIndex() < time1.getSelectedIndex() & (time2.getSelectedIndex()!=0) 
                &(date2.getCalendar().get(Calendar.DATE)==date1.getCalendar().get(Calendar.DATE)))){
            return true;
        } else if(!this.firsMessageShow){
            JOptionPane.showMessageDialog(null, "Hora fin menor que hora inicio");
            this.firsMessageShow = true;
        }
        return false;
    }

    public void verifiedDates() {

        this.firsMessageShow = true;
        if (this.calendarEntryNotNull() & this.calendarExitNotNull()) {

            if (date1 != null & date2 != null) {
                
                int day1= date1.getCalendar().get(Calendar.DATE);
                int day2= date2.getCalendar().get(Calendar.DATE);
                
                if (getTimeChooser(time2) < getTimeChooser(time1) & getTimeChooser(time1) != 24 & (day1==day2)) {

                    Calendar c = date1.getCalendar();
                    c.roll(Calendar.DAY_OF_MONTH, 1);
                    date2.setCalendar(c);
                    
                    
                }
            }
        }

        this.firsMessageShow = false;
    }

    public void updateDates() {
        this.firsMessageShow = true;
        if (this.calendarEntryNotNull()) {

            if (date1 != null & date2 != null) {

                Calendar c = date1.getCalendar();
                Date firstday = c.getTime();
                c.roll(Calendar.DAY_OF_MONTH, 1);

                Date seconday = c.getTime();

                date2.setMinSelectableDate(firstday);
                date2.setMaxSelectableDate(seconday);

            }
        }

        this.firsMessageShow = false;
    }

    public int selectTypeDay() {

        if (this.date1.getCalendar() != null & this.date2.getCalendar() != null) {

            Calendar ca11 = date1.getCalendar();
            Calendar cal2 = date2.getCalendar();

            LocalDate local1 = LocalDate.of(ca11.get(Calendar.YEAR), ca11.get(Calendar.MONTH) + 1, ca11.get(Calendar.DAY_OF_MONTH));
            LocalDate local2 = LocalDate.of(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH) + 1, cal2.get(Calendar.DAY_OF_MONTH));

            TypeDay type1 = new TypeDay(local1);
            TypeDay type2 = new TypeDay(local2);

            if (type1.getTypeDay() == 0 & type2.getTypeDay() == 0) {
                return 1;
            } else if (type1.getTypeDay() == 1 & type2.getTypeDay() == 1) {
                return 2;
            } else if (type1.getTypeDay() == 0 & type2.getTypeDay() == 1) {
                System.out.println(type2.getTypeDay());
                return 3;
            } else if (type1.getTypeDay() == 1 & type2.getTypeDay() == 0) {
                return 4;
            }
        }

        return 0;
    }

}
