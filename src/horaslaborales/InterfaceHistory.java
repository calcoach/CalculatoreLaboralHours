/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import Dates.CalendarString;
import models.Registry;
import Inputs.FieldString;
import com.toedter.calendar.JDateChooser;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class InterfaceHistory extends DataUser{

    public static String URL_ODBC = "Prueba.db";
    ODBC conect;

    public InterfaceHistory(Sesion sesion) {
        
        super(sesion);
        
    }

    public void updateLastSalary(JTextField salary) {

        this.database.editSalary(FieldString.deleteWhiteSpaces(salary.getText()), this.user.getUser());

    }

    public void getSalary(JTextField salary, String user) {

        String s = this.database.selectSalary(user);
        salary.setText(FieldString.fieldNum(s));

    }

    //Modificacion en registro: Incluir hora de inicio y hora fin
    public boolean saveRegistry(JDateChooser fecha1, JComboBox time1, JDateChooser fecha2, JComboBox time2, Calculator cal,
            JComboBox turn) {

        try {

            CalendarString date = new CalendarString(fecha1.getCalendar());
            CalendarString date2 = new CalendarString(fecha2.getCalendar());

            int[] horas = sumHours(cal.calcularHoras());
            String stringTurn = (String)turn.getSelectedItem();

            this.database.insert(date.getStringDate(),(String)time1.getSelectedItem(), horas, 
                    sumSueldo(cal.calcularSueldo()),date2.getStringDate(),(String)time2.getSelectedItem(),
                    sumSueldo(cal.calcularSueldo()),stringTurn);
            //Succesfullsave
            return true;

        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error");
        } catch (ExceptionLaboralHours e) {
            JOptionPane.showMessageDialog(null, "Fecha ocupada por otro registro");

        }

        return false;
    }

    //MOdificacion en registro: Incluir hora de inicio y hora fin
    public void updateRegistry(JDateChooser fecha1, JComboBox time, JDateChooser fecha2, Calculator cal, JComboBox time2,
            JComboBox turn) {

        try {

            CalendarString date = new CalendarString(fecha1.getCalendar());

            int[] horas = sumHours(cal.calcularHoras());
            String stringTurn = (String)turn.getSelectedItem();

            this.database.update(date.getStringDate(),(String)time.getSelectedItem(), horas, sumSueldo(cal.calcularSueldo()), 
                   (String) time2.getSelectedItem(),stringTurn);    

        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error");
        } catch (ExceptionLaboralHours e) {
            JOptionPane.showMessageDialog(null, "Fecha ocupada por otro registro");
        }
    }

    /**
     * Carga los r
     *
     * @param JCombo
     * @param table
     * @param year
     */
    public void chargueMonthRegistries(JComboBox JCombo, JTable table, JComboBox year) {

        if(JCombo.getSelectedItem()!=null){
            int yearInt = Integer.valueOf((String) year.getSelectedItem());

            chargueRegistries(table, CalendarString.getYearMonthByNameMonth(yearInt,
                    (String) JCombo.getSelectedItem()));
        }
        

    }

    public void chargueYearRegistries(JComboBox month, JTable table, JComboBox year, boolean firtsTime) {

        if (year.getItemCount() == 0 & firtsTime) {

            ArrayList<String> registriesYears = this.database.selectRegistriesYears();

            for (String registry : registriesYears) {

                year.addItem(registry);

            }

            int m = year.getItemCount();
            year.setSelectedIndex(m - 1);
        }
        
        month.removeAllItems();

        ArrayList<Integer> registries = this.database.selectRegistriesMonthYear((String) year.getSelectedItem());

        for (Integer registry : registries) {

            month.addItem(CalendarString.getNameMounth(registry));

        }

    }

    private void chargueRegistries(JTable table, String consult) {

        try {

            ArrayList<Registry> registries = this.database.selectMonthRegistries(consult);

            DefaultTableModel deftable = (DefaultTableModel) table.getModel();
            deftable.setNumRows(0);

            int sumOrdinarios = 0;
            int sumRNocturno = 0;
            int sumExtraDiurna = 0;
            int sumExtraNocturna = 0;
            double sumSueldo = 0;

            DecimalFormat df = new DecimalFormat("#.##");

            for (Registry registry : registries) {

                CalendarString c = new CalendarString();
                deftable.addRow(new Object[]{c.getStringDate(registry.getStartDay()), registry.getOrdinaria(),
                    registry.getRNocturno(), registry.getExtraDiurna(), registry.getExtranocturna(),
                    Double.valueOf(df.format(registry.getSueldo()))});

                sumOrdinarios = sumOrdinarios + registry.getOrdinaria();
                sumRNocturno = sumRNocturno + registry.getRNocturno();
                sumExtraDiurna = sumExtraDiurna + registry.getExtraDiurna();
                sumExtraNocturna = sumExtraNocturna + registry.getExtranocturna();
                sumSueldo = sumSueldo + registry.getSueldo();

            }
            deftable.addRow(new Object[]{"TOTAL:", sumOrdinarios, sumRNocturno, sumExtraDiurna, sumExtraNocturna,
                Double.valueOf(df.format(sumSueldo))});

        } catch (ParseException ex) {
            Logger.getLogger(InterfaceHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRegistry(String date) {

        this.database.deleteRegistry(date);

    }

    public Registry searchRegistry(String consult) {

        try {

            return this.database.selectRegistry(consult);
        } catch (ExceptionLaboralHours ex) {
            Logger.getLogger(InterfaceHistory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException e) {

        }
        JOptionPane.showMessageDialog(null, "No se encuentra registro");
        return null;
    }

    public void saveRegistryToExcel(JTable table, String rute) {

        WriteExcelRegistry write = new WriteExcelRegistry(table, rute);
        int returnSave = write.save();
        switch (returnSave) {

            case 1:
                break;

            case -1:
                JOptionPane.showMessageDialog(table, "Error al guardar excel");
                break;

            default:
                break;

        }

    }

    /**
     * Método temporal mientras se corrije base de datos para que acepte turno
     * de dos horas
     *
     * @param calHours hours generated for calculator hours
     * @return Sum day 1 and day 2
     */
    private int[] sumHours(int[] calHours) {

        int[] hours = calHours;

        if (hours.length > 5) {

            hours[0] = hours[0] + hours[5];
            hours[1] = hours[1] + hours[6];
            hours[2] = hours[2] + hours[7];
            hours[3] = hours[3] + hours[8];
            hours[4] = hours[4] + hours[10];
        }
        return hours;
    }
    
    private double sumSueldo(double[] sueldo ){
        
        if(sueldo.length >5){
            return sueldo[10];
        } else{
            
            return sueldo[4];
        }
    }

}
