/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.util.Scanner;

/**
 *
 * @author Alejandro
 */
public class Calculadora {

    int inicio;
    int fin;
    int dia; //Refers to type of turn: 1 to 4
    int sueldo;
    double valorhora;
    int contT = 0;

    public Calculadora(int inicio, int fin, int sueldo) {
        this.inicio = inicio;
        this.fin = fin;
        this.sueldo = sueldo;
        valorhora = (sueldo * 1.0) / 240;

    }

    public int[] calcularHoras(int inicio, int fin) {

        int i = inicio; 
        int cont = 0;
        if(dia==3 | dia==4){
            cont = contT;
            
        }
        
        int[] horas = new int[5];

        while (i != fin) {

            cont++;
            if (i == 24) {
                i = 1;
            } else {
                i++;
            }

            if (i > 6 & i <= 21) {

                if (cont <= 8) {
                    horas[0] = horas[0] + 1;
                } else {
                    horas[2] = horas[2] + 1;
                }

            }

            if (i > 21 | i <= 6) {

                if (cont <= 8) {
                    horas[1] = horas[1] + 1;
                } else {
                    horas[3] = horas[3] + 1;
                }
            }

        }
        horas[4] = horas[0] + horas[1] + horas[2] + horas[3];
        contT = cont;
        return horas;
    }
    
    public int [] calcularHoras(){
        
        if(dia==1 | dia==2){
            
            return calcularHoras(inicio, fin);
        }else{
            
            int [] horas1 = calcularHoras(inicio, 24);
            int [] horas2 = calcularHoras(0,fin);
            int [] horasT = new int [11];
            horasT[0] = horas1[0]; //Horas ordinarias
            horasT[1] = horas1[1];//Horas recargo ordinario
            horasT[2] = horas1[2];//Extra diurno ordinario
            horasT[3] = horas1[3];//Extra nocturno hordinario
            horasT[4] = horas1[4];//Total dia 1
            horasT[5] = horas2[0];//Horas festivo
            horasT[6] = horas2[1];//Horas recargo festivo
            horasT[7] = horas2[2];//Horas Extra diurno festivo
            horasT[8] = horas2[3];//Horas Extra recargo nocturno
            horasT[9] = horas2[4];//Horas Totales dia 2
            horasT[10] = horas1[4] + horas2[4];//Total horas
            
            return horasT;
        }
        
        
        
        
    }

    public double[] calcularSueldo() {

        int[] horas = this.calcularHoras();
        double[] subhoras = null;
        
        switch (dia){
            
            case 1:
                subhoras = sueldoDiaOrdinario(horas);
                break;
                
            case 2: 
                subhoras = sueldoDiaFestivo(horas);
                break;
                        
            case 3:
                contT=0;
                int [] horasdia1 = calcularHoras(inicio, 24);
                int [] horasdia2 = calcularHoras(0,fin);
                
                double [] sueldo1 = sueldoDiaOrdinario(horasdia1);
                double [] sueldo2 = sueldoDiaFestivo(horasdia2);
                subhoras = new double [11];
                subhoras[0] = sueldo1[0];//Dia 1
                subhoras[1] = sueldo1[1];
                subhoras[2] = sueldo1[2];
                subhoras[3] = sueldo1[3];
                subhoras[4] = sueldo1[4];
                subhoras[5] = sueldo2[0];//Dia 2
                subhoras[6] = sueldo2[1];
                subhoras[7] = sueldo2[2];
                subhoras[8] = sueldo2[3];
                subhoras[9] = sueldo2[4];
                subhoras[10] =sueldo1[4]+sueldo2[4];
                
                break;
                
            case 4:
                contT = 0;
                int [] Horasdia1 = calcularHoras(inicio, 24);
                int [] Horasdia2 = calcularHoras(0,fin);
                
                double [] Sueldo1 = sueldoDiaFestivo(Horasdia1);
                double [] Sueldo2 = sueldoDiaOrdinario(Horasdia2);
                subhoras = new double [11];
                subhoras[0] = Sueldo1[0];//Dia 1
                subhoras[1] = Sueldo1[1];
                subhoras[2] = Sueldo1[2];
                subhoras[3] = Sueldo1[3];
                subhoras[4] = Sueldo1[4];
                subhoras[5] = Sueldo2[0];//Dia 2
                subhoras[6] = Sueldo2[1];
                subhoras[7] = Sueldo2[2];
                subhoras[8] = Sueldo2[3];
                subhoras[9] = Sueldo2[4];
                subhoras[10] =Sueldo1[4]+Sueldo2[4];
                
                break;
                
                
            default:
                break;
                    
        }

        return subhoras;
    }

    private double[] sueldoDiaOrdinario(int horas[]) {

        double[] subhoras = new double[5];
        subhoras[0] = (horas[0] * valorhora);
        subhoras[1] = (horas[1] * valorhora * 1.35);//REcargo dia ordinzrio
        subhoras[2] = (horas[2] * valorhora * 1.25);//Extra diurno
        subhoras[3] = (horas[3] * valorhora * 1.75);//Extra nocturno
        subhoras[4] = subhoras[0] + subhoras[1] + subhoras[2] + subhoras[3];
        return subhoras;
    }

    private double[] sueldoDiaFestivo(int horas[]) {

        double[] subhoras = new double[5];
        subhoras[0] = (horas[0] * valorhora * 1.75);//Verificar   festivo
        subhoras[1] = (horas[1] * valorhora * 2.1);//Recargo festivo
        subhoras[2] = (horas[2] * valorhora * 2);//Extra diurno festivo
        subhoras[3] = (horas[3] * valorhora * 2.5);//Extra recargo festivo
        subhoras[4] = subhoras[0] + subhoras[1] + subhoras[2] + subhoras[3];
        return subhoras;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
}
