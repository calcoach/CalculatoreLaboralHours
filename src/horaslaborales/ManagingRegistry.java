/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

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
public class ManagingRegistry {

    public static String URL_ODBC = "Prueba.db";
    private Sesion ses;
    ODBC conect;

    public ManagingRegistry(Sesion sesion) {
       
        ses = sesion;
        conect = new ODBC(URL_ODBC, ses);
        conect.createNewTableUser();
    }

    public void updateLastSalary(JTextField salary) {

        conect.editSalary(FieldString.deleteWhiteSpaces(salary.getText()), ses.getUser());

    }

    public void getSalary(JTextField salary, String user) {

        
        String s = conect.selectSalary(user);
        salary.setText(FieldString.fieldNum(s));

    }

    //Modificacion en registro: Incluir hora de inicio y hora fin
    public boolean saveRegistry(JDateChooser fecha1, JDateChooser fecha2, Calculator cal) {

        try {

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

        return false;
    }

    //MOdificacion en registro: Incluir hora de inicio y hora fin
    public void updateRegistry(JDateChooser fecha1, JDateChooser fecha2, Calculator cal) {

        try {

            CalendarString date = new CalendarString(fecha1.getCalendar());

            int[] horas = cal.calcularHoras();

            conect.update(date.getStringDate(), date.getStringDate(), horas, cal.calcularSueldo()[4]);

        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error");
        } catch (ExceptionLaboralHours e) {
            JOptionPane.showMessageDialog(null, "Fecha ocupada por otro registro");
        }
    }

    public void chargueMonthRegistries(JComboBox JCombo, JTable table, JComboBox year) {

        //ComboBox Year need contain year
        if (year.getItemCount() > 0) {

            int yearInt = Integer.valueOf((String) year.getSelectedItem());
            if (JCombo.getItemCount() == 0) {

                ArrayList<Integer> registries = conect.selectRegistriesMonthYear((String) year.getSelectedItem());

                for (Integer registry : registries) {

                    JCombo.addItem(CalendarString.getNameMounth(registry));

                }

                chargueRegistries(table, CalendarString.getYearMonthByNameMonth(yearInt,
                        (String) JCombo.getSelectedItem()));

            } else {

                chargueRegistries(table, CalendarString.getYearMonthByNameMonth(yearInt,
                        (String) JCombo.getSelectedItem()));
            }

        }

    }

    public void chargueYearRegistries(JComboBox year) {

        ArrayList<String> registries = conect.selectRegistriesYears();

        year.removeAllItems();

        for (String registry : registries) {

            year.addItem(registry);

        }

        int n = year.getItemCount();
        year.setSelectedIndex(n - 1);
    }

    private void chargueRegistries(JTable table, String consult) {

        try {

            ArrayList<Registry> registries = conect.selectMonthRegistries(consult);

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
            Logger.getLogger(ManagingRegistry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRegistry(String date) {

        conect.deleteRegistry(date);

    }

    public Registry searchRegistry(String consult) {

        try {

            return conect.selectRegistry(consult);
        } catch (ExceptionLaboralHours ex) {
            Logger.getLogger(ManagingRegistry.class.getName()).log(Level.SEVERE, null, ex);
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

}
