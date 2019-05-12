/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horaslaborales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class ODBC {

    String url = "jdbc:sqlite:";
    Sesion ses;

    public ODBC(String url, Sesion ses) {
        this.url = this.url.concat(url);
        this.ses = ses;
    }

    private Connection connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void createNewTableUser() {
        // SQLite connection string

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS " + ses.user + "(ID integer PRIMARY KEY,"
                + "start_day text,"
                + "time_start_day text, Ordinaria double, RNocturno double,"
                + "ExtraDiurna double, ExtraNocturna double, SueldoDia double)";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTableTurns() {

        String sql = "CREATE TABLE IF NOT EXISTS " + ses.user + "_Turns" + "(NumTurn integer PRIMARY KEY, NameTurn text,"
                + " HourStart text, HourFinish text)";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {

            System.out.println(e);
        }
    }

    public void createNewTableUsers() {
        // SQLite connection string

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Users(ID integer PRIMARY KEY,"
                + "user text,pass text, last_salary text)";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Agregar usuarios
    public void editSalary(String salary, String user) {
        this.createNewTableUsers();
        if (!selectSalary(user).equals(salary)) {

            String sql = "UPDATE Users SET last_salary = ? WHERE user = ? ";
            try (Connection conn = this.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, salary);
                pstmt.setString(2, user);
                pstmt.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(ODBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public int selectPeriodsPayment() {

        int periods = 0;
        String sql = "SELECT periods_payment FROM Users WHERE user LIKE '" + this.ses.getUser() + "'";
        try (Connection conn = this.connect()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                periods = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ODBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return periods;
    }

    public boolean selectComisions() {

        boolean comisions = false;
        String sql = "SELECT comisions FROM Users WHERE user LIKE '" + ses.getUser() + "'";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                comisions = rs.getBoolean(1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return comisions;
    }

    public void updatePeriodsPayment(int periods) {

        String sql = "UPDATE Users SET periods_payment = ? WHERE User LIKE '" + ses.getUser() + "'";

        try (Connection conn = this.connect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, periods);
            stmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e);
        }
    }

    public void updateTransportationAssistance(boolean transportation) {

        String sql = "UPDATE Users SET transport_assistance = ? WHERE user LIKE '" + this.ses.getUser() + "'";
        try (Connection conn = this.connect()) {

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setBoolean(1, transportation);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public boolean transportAssistance() {

        boolean res = false;
        String sql = "SELECT transport_assistance FROM Users WHERE User LIKE '" + this.ses.getUser() + "'";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                res = rs.getBoolean(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ODBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public void updateTerminationPayment(String terminationPayment) {

        String sql = "UPDATE Users SET termination_payment = ? WHERE User LIKE '" + ses.getUser() + "'";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, terminationPayment);
            pstmt.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(ODBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Double> selectRevenuePeriod(String initialPeriod, String finalPeriod) {

        String sql = "SELECT SueldoDia FROM " + this.ses.getUser() + " WHERE start_day >= '"
                + initialPeriod + "' and start_day <= '" + finalPeriod + "' order by start_day";
        ArrayList<Double> revenues = new ArrayList();

        try (Connection conn = this.connect()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //double d =rs.getDouble(1);
                revenues.add(rs.getDouble(1));
                //System.out.println(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ODBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return revenues;

    }

    public String selectSalary(String user) {
        this.createNewTableUsers();
        String last_salary = "";

        String sql = "SELECT last_salary FROM Users WHERE user LIKE '%" + user + "%'";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                last_salary = rs.getString("last_salary");

            }

        } catch (SQLException ex) {
            Logger.getLogger(ODBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return last_salary;
    }

    public void insert(String date, String time, int[] horas, double sueldo) throws ExceptionLaboralHours {
        //String sql = "INSERT INTO primera_tabla(name,capacity) VALUES(?,?)";

        this.checkRepeatRegistry(date);
        String sql = "INSERT INTO " + ses.user + "(start_day, time_start_day, Ordinaria, RNocturno, ExtraDiurna,"
                + "ExtraNocturna, SueldoDia)\n"
                + " VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, date);
            pstmt.setString(2, time);
            pstmt.setInt(3, horas[0]);
            pstmt.setInt(4, horas[1]);
            pstmt.setInt(5, horas[2]);
            pstmt.setInt(6, horas[3]);
            pstmt.setDouble(7, sueldo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertTurn(Turn turn){
        
        String sql = "INSERT INTO " + ses.getUser()+"_Turns" + "(NameTurn, HourStart, HourFinish) VALUES(?,?,?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, turn.getNameTurn());
            pstmt.setString(2, turn.getHourStart());
            pstmt.setString(3, turn.getHourFinish());
            pstmt.executeUpdate();
            
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public void deleteRegistry(String consult) {

        String sql = "DELETE FROM " + ses.user + " WHERE start_day = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, consult);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void deleteTurn(int IdTurn){
        
        String sql = "DELETE FROM "+ ses.getUser() +"_Turns"+" WHERE NumTurn = "+String.valueOf(IdTurn);
        
        try(Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Registry selectRegistry(String consult) throws ExceptionLaboralHours, ParseException {

        String sql = "SELECT ID,start_day,time_start_day, Ordinaria, RNocturno,"
                + "ExtraDiurna, ExtraNocturna, SueldoDia FROM " + ses.user + " WHERE start_day LIKE '%" + consult + "%'"
                + "ORDER BY start_day ASC";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            Registry reg = new Registry();
            while (rs.next()) {

                CalendarString date = new CalendarString(rs.getString("start_day"));
                reg.setStartDay(date.getDate());
                reg.setOrdinaria(rs.getInt("Ordinaria"));
                reg.setRNocturno(rs.getInt("RNocturno"));
                reg.setExtraDiurna(rs.getInt("ExtraDiurna"));
                reg.setExtranocturna(rs.getInt("ExtraNocturna"));
                reg.setSueldo(rs.getDouble("SueldoDia"));

            }
            return reg;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public ArrayList<Integer> selectRegistriesMonthYear(String year) {
        String sql = "SELECT start_day FROM " + ses.user + " ;";
        ArrayList<Integer> months = new ArrayList();

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                if (months.contains(Integer.valueOf(rs.getString(1).substring(5, 7))) == false
                        & rs.getString(1).contains(year) == true) {
                    months.add(Integer.valueOf(rs.getString(1).substring(5, 7)));

                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return months;
    }

    public ArrayList<String> selectRegistriesYears() {
        String sql = "SELECT start_day FROM " + ses.user + " ;";
        ArrayList<String> years = new ArrayList();

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                if (!years.contains(rs.getString(1).substring(0, 4))) {
                    years.add(rs.getString(1).substring(0, 4));

                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return years;

    }

    public String selectMensualBonuses() {

        String bonus = "";
        String sql2 = "SELECT mensualBonuses FROM Users WHERE user LIKE '" + ses.getUser() + "';";
        try (Connection conn = this.connect()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql2);

            while (rs.next()) {
                bonus = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bonus;
    }

    public ArrayList<Turn> selectTurns() {

        ArrayList<Turn> turns = new ArrayList();
        String sql = "SELECT NumTurn, NameTurn , HourStart, HourFinish FROM " + ses.getUser() + "_Turns";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Turn t = new Turn();
                t.setNum(rs.getInt(1));
                t.setNameTurn(rs.getString(2));
                t.setHourStart(rs.getString(3));
                t.setHourFinish(rs.getString(4));
                turns.add(t);
            }

        } catch (SQLException e) {

        }
        return turns;
    }

    public void updateBonuses(String bonus) {

        String sql = "UPDATE Users SET mensualBonuses = ? WHERE User LIKE '" + ses.getUser() + "'";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, bonus);

            pstmt.executeUpdate();
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void updateComisions(boolean comision) {

        String sql = "UPDATE Users SET comisions = ? WHERE User LIKE '" + ses.getUser() + "'";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setBoolean(1, comision);

            pstmt.executeUpdate();
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Registry> selectMonthRegistries(String consult) throws ParseException {
        ArrayList<Registry> a = new ArrayList();

        String sql = "SELECT ID,start_day,time_start_day, Ordinaria, RNocturno,"
                + "ExtraDiurna, ExtraNocturna, SueldoDia FROM " + ses.user + " WHERE start_day LIKE '%" + consult + "%'"
                + "ORDER BY start_day ASC";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {

                Registry reg = new Registry();
                CalendarString date = new CalendarString(rs.getString("start_day"));
                reg.setStartDay(date.getDate());
                //reg.setID(rs.getInt("ID"));
                reg.setOrdinaria(rs.getInt("Ordinaria"));
                reg.setRNocturno(rs.getInt("RNocturno"));
                reg.setExtraDiurna(rs.getInt("ExtraDiurna"));
                reg.setExtranocturna(rs.getInt("ExtraNocturna"));
                reg.setSueldo(rs.getDouble("SueldoDia"));
                a.add(reg);

            }
            return a;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void update(String date, String time, int[] horas, double sueldo) throws ExceptionLaboralHours {
        String sql = "UPDATE " + ses.user + " SET time_start_day = ?, Ordinaria = ?, RNocturno = ?, ExtraDiurna = ?,"
                + "ExtraNocturna = ?, SueldoDia = ? WHERE start_day = ?";

    }

    private void checkRepeatRegistry(String dato) throws ExceptionLaboralHours {

        Connection con = this.connect();
        try {

            String sql = "SELECT start_day FROM " + ses.user + " WHERE start_day ='" + dato + "'";
            PreparedStatement estatement = con.prepareStatement(sql);
            ResultSet res = estatement.executeQuery();

            if (res.getString("start_day").equals(dato)) {

                throw new ExceptionLaboralHours("Dato repetido");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public String selectTerminationPayment() {

        String terminationPayment = "";
        String sql = "SELECT termination_payment FROM Users WHERE user LIKE '" + ses.getUser() + "';";
        try (Connection conn = this.connect()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                terminationPayment = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return terminationPayment;
    }
}
