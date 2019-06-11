/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.time.LocalDate;
import models.Turn;
import java.util.ArrayList;
import models.VacationsInability;

/**
 *
 * @author Alejandro
 */
public class ManagingDataUser extends DataUser {
 
    ODBCRegistries databaseReg;

    public ManagingDataUser(Sesion user) {
        super(user);
        this.user = user;
        //database = new ODBC("Prueba.db", user);
        databaseReg = new ODBCRegistries("Prueba.db", user);
    }

    public void deleteUser() {

        database.deleteUser();
        databaseReg.deleteDataUser();
    }

    public void deleteTurn(int IdTurn) {

        database.deleteTurn(IdTurn);
    }

    public void updateTerminationPayment(String terminationPayment) {

        database.updateTerminationPayment(terminationPayment);
    }

    public String getTerminationPayment() {

        return database.selectTerminationPayment();
    }

    public String getBonuses() {

        return database.selectMensualBonuses();
    }

    public boolean getComision() {

        return database.selectComisions();
    }

    public int getPeriodsPayment() {

        return database.selectPeriodsPayment();
    }

    public String getNextPayment() {

        return this.getPeriod()[1];

    }

    public double getSalary() {

        return Double.valueOf(database.selectSalary(user.getUser()));
    }

    public boolean getTransportAssistance() {

        return database.transportAssistance();
    }

    public ArrayList<VacationsInability> getVacationsInability() {

        return databaseReg.selectVacationsInability();
    }

    public ArrayList<Turn> getTurns() {

        database.createTableTurns();
        return database.selectTurns();
    }

    public boolean insertVacationsInability(String startday, String finisfday, double sueldo, int type) {

        return databaseReg.addVacationsInability(startday, finisfday, sueldo, type);
    }

  /*  public String[] getPeriod() {

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
    }*/

    public void insertTurn(Turn turn) {

        database.insertTurn(turn);
    }

    public void updateBonuses(String bonus) {

        database.updateBonuses(bonus);
    }

    public void updatePeriodsPayment(int periods) {

        database.updatePeriodsPayment(periods);
    }

    public void updateComisions(boolean comision) {

        database.updateComisions(comision);
    }

    public void updateTransportAssistance(boolean transportAssistance) {

        database.updateTransportationAssistance(transportAssistance);
    }

}
