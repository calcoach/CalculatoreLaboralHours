/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import Dates.CalendarLibrary;
import Dates.CalendarString;
import Interface.TwoTurnsPane;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Registry;

/**
 *
 * @author Alejandro
 */
public class InterfaceCalendarHistory extends DataUser {

    public InterfaceCalendarHistory(Sesion sesion) {

        super(sesion);

    }

    public void chargeRegistries(ArrayList<JLabel> money, LocalDate date, ArrayList<JLabel> hour, ArrayList<JPanel> panels) {

        CalendarLibrary cal = new CalendarLibrary();
        LocalDate day1;
        LocalDate day2;
        Calendar calendar = Calendar.getInstance();

        String consult = CalendarString.YearMonthString(date.getYear(), date.getMonthValue(), 1);

        try {
            ArrayList<Registry> registries = this.database.selectMonthRegistries(consult);

            for (int i = 0; i < registries.size(); i++) {

                calendar.setTime(registries.get(i).getStartDay());

                //Observacion: Calendar month empieza en 0
                //Day one
                day1 = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
                        calendar.get(Calendar.DAY_OF_MONTH));
                int position = day1.getDayOfMonth() + cal.getFirstAndLastDayMonth(day1)[1] - 1;

                //Day two
                calendar.setTime(registries.get(i).getFinishDay());
                day2 = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
                        calendar.get(Calendar.DAY_OF_MONTH));
                int position2 = day2.getDayOfMonth() + cal.getFirstAndLastDayMonth(day2)[1] - 1;
                
                 //Day with doble turn      
                if (panels.get(position).getComponentCount()!=1 ) {

                    dayNormal(position, position2, panels, money, hour, registries.get(i),day2.getDayOfMonth());
                } else {

                    dayDouble(position, position2, panels, money, hour, registries.get(i));
                }

            }

        } catch (ParseException ex) {
            Logger.getLogger(InterfaceCalendarHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dayNormal(int position, int position2, ArrayList<JPanel> panels, ArrayList<JLabel> money,
            ArrayList<JLabel> hour, Registry reg, int day) {

        if (position == position2) {
            money.get(position).setText("$ " + String.valueOf((int) reg.getSueldo()));
            hour.get(position).setText(reg.getTime_startDay() + " - " + reg.getTime_finishDay());
           
        } else {

            money.get(position).setText("$ " + String.valueOf((int) reg.getSueldo()));
            hour.get(position).setText(reg.getTime_startDay() + " - Sig dia");

            TwoTurnsPane pane = new TwoTurnsPane();
            pane.setDay(String.valueOf(day));
            pane.setHourDay1("Fin turno- " + reg.getTime_finishDay());

            pane.setVisible(true);

            panels.get(position2).removeAll();
            panels.get(position2).add(pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0));
            panels.get(position2).updateUI();

        }
    }

    private void dayDouble(int position, int position2, ArrayList<JPanel> panels, ArrayList<JLabel> money,
            ArrayList<JLabel> hour, Registry reg) {

       
        if (position == position2) {
            
            
            TwoTurnsPane pane = (TwoTurnsPane) panels.get(position).getComponent(0);
            pane.setMoney("$ "+String.valueOf((int)reg.getSueldo()));
            pane.setHourDay2(reg.getTime_startDay() + " - " + reg.getTime_finishDay());
            
        } else {

            hour.get(position).setText(reg.getTime_startDay() + " -");

            TwoTurnsPane pane = new TwoTurnsPane();
            pane.setDay(String.valueOf(position2));
            pane.setHourDay1(" - " + reg.getTime_finishDay());

            pane.setVisible(true);

            panels.get(position2).removeAll();
            panels.get(position2).add(pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0));
            panels.get(position2).updateUI();

        }
        
    }
}
