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
public class Turn {
    
    int num;
    String nameTurn;
    String hourStart;
    String hourFinish;
    
    public Turn(){
        
    }

    public Turn(String nameTurn, String hourStart, String hourFinish) {
        this.nameTurn = nameTurn;
        this.hourStart = hourStart;
        this.hourFinish = hourFinish;
    }
    
    

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNameTurn() {
        return nameTurn;
    }

    public void setNameTurn(String nameTurn) {
        this.nameTurn = nameTurn;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    public String getHourFinish() {
        return hourFinish;
    }

    public void setHourFinish(String hourFinish) {
        this.hourFinish = hourFinish;
    }
    
    
    
}
