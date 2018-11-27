/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class ManagingRegistry {

    public static void saveRegistry(JDateChooser fecha1, JSpinner hora1, JDateChooser fecha2,
            JSpinner hora2, Calculadora cal) {

        try {
            ODBC conect = new ODBC("D://Sincronizado/Bases de Datos/Prueba.db");
            conect.createNewTable();
            Calendar calendar = fecha1.getCalendar();
            StringBuilder fecha = new StringBuilder();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            //Calendar fecha1 = new GregorianCalendar();
            fecha.append(String.valueOf(calendar.get(Calendar.YEAR)))
                    .append("-")
                    .append(calendar.get(Calendar.MONTH) + 1)
                    .append("-")
                    .append(calendar.get(Calendar.DAY_OF_MONTH));
            Date date = formatter.parse(fecha.toString());
            int[] horas = cal.calcularHoras();

            conect.insert(fecha.toString(), fecha.toString(), horas, cal.calcularSueldo()[4]);
            //System.out.println(horas[0]);
        } catch (ParseException ex) {
            Logger.getLogger(ManagingRegistry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "HOla");
        }
    }

    public static void chargueRegistries(JTable table) {

        try {
            ODBC conect = new ODBC("D://Sincronizado/Bases de Datos/Prueba.db");
            ArrayList<Registry> registries = conect.selectRegistries();

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
                
                sumOrdinarios = sumOrdinarios+registry.getOrdinaria();
                sumRNocturno = sumRNocturno+registry.getRNocturno();
                sumExtraDiurna = sumExtraDiurna+registry.getExtraDiurna();
                sumExtraNocturna = sumExtraNocturna+registry.getExtranocturna();
                sumSueldo = sumSueldo+registry.getSueldo();
                
            }
            deftable.addRow(new Object[]{"TOTAL", sumOrdinarios,sumRNocturno, sumExtraDiurna, sumExtraNocturna,
                    sumSueldo});

        } catch (ParseException ex) {
            Logger.getLogger(ManagingRegistry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
