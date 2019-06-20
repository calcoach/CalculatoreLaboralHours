/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dates;

import java.time.LocalDate;

/**
 *
 * @author Alejandro
 */
public class CalendarLibrary {
    
    LocalDate local;
    
    
    public CalendarLibrary(){
        
        
    }
    
     public int[] getFirstAndLastDayMonth(LocalDate date) {

        int[] info = new int[2];
        info[0] = date.lengthOfMonth();

        if (date.getMonthValue() < 10) {
            info[1] = LocalDate.parse(date.getYear() + "-" + "0" + date.getMonthValue() + "-" + "01").getDayOfWeek().getValue() + 1;
        } else {
            info[1] = LocalDate.parse(date.getYear() + "-" + date.getMonthValue() + "-" + "01").getDayOfWeek().getValue() + 1;
        }

        return info;
   
    }
}
