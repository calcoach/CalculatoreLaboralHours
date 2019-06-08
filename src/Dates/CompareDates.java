/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dates;

import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author Alejandro
 */
public class CompareDates {
 
    
    public static int contDates(Calendar cal1, Calendar cal2){
        
       LocalDate lc = LocalDate.now();
       
       int day1 =  cal1.get(Calendar.DAY_OF_MONTH);
       int day2 =  cal2.get(Calendar.DAY_OF_MONTH);
        
        return day2-day1;
    }
}
