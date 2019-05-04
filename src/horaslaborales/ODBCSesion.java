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
import models.NewRegistry;

/**
 *
 * @author Alejandro
 */
public class ODBCSesion {

    String url = "jdbc:sqlite:";

    public ODBCSesion(String url) {
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

    public int CheckSesion(String user, String pass) {

        //OJO CORREGIR
        int result = -1;

        String sql = "SELECT user,pass FROM Users";

        System.out.println(user);
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                if (rs.getString(1).equalsIgnoreCase(user)) {
                    result++;
                    if (rs.getString(2).equalsIgnoreCase(pass)) {
                        result++;
                    }
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ODBC.class.getName()).log(Level.SEVERE, null, ex);

        }

        return result;
    }

    public ArrayList<String> getUsers() {

        String sql = "SELECT user FROM Users";
        ArrayList<String> users = new ArrayList();

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                users.add(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ODBC.class.getName()).log(Level.SEVERE, null, ex);

        }
        return users;
    }
    
    public int createUser(NewRegistry reg){
        
        // !!! VALIDAR SI USUAARIO ESTA REPETIDO
               String sql = "INSERT INTO Users(user, last_salary, periods_payment, mensualBonuses, termination_payment,"
                + "comisions, transport_assistance) VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,reg.getNameUser());
            pstmt.setString(2, reg.getSalary());
            pstmt.setInt(3, reg.getPeriods_payment());
            pstmt.setString(4, reg.getMensualBonuses());
            pstmt.setString(5, reg.getTerminationPayment());
            pstmt.setBoolean(6, reg.Comision());
            pstmt.setBoolean(7, reg.isTransportAssistance());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            
            return -1;
        }
        return 1;
    }
    
    

}
