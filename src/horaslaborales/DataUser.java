/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.time.LocalDate;

/**
 *
 * @author Alejandro
 */
public class DataUser {
    
    
    ODBC database;
    Sesion user;
    int cut1 = 0;
    int cut2 = 0;
    
    public DataUser(Sesion ses){   
        
        this.user = ses;
        database = new ODBC("Prueba.db", user);
        this.database.createNewTableUser();
    }
    
    
    public String[] getPeriod() {

        String[] periodsPayment = new String[2];

        int periods = database.selectPeriodsPayment();

        LocalDate localDate = LocalDate.now();
        int day = localDate.getDayOfMonth();

        switch (periods) {

            case 1:
                periodsPayment[0] = localDate.withDayOfMonth(1).toString();
                periodsPayment[1] = (cut2 == 0) ? localDate.withDayOfMonth(localDate.lengthOfMonth()).toString()
                        : localDate.withDayOfMonth(cut2).toString();
                break;

            case 2:
                
                if (day > 15) {
                    
                    periodsPayment[0] = localDate.withDayOfMonth(16).toString();
                    periodsPayment[1] = (cut2 == 0) ? localDate.withDayOfMonth(localDate.lengthOfMonth()).toString()
                            : localDate.withDayOfMonth(cut2).toString();

                } else {

                    periodsPayment[0] = localDate.withDayOfMonth(1).toString();
                    periodsPayment[1] = (cut2 == 0) ? localDate.withDayOfMonth(15).toString()
                            : localDate.withDayOfMonth(cut2).toString();
                }
                break;

            case 4:

                int actualday = localDate.getDayOfWeek().getValue();

                periodsPayment[0] = localDate.plusDays(-actualday - 1).toString();
                periodsPayment[1] = (cut2 == 0) ? localDate.plusDays(7 - actualday).toString()
                        : localDate.withDayOfMonth(cut2).toString();

            default:
                break;

        }

        return periodsPayment;
    }
}
