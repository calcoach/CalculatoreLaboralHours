/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Alejandro
 */
public class NewRegistry {
    
    String nameUser;
    String salary;
    int periods_payment;
    String mensualBonuses;
    String terminationPayment;
    boolean comision;
    boolean transportAssistance;


    public NewRegistry() {
        
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    
      public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getPeriods_payment() {
        return periods_payment;
    }

    public boolean isTransportAssistance() {
        return transportAssistance;
    }
    
    

    public void setPeriods_payment(int periods_payment) {
        this.periods_payment = periods_payment;
    }

    public String getMensualBonuses() {
        return mensualBonuses;
    }

    public void setMensualBonuses(String mensualBonuses) {
        this.mensualBonuses = mensualBonuses;
    }

    public String getTerminationPayment() {
        return terminationPayment;
    }

    public void setTerminationPayment(String terminationPayment) {
        this.terminationPayment = terminationPayment;
    }

    public boolean Comision() {
        return comision;
    }

    public void setComision(boolean comision) {
        this.comision = comision;
    }
    
    public void setTransportAssistance(boolean transportAssistance){
        
        this.transportAssistance = transportAssistance;
    }
    
}
