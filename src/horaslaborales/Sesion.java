/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Sesion {
    
    String user;
    String pass;
    public static String URL_ODBC = "Prueba.db";
    boolean checkLogin=false;

    public Sesion(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
    public int login(){
       
        ODBCSesion ses = new ODBCSesion(URL_ODBC);
        return ses.CheckSesion(user, pass);
        
    }

    public String getUser() {
        return user;
    }
    
    
    
            
}
