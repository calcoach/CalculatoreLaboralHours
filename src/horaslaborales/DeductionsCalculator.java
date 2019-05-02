/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class DeductionsCalculator {

    Sesion user;
    ODBC database;
    double currentSalary;
    double health;
    double pension;
    int cut1 = 0;
    int cut2 = 0;

    public void setCut1(int cut1) {

        this.cut1 = cut1;
        recalculateCurrentSalary();
    }

    public void setCut2(int cut2) {

        this.cut2 = cut2;
        recalculateCurrentSalary();
    }

    public DeductionsCalculator(Sesion user) {
        this.user = user;
        database = new ODBC("Prueba.db", user);
        database.createNewTableUser();
        currentSalary = CurrentSalary();
    }

    public void recalculateCurrentSalary() {
        currentSalary = CurrentSalary();
    }

    private double CurrentSalary() {

        String[] periods = getPeriod();
        ArrayList<Double> revenues = database.selectRevenuePeriod(periods[0], periods[1]);
        double salary = 0;

        for (Double revenue : revenues) {

            salary = salary + revenue;

        }

        return salary;
    }

    public double getCurrentSalary() {
        return currentSalary;
    }

    public double getHealth() {
        return currentSalary * 0.04;
    }

    public double getPension() {
        return currentSalary * 0.04;
    }

    public double getTotalDeductions() {
        return getHealth() + getPension();
    }

    public double getTotalIncomes() {
        return currentSalary;
    }

    public double getSalary() {
        return currentSalary - getTotalDeductions();
    }

    public String[] getPeriod() {

        String[] periodsPayment = new String[2];

        int periods = database.selectPeriodsPayment();

        LocalDate localDate = LocalDate.now();
        int day = localDate.getDayOfMonth();

        switch (periods) {

            case 1:
                periodsPayment[0] = localDate.withDayOfMonth(1).toString();
                periodsPayment[1] = (cut2 == 0) ? localDate.withDayOfMonth(localDate.lengthOfMonth()).toString()
                        : localDate.withDayOfMonth(cut2).toString();
                break;

            case 2:
                if (day > 20) {
                    periodsPayment[0] = localDate.withDayOfMonth(15).toString();
                    periodsPayment[1] = (cut2 == 0) ? localDate.withDayOfMonth(localDate.lengthOfMonth()).toString()
                            : localDate.withDayOfMonth(cut2).toString();

                } else {

                    periodsPayment[0] = localDate.withDayOfMonth(1).toString();
                    periodsPayment[1] = (cut2 == 0) ? localDate.withDayOfMonth(16).toString()
                            : localDate.withDayOfMonth(cut2).toString();
                }
                break;

            case 4:

                int actualday = localDate.getDayOfWeek().getValue();

                periodsPayment[0] = localDate.plusDays(-actualday - 1).toString();
                periodsPayment[1] = (cut2 == 0) ? localDate.plusDays(7 - actualday).toString()
                        : localDate.withDayOfMonth(cut2).toString();

            default:
                break;

        }

        return periodsPayment;
    }

    public String getMensualBonuses() {

        String bonuses = String.valueOf(database.selectMensualBonuses());

        return bonuses;
    }

    public String getTerminationPayment() {

        String payment = database.selectTerminationPayment();
        return payment;
    }

}
