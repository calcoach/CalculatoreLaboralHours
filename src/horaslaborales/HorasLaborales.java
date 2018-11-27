/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Alejandro
 */
public class HorasLaborales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            // TODO code application logic here
            Home ventana = new Home();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
            
            
            /*Date h = new Date("2018/10/11");
            System.out.println(h.getTime());
            Date f = new Date(h.getTime());
            cal.setTime(cal.getTime());*/
            //System.out.println(cal.getTime());
            //System.out.println(Calendar.getInstance().getTime());
            
            //ArrayList<String> a =conect.selectDate();
            //System.out.println(a);
        
    }
    
    
     
    
}
