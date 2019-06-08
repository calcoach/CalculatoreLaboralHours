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
    
    private void createTableVacationsInability(){
        
        String sql = "CREATE TABLE IF NOT EXISTS " + ses.getUser() + "Vacations/Inability"+" "
                + "(start_day text, finish_day text, sueldo double, type integer)";
        
        try(Connection conn = this.connect();
                Statement stmt = conn.createStatement()){
            
            stmt.execute(sql);
        } catch (SQLException e){
            
            System.out.println(e);
        }
    }
    
    
    public void addVacationsInability(String startday,String finishday, double sueldo, int type){
        
        String sql = "INSERT INTO "+ ses.getUser()+"Vacations/Inability "+"(start_day, finish_day, sueldo, type) "
                + "VALUES(?,?,?,?)";
        
        try ( Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, startday);
            pstmt.setString(2, finishday);
            pstmt.setDouble(3, sueldo);
            pstmt.setInt(4, type);
            pstmt.executeUpdate();
            
        } catch(SQLException e){
            
            System.out.println(e);
        }
    }
    
    public ArrayList<VacationsInability> selectVacationsInability(){
        
        ArrayList<VacationsInability> data = new ArrayList();
        String sql = " SELECT startday, finishday, sueldo, type FROM "+ses.getUser()+"Vacations/Inability";
        
        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                
                VacationsInability vacIna = new VacationsInability();
                vacIna.setStart_day( rs.getString(1));
                vacIna.setFinishday(rs.getString(2));
                vacIna.setSueldo(rs.getDouble(3));
                vacIna.setType(rs.getInt(4));
                
                data.add(vacIna);
            }
            
        } catch (SQLException e){
            
            System.out.println(e);
        }
        
        return data;
        
    }
    
    

}
