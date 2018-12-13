/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import com.toedter.calendar.JDateChooser;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author Alejandro
 */
public class ManagingRegistry {

    public static String URL_ODBC = "Prueba.db";

    public static void saveRegistry(JDateChooser fecha1, JSpinner hora1, JDateChooser fecha2,
            JSpinner hora2, Calculadora cal) {

        try {
            ODBC conect = new ODBC(URL_ODBC);
            conect.createNewTable();
            CalendarString date = new CalendarString(fecha1.getCalendar());

            int[] horas = cal.calcularHoras();

            conect.insert(date.getStringDate(), date.getStringDate(), horas, cal.calcularSueldo()[4]);
            //System.out.println(horas[0]);
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

    public static void saveRegistryToExcel(JTable table) {
        DefaultTableModel deftable = (DefaultTableModel) table.getModel();

        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        Sheet sheet = wb.createSheet();

        Row head = sheet.createRow(0);
        head.setHeightInPoints(20);

        createHead(table, wb, head, 0, HorizontalAlignment.CENTER, VerticalAlignment.CENTER);

        int N = deftable.getDataVector().size();

        for (int it = 0; it < N; it++) {
            Vector j = (Vector) deftable.getDataVector().elementAt(it);

            Row row = sheet.createRow(it + 1);
            row.setHeightInPoints(20);

            createCell(j, wb, row, 0, HorizontalAlignment.CENTER, VerticalAlignment.CENTER);

        }

        // Write the output to a file
        try (OutputStream fileOut = new FileOutputStream("Registro.xlsx")) {
            wb.write(fileOut);
            wb.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManagingRegistry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManagingRegistry.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void createCell(Vector data, Workbook wb, Row row, int column, HorizontalAlignment halign, VerticalAlignment valign) {

        if (column <= data.size() - 1) {
            Cell cell = row.createCell(column);
            setValueCell(data, cell, column);
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(halign);
            cellStyle.setVerticalAlignment(valign);

            cell.setCellStyle(cellStyle);
            createCell(data, wb, row, column + 1, halign, valign);
        }

    }

    //Crea la cabecera
    private static void createHead(JTable table, Workbook wb, Row row, int column, HorizontalAlignment halign, VerticalAlignment valign) {

        if (column <= table.getColumnCount() - 1) {
            Cell cell = row.createCell(column);
            cell.setCellValue(table.getColumnName(column));
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(halign);
            cellStyle.setVerticalAlignment(valign);

            cell.setCellStyle(cellStyle);
            createHead(table, wb, row, column + 1, halign, valign);
        }
    }

    private static void setValueCell(Vector data, Cell cell, int n) {

        if (data.get(n).getClass().getName().equals(Integer.class.getName())) {
            double d = (int) ((int) data.get(n));

            cell.setCellValue(d);

        } else if (data.get(n).getClass().getName().equals(Double.class.getName())) {
            cell.setCellValue((Double) data.get(n));

        } else {
            cell.setCellValue(String.valueOf(data.get(n)));
        }
    }

}
