/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class ManagingDataUser {
    
   ODBC database ;
   Sesion user;
   
   public ManagingDataUser(Sesion user){
       this.user = user;
       database = new ODBC("Prueba.db",user);
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
   
   public boolean getTransportAssistance(){
       
       return database.transportAssistance();
   }
   
   public ArrayList<Turn> getTurns(){
       
       database.createTableTurns();
       return database.selectTurns();
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
