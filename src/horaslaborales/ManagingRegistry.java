     /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class ManagingRegistry {

    public static String URL_ODBC = "Prueba.db";
    
    public static void updateLastSalary(JTextField salary, String user){
        ODBC conect = new ODBC(URL_ODBC);
        conect.editSalary(salary.getText(), user);
        
    }
    
    public static void getSalary(JTextField salary, String user){
        ODBC conect = new ODBC(URL_ODBC);
        salary.setText(conect.selectSalary(user));
       
    }

    public static boolean saveRegistry(JDateChooser fecha1, JSpinner hora1, JDateChooser fecha2,
            JSpinner hora2, Calculadora cal) {

        try {
            ODBC conect = new ODBC(URL_ODBC);
            conect.createNewTable();
            CalendarString date = new CalendarString(fecha1.getCalendar());

            int[] horas = cal.calcularHoras();

            conect.insert(date.getStringDate(), date.getStringDate(), horas, cal.calcularSueldo()[4]);
            //Succesfullsave
            return true;
            
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error");
        } catch (ExceptionLaboralHours e) {
            JOptionPane.showMessageDialog(null, "Fecha ocupada por otro registro");
            
        }
        //Errors
        return false;
    }
    
    public static void updateRegistry(JDateChooser fecha1, JSpinner hora1, JDateChooser fecha2,
            JSpinner hora2, Calculadora cal) {

        try {
            ODBC conect = new ODBC(URL_ODBC);
            
            CalendarString date = new CalendarString(fecha1.getCalendar());

            int[] horas = cal.calcularHoras();

            conect.update(date.getStringDate(), date.getStringDate(), horas, cal.calcularSueldo()[4]);
            
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error");
        } catch (ExceptionLaboralHours e) {
            JOptionPane.showMessageDialog(null, "Fecha ocupada por otro registro");
        }
    }

    public static void chargueMonthRegistries(JComboBox JCombo, JTable table) {

        if (JCombo.getItemCount() == 0) {
            ODBC conect = new ODBC(URL_ODBC);
            ArrayList<Integer> registries = conect.selectRegistriesMonthYear(2018);

            for (Integer registry : registries) {

                JCombo.addItem(CalendarString.getNameMounth(registry));

            }
            int n = registries.size();

            chargueRegistries(table, CalendarString.YearMonthString(2018, registries.get(n - 1)));
            JCombo.setSelectedIndex(n - 1);
        } else {
            chargueRegistries(table, CalendarString.getYearMonthByNameMonth(2018, JCombo.getSelectedItem().toString()));
        }

    }

    private static void chargueRegistries(JTable table, String consult) {

        try {
            ODBC conect = new ODBC(URL_ODBC);
            ArrayList<Registry> registries = conect.selectMonthRegistries(consult);

            DefaultTableModel deftable = (DefaultTableModel) table.getModel();
            deftable.setNumRows(0);

            int sumOrdinarios = 0;
            int sumRNocturno = 0;
            int sumExtraDiurna = 0;
            int sumExtraNocturna = 0;
            double sumSueldo = 0;
            for (Registry registry : registries) {

                CalendarString c = new CalendarString();
                deftable.addRow(new Object[]{c.getStringDate(registry.getStartDay()), registry.getOrdinaria(),
                    registry.getRNocturno(), registry.getExtraDiurna(), registry.getExtranocturna(),
                    registry.getSueldo()});

                sumOrdinarios = sumOrdinarios + registry.getOrdinaria();
                sumRNocturno = sumRNocturno + registry.getRNocturno();
                sumExtraDiurna = sumExtraDiurna + registry.getExtraDiurna();
                sumExtraNocturna = sumExtraNocturna + registry.getExtranocturna();
                sumSueldo = sumSueldo + registry.getSueldo();

            }
            deftable.addRow(new Object[]{"TOTAL:", sumOrdinarios, sumRNocturno, sumExtraDiurna, sumExtraNocturna,
                sumSueldo});

        } catch (ParseException ex) {
            Logger.getLogger(ManagingRegistry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteRegistry(String date) {

        
            ODBC conect = new ODBC(URL_ODBC);
            conect.deleteRegistry(date);
      
       
    }

    public static Registry searchRegistry(String consult){

        try {
            ODBC conect = new ODBC(URL_ODBC);
           return conect.selectRegistry(consult);
        } catch (ExceptionLaboralHours ex) {
            Logger.getLogger(ManagingRegistry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException e){
            
        }
       JOptionPane.showMessageDialog(null,"No se encuentra registro"); 
       return null;
    }

    public static void saveRegistryToExcel(JTable table, String rute) {
        WriteExcelRegistry write = new WriteExcelRegistry(table, rute);
        int returnSave = write.save();
        switch(returnSave){
            
            case 1:
                break;
                
            case -1:
                JOptionPane.showMessageDialog(table, "Error al guardar excel");
                break;
                
            default:
                break;
                
        }

    }

}
