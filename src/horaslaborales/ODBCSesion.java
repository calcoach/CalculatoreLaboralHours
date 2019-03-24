/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    

}
