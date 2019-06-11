/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import Dates.CompareDates;
import java.util.Calendar;

/**
 *
 * @author Alejandro
 */
public class VacationsInabilityCalculator {

    Calendar date1;
    Calendar date2;
    int type;
    double sueldo;

    public VacationsInabilityCalculator(Calendar date1, Calendar date2, int type, double sueldo) {
        this.date1 = date1;
        this.date2 = date2;
        this.type = type;
        this.sueldo = sueldo;
    }

    public double getRevenue() {

        double revenue = 0;
        int cont = getContDays();

        if (type == 1) {
            return revenue = cont * (sueldo / 30);

        } else {
            
            if(cont == 0) {
                return (sueldo / 30);
            }

            else  if (cont <= 2) {

                return revenue = (int) cont * (sueldo / 30);
            } else {
                
                revenue =  2 * (sueldo/30);
                revenue = revenue + (cont - 2) * (sueldo / 30 * 0.655);
                return revenue;
            }
        }

    }

    private int getContDays() {

        return CompareDates.contDates(date1, date2);
    }

}
