package horaslaborales;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.getInstance;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This class parse date of calendar to String and String to calendar
 * @author Alejandro
 */
public class CalendarString {
    
    String date;
    Calendar calendar;
    Date date1;
    
    public CalendarString(String date){
        this.date = date;
    }
    
    public CalendarString(){
        
    }

    public  Date getDate() throws ParseException {
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(this.date.toString());
            
        return date;
    }
    
    public String getStringDate(Date dat){
        calendar = getInstance();
        calendar.setTime(dat);
        StringBuilder fecha = new StringBuilder();
        fecha.append(String.valueOf(calendar.get(Calendar.YEAR)))
                    .append("-")
                    .append(calendar.get(Calendar.MONTH) + 1)
                    .append("-")
                    .append(calendar.get(Calendar.DAY_OF_MONTH));
        return fecha.toString();
    }
    
}
