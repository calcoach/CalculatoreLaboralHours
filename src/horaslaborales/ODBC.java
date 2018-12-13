/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class ODBC {
    
    String url = "jdbc:sqlite:";
    
    public ODBC(String url) {
        this.url = this.url.concat(url);
    }
    
    private Connection connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void createNewTable() {
        // SQLite connection string

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Registros(ID integer PRIMARY KEY,"
                + "start_day text,"
                + "time_start_day text, Ordinaria double, RNocturno double,"
                + "ExtraDiurna double, ExtraNocturna double, SueldoDia double)";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insert(String date, String time, int [] horas, double sueldo) throws ExceptionLaboralHours {
        //String sql = "INSERT INTO primera_tabla(name,capacity) VALUES(?,?)";

        this.checkRepeatRegistry(date);
        String sql = "INSERT INTO Registros(start_day, time_start_day, Ordinaria, RNocturno, ExtraDiurna,"
                + "ExtraNocturna, SueldoDia)\n"
                +" VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, date);
            pstmt.setString(2,time);
            pstmt.setInt(3, horas[0]);
            pstmt.setInt(4, horas[1]);
            pstmt.setInt(5, horas[2]);
            pstmt.setInt(6, horas[3]);
            pstmt.setDouble(7, sueldo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public  Registry selectRegistry(String consult) throws ExceptionLaboralHours, ParseException {
        
        
        String sql = "SELECT ID,start_day,time_start_day, Ordinaria, RNocturno,"
                + "ExtraDiurna, ExtraNocturna, SueldoDia FROM Registros WHERE start_day LIKE '%" + consult + "%'"
                + "ORDER BY start_day ASC" ;
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            Registry reg = new Registry();
            while (rs.next()) {
                
                CalendarString date = new CalendarString(rs.getString("start_day"));
                reg.setStartDay(date.getDate());
                reg.setOrdinaria(rs.getInt("Ordinaria"));
                reg.setRNocturno(rs.getInt("RNocturno"));
                reg.setExtraDiurna(rs.getInt("ExtraDiurna"));
                reg.setExtranocturna(rs.getInt("ExtraNocturna"));
                reg.setSueldo(rs.getDouble("SueldoDia"));
                
               
            }
            return reg;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    
    public ArrayList<Integer> selectRegistriesMonthYear(int year) {
        String sql = "SELECT start_day FROM Registros ;";
        ArrayList <Integer>months = new ArrayList();
        
        try (Connection conn = this.connect(); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

           
            while (rs.next()) {
                
               
                if(!months.contains(Integer.valueOf(rs.getString(1).substring(5, 7)))){
                    months.add(Integer.valueOf(rs.getString(1).substring(5, 7)));
                    
                }
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return months;
    }
    
    public  ArrayList <Registry> selectMonthRegistries(String consult) throws ParseException {
        ArrayList <Registry> a = new ArrayList();
        
        String sql = "SELECT ID,start_day,time_start_day, Ordinaria, RNocturno,"
                + "ExtraDiurna, ExtraNocturna, SueldoDia FROM Registros WHERE start_day LIKE '%" + consult + "%'"
                + "ORDER BY start_day ASC" ;
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                /* System.out.println(rs.getInt("id") + "\t"
                        + rs.getString("name") + "\t".
                        + rs.getDouble("capacity");*/
                Registry reg = new Registry();
                CalendarString date = new CalendarString(rs.getString("start_day"));
                reg.setStartDay(date.getDate());
                //reg.setID(rs.getInt("ID"));
                reg.setOrdinaria(rs.getInt("Ordinaria"));
                reg.setRNocturno(rs.getInt("RNocturno"));
                reg.setExtraDiurna(rs.getInt("ExtraDiurna"));
                reg.setExtranocturna(rs.getInt("ExtraNocturna"));
                reg.setSueldo(rs.getDouble("SueldoDia"));
                a.add(reg);   
               
            }
            return a;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public void update(String start_day, String time_start_day) {
        String sql = "UPDATE Registros SET start_day = ? , "
                + "time_start_day = ? "
                + "WHERE start_day = ?";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, start_day);
            pstmt.setString(2, time_start_day);
            
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void checkRepeatRegistry(String dato) throws ExceptionLaboralHours{
             
        Connection con = this.connect();
        try {
            
            
            String sql = "SELECT start_day FROM Registros WHERE start_day ='" + dato+ "'";
            PreparedStatement estatement =  con.prepareStatement(sql);
            ResultSet res = estatement.executeQuery();
            
            if(res.getString("start_day").equals(dato)){
               throw new ExceptionLaboralHours("Dato repetido");
            }
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
}


