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
public class Calculator {

    int inicio;
    int fin;
    int dia; //Refers to type of turn: 1 to 4
    int sueldo;
    double valorhora;
    int contT = 0;
    boolean nextDay = false;

    public Calculator(int inicio, int fin, int sueldo) {
        this.inicio = inicio;
        this.fin = fin;
        this.sueldo = sueldo;
        valorhora = (sueldo * 1.0) / 240;

    }

    public void setNextDay(boolean nextDay) {
        this.nextDay = nextDay;
    }

    public int[] calcularHoras(int inicio, int fin) {

        int i = inicio;
        int cont = 0;

        int[] horas = new int[5];
        if(inicio == 24)
          i=0;

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

        return horas;
    }

    public int[] calcularHoras() {

        if (inicio < fin & !nextDay |(fin == 24 & nextDay)) {

            return calcularHoras(inicio, fin);

        } else if (inicio == 24 & nextDay & fin == 24) {

            int[] horas1 = calcularHoras(0, 24);

            return horas1;
        } else if (inicio == 24 & !nextDay) {

            return calcularHoras(0, fin);

        }else if (nextDay) {

            int[] horas1 = calcularHoras(inicio, 24);
            int[] horas2 = calcularHoras(24, fin);
            int[] horasT = twoDaysHours(horas1, horas2);

            return horasT;

        }

        return null;
    }

    private int[] twoDaysHours(int[] horas1, int[] horas2) {

        int[] horasT = new int[11];
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

    private int[] hoursDay1(int[] horas) {

        int[] horasT = new int[5];
        horasT[0] = horas[0]; //Horas ordinarias
        horasT[1] = horas[1];//Horas recargo ordinario
        horasT[2] = horas[2];//Extra diurno ordinario
        horasT[3] = horas[3];//Extra nocturno hordinario
        horasT[4] = horas[4];//Total dia 1
        return horasT;
    }

    private int[] hoursDay2(int[] horas) {

        int[] horasT = new int[5];
        horasT[0] = horas[5]; //Horas festivo
        horasT[1] = horas[6];//Horas recargo festivo
        horasT[2] = horas[7];//Extra diurno festivo
        horasT[3] = horas[8];//Extra nocturno festivo
        horasT[4] = horas[9];//Total dia 1
        return horasT;
    }

    public double[] calcularSueldo() {

        int[] horas = this.calcularHoras();
        double[] subhoras = null;

        switch (dia) {

            case 1:
                if (horas.length <= 5) {

                    subhoras = sueldoDiaOrdinario(horas);
                } else {

                    double[] sueldo1 = sueldoDiaOrdinario(hoursDay1(horas));
                    double[] sueldo2 = sueldoDiaOrdinario(hoursDay2(horas));

                    subhoras = twoDaysSueldo(sueldo1, sueldo2);
                }

                break;

            case 2:
                subhoras = sueldoDiaFestivo(horas);

                break;

            case 3:

                if (horas.length <= 5) {

                    subhoras = sueldoDiaOrdinario(horas);
                } else {

                    double[] sueldo1 = sueldoDiaOrdinario(hoursDay1(horas));
                    double[] sueldo2 = sueldoDiaFestivo(hoursDay2(horas));

                    subhoras = twoDaysSueldo(sueldo1, sueldo2);
                }

                break;

            case 4:

                if (horas.length <= 5) {

                    subhoras = sueldoDiaOrdinario(horas);
                } else {

                    double[] sueldo1 = sueldoDiaFestivo(hoursDay1(horas));
                    double[] sueldo2 = sueldoDiaOrdinario(hoursDay2(horas));

                    subhoras = twoDaysSueldo(sueldo1, sueldo2);
                }

                break;

            default:
                break;

        }

        return subhoras;
    }

    private double[] twoDaysSueldo(double[] sueldo1, double[] sueldo2) {

        double[] subhoras = new double[11];
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
        subhoras[10] = sueldo1[4] + sueldo2[4];

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

    public void setContT(int contT) {
        this.contT = contT;
    }

}
