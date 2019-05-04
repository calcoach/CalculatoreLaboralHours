/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author Alejandro
 */
public class WriteExcelRegistry {
    
    private JTable table;
    private String rute;        
    
    public WriteExcelRegistry(JTable model, String rute){
        
        this.table = model;
        this.rute = rute;
    }
    
    public int save(){
        DefaultTableModel deftable = (DefaultTableModel) table.getModel();
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
       
        
        SXSSFSheet sheet = wb.createSheet();

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
            sheet.setDefaultColumnWidth(24);

        // Write the output to a file
        try (OutputStream fileOut = new FileOutputStream(rute+".xlsx")) {
            wb.write(fileOut);
            wb.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManagingRegistry.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException ex) {
            Logger.getLogger(ManagingRegistry.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        return 1;
    }

    private static void createHead(JTable table, SXSSFWorkbook wb, Row row, int column, 
            HorizontalAlignment halign, VerticalAlignment valign) {

        if (column <= table.getColumnCount() - 1) {
            Cell cell = row.createCell(column);
            cell.setCellValue(table.getColumnName(column));
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(halign);
            cellStyle.setVerticalAlignment(valign);
            cellStyle.setBorderBottom(BorderStyle.DOUBLE);
            cellStyle.setBorderTop(BorderStyle.DOUBLE);
            cellStyle.setBorderLeft(BorderStyle.DOUBLE);
            cellStyle.setBorderRight(BorderStyle.DOUBLE);

            cell.setCellStyle(cellStyle);
            createHead(table, wb, row, column + 1, halign, valign);
        }
    }
    
    private static void createCell(Vector data, SXSSFWorkbook wb, Row row, int column, 
            HorizontalAlignment halign, VerticalAlignment valign) {

        if (column <= data.size() - 1) {
            Cell cell = row.createCell(column);
            setValueCell(data, cell, column);
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(halign);
            cellStyle.setVerticalAlignment(valign);
            cellStyle.setBorderBottom(BorderStyle.HAIR);
            cellStyle.setBorderTop(BorderStyle.HAIR);
            cellStyle.setBorderLeft(BorderStyle.HAIR);
            cellStyle.setBorderRight(BorderStyle.HAIR);

            cell.setCellStyle(cellStyle);
            createCell(data, wb, row, column + 1, halign, valign);
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
