package Dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.getInstance;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * This class parse date of calendar to String and String to calendar
 *
 * @author Alejandro
 */
public class CalendarString {

    String date;
    Calendar calendar;
    Date date1;

    public CalendarString(String date) {
        this.date = date;
    }

    public CalendarString() {

    }

    public CalendarString(Calendar calendar) {
        this.calendar = calendar;
    }

    public Date getDate() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(this.date.toString());

        return date;
    }

    public String getStringDate(Date dat) {
        Calendar ncalendar;
        ncalendar = getInstance();
        ncalendar.setTime(dat);
        StringBuilder fecha = new StringBuilder();
        fecha.append(String.valueOf(ncalendar.get(Calendar.YEAR)))
                .append("-");
        if (ncalendar.get(Calendar.MONTH) < 10) {
            fecha.append("0");
        }
        fecha.append(ncalendar.get(Calendar.MONTH) + 1)
                .append("-");

        if (ncalendar.get(Calendar.DAY_OF_MONTH) < 10) {
            fecha.append("0").append(ncalendar.get(Calendar.DAY_OF_MONTH));
        } else {
            fecha.append(ncalendar.get(Calendar.DAY_OF_MONTH));
        }

        return fecha.toString();
    }

    public String getStringDate() {
        StringBuilder fecha = new StringBuilder();
        fecha.append(String.valueOf(calendar.get(Calendar.YEAR)))
                .append("-");
        if (calendar.get(Calendar.MONTH) < 10) {
            fecha.append("0");
        }
        fecha.append(calendar.get(Calendar.MONTH) + 1)
                .append("-");
        if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
            fecha.append("0").append(calendar.get(Calendar.DAY_OF_MONTH));

        } else {
            fecha.append(calendar.get(Calendar.DAY_OF_MONTH));
        }

        return fecha.toString();
    }

    public String getYearMonthString(Date dat) {
        calendar = getInstance();
        calendar.setTime(dat);
        StringBuilder fecha = new StringBuilder();
        fecha.append(String.valueOf(calendar.get(Calendar.YEAR)))
                .append("-")
                .append(calendar.get(Calendar.MONTH) + 1);
        return fecha.toString();
    }

    public static String YearMonthString(int year, int month) {

        StringBuilder fecha = new StringBuilder();
        fecha.append(year)
                .append("-");
        if (month < 10) {
            fecha.append("0").append(month);
        } else {
            fecha.append(month);
        }
        return fecha.toString();
    }

    public static String getNameMounth(int i) {
        String[] names = new String[12];
        names[0] = "Enero";
        names[1] = "Febrero";
        names[2] = "Marzo";
        names[3] = "Abril";
        names[4] = "Mayo";
        names[5] = "Junio";
        names[6] = "Julio";
        names[7] = "Agosto";
        names[8] = "Septiembre";
        names[9] = "Octubre";
        names[10] = "Noviembre";
        names[11] = "Diciembre";

        return names[i - 1];

    }

    public static String getYearMonthByNameMonth(int year, String name) {
        StringBuilder fecha = new StringBuilder();
        switch (name) {
            case "Enero":
                return fecha.append(year).append("-01").toString();
            case "Febrero":
                return fecha.append(year).append("-02").toString();
            case "Marzo":
                return fecha.append(year).append("-03").toString();
            case "Abril":
                return fecha.append(year).append("-04").toString();
            case "Mayo":
                return fecha.append(year).append("-05").toString();
            case "Junio":
                return fecha.append(year).append("-06").toString();
            case "Julio":
                return fecha.append(year).append("-07").toString();
            case "Agosto":
                return fecha.append(year).append("-08").toString();
            case "Septiembre":
                return fecha.append(year).append("-09").toString();
            case "Octubre":
                return fecha.append(year).append("-10").toString();
            case "Noviembre":
                return fecha.append(year).append("-11").toString();
            case "Diciembre":
                return fecha.append(year).append("-12").toString();
            default:
                break;
        }
        return "";
    }

}
