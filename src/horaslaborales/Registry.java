/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class Registry {
    
    int ID;
    Date startDay;
    Date time_startDay;
    Date finishDay;
    Date time_finishDay;
    int Ordinaria;
    int RNocturno;
    int ExtraDiurna;
    int Extranocturna;
    double sueldo;

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
  
    public Registry(){
        
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getTime_startDay() {
        return time_startDay;
    }

    public void setTime_startDay(Date time_startDay) {
        this.time_startDay = time_startDay;
    }

    public Date getFinishDay() {
        return finishDay;
    }

    public void setFinishDay(Date finishDay) {
        this.finishDay = finishDay;
    }

    public Date getTime_finishDay() {
        return time_finishDay;
    }

    public void setTime_finishDay(Date time_finishDay) {
        this.time_finishDay = time_finishDay;
    }

    public int getOrdinaria() {
        return Ordinaria;
    }

    public void setOrdinaria(int Ordinaria) {
        this.Ordinaria = Ordinaria;
    }

    public int getRNocturno() {
        return RNocturno;
    }

    public void setRNocturno(int RNocturno) {
        this.RNocturno = RNocturno;
    }

    public int getExtraDiurna() {
        return ExtraDiurna;
    }

    public void setExtraDiurna(int ExtraDiurna) {
        this.ExtraDiurna = ExtraDiurna;
    }

    public int getExtranocturna() {
        return Extranocturna;
    }

    public void setExtranocturna(int Extranocturna) {
        this.Extranocturna = Extranocturna;
    }
    
    
    
    
    
    
}
