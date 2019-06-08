/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.util.ArrayList;
import models.VacationsInability;

/**
 *
 * @author Alejandro
 */
public class ManagingDataUser {
    
   ODBC database ;
   ODBCRegistries databaseReg;
   Sesion user;
   
   public ManagingDataUser(Sesion user){
       this.user = user;
       database = new ODBC("Prueba.db",user);
       databaseReg = new ODBCRegistries("Prueba.db", user);
   }
   
   public void deleteTurn(int IdTurn){
       
       database.deleteTurn(IdTurn);
   }
   
   public void updateTerminationPayment(String terminationPayment){
       
       database.updateTerminationPayment(terminationPayment);
   }
   
   public String getTerminationPayment(){
       
       return database.selectTerminationPayment();
   }
   
   public String getBonuses(){
       
       return database.selectMensualBonuses();
   }
   
   public boolean getComision(){
       
       return database.selectComisions();
   }
   
   public int getPeriodsPayment(){
       
       return database.selectPeriodsPayment();
   }
   
   public double getSalary(){
       
       return Double.valueOf( database.selectSalary(user.getUser()));
   }
   
   public boolean getTransportAssistance(){
       
       return database.transportAssistance();
   }
   
   public ArrayList<VacationsInability> getVacationsInability(){
       
       return databaseReg.selectVacationsInability();
   } 
   
   public ArrayList<Turn> getTurns(){
       
       database.createTableTurns();
       return database.selectTurns();
   }
   
   public void insertVacationsInability(String startday, String finisfday, double sueldo, int type){
       
       databaseReg.addVacationsInability(startday, finisfday, sueldo, type);
   }
   
   public void insertTurn(Turn turn){
       
       database.insertTurn(turn);
   }
    
   public void updateBonuses(String bonus){
       
       database.updateBonuses(bonus);
   }
   
   public void updatePeriodsPayment(int periods){
       
       database.updatePeriodsPayment(periods);
   }
   
   public void updateComisions(boolean comision){
       
       database.updateComisions(comision);
   }
   
   public void updateTransportAssistance(boolean transportAssistance){
       
       database.updateTransportationAssistance(transportAssistance);
   }
           
}
