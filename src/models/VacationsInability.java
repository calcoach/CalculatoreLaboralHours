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
public class VacationsInability {
    
    
    String start_day;
    String finishday;
    double sueldo;
    int type;

    public VacationsInability() {
        
    }

    public String getStart_day() {
        return start_day;
    }

    public void setStart_day(String start_day) {
        this.start_day = start_day;
    }

    public String getFinishday() {
        return finishday;
    }

    public void setFinishday(String finishday) {
        this.finishday = finishday;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
}
