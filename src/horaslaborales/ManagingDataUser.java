/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

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
   
   public void updateTerminationPayment(String terminationPayment){
       
       database.updateTerminationPayment(terminationPayment);
   }
   
   public String getTerminationPayment(){
       
       return database.selectTerminationPayment();
   }
   
   public String getBonuses(){
       
       return database.selectMensualBonuses();
   }
   
   public void updateBonuses(String bonus){
       
       database.updateBonuses(bonus);
   }
}
