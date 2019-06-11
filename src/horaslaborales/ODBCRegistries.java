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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.VacationsInability;

/**
 *
 * @author Alejandro
 */
public class ODBCRegistries {

    String url = "jdbc:sqlite:";
    Sesion ses;

    public ODBCRegistries(String url, Sesion ses) {

        this.url = this.url.concat(url);
        this.ses = ses;
        this.createTableVacationsInability();
    }

    private Connection connect() {

        Connection conn = null;

        try {

            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return conn;
    }

    private void createTableVacationsInability() {

        String sql = "CREATE TABLE IF NOT EXISTS " + ses.getUser() + "Vacations_Inability"
                + "(start_day text, finish_day text, sueldo double, type integer)";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {

            Logger.getLogger(ODBC.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean addVacationsInability(String startday, String finishday, double sueldo, int type) {

        String sql = "INSERT INTO " + ses.getUser() + "Vacations_Inability " + "(start_day, finish_day, sueldo, type) "
                + "VALUES(?,?,?,?)";

        if (!cheakRepeat(startday)) {

            try (Connection conn = connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, startday);
                pstmt.setString(2, finishday);
                pstmt.setDouble(3, sueldo);
                pstmt.setInt(4, type);
                pstmt.executeUpdate();
                return true;

            } catch (SQLException e) {

                Logger.getLogger(ODBC.class.getName()).log(Level.SEVERE, null, e);
            }
            
        }
        return false;

    }
    
    public void deleteDataUser(){
        
        String sql = "DROP TABLE IF EXISTS "+ses.user + "Vacations_Inability";
        
        try(Connection conn = connect()){
            
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
           
        } catch(SQLException ex){
            Logger.getLogger(ODBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public ArrayList<VacationsInability> selectVacationsInability() {

        ArrayList<VacationsInability> data = new ArrayList();
        String sql = " SELECT startday, finishday, sueldo, type FROM " + ses.getUser() + "Vacations/Inability";

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                VacationsInability vacIna = new VacationsInability();
                vacIna.setStart_day(rs.getString(1));
                vacIna.setFinishday(rs.getString(2));
                vacIna.setSueldo(rs.getDouble(3));
                vacIna.setType(rs.getInt(4));

                data.add(vacIna);
            }

        } catch (SQLException e) {

            Logger.getLogger(ODBC.class.getName()).log(Level.SEVERE, null, e);
        }

        return data;

    }

    private boolean cheakRepeat(String startday) {

        String sql = "SELECT start_day FROM " + ses.getUser() + "Vacations_Inability UNION SELECT start_day FROM "+
                ses.getUser();

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while(rs.next()){
                
                if(rs.getString(1).equals(startday))
                    return true;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ODBCRegistries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private boolean cheakIntercept(String startday) {

        String sql = "SELECT start_day, finish_day FROM " + ses.getUser() + "Vacations_Inability UNION SELECT start_day, finish_"
                + "day FROM "+ses.getUser();

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while(rs.next()){
                
                
                    return true;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ODBCRegistries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
