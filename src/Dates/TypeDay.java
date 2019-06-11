/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dates;

import de.jollyday.Holiday;
import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;
import de.jollyday.ManagerParameter;
import de.jollyday.ManagerParameters;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 *
 * @author Alejandro
 */
public class TypeDay {

    public static int HOLIDAY = 1;
    public static int ORDINARY_DAY = 0;
    LocalDate day;

    public TypeDay(LocalDate day) {
        this.day = day;
    }

    public int getTypeDay() {

        HolidayManager manager = HolidayManager.getInstance("CO"); // get UK HolidayManager

        // create or get the Holidays
        final Set<Holiday> holidays = manager.getHolidays(2019);

        // fill dates into set of LocalDate
        Set<LocalDate> holidayDates = new HashSet<LocalDate>();
        for (Holiday h : holidays) {

            holidayDates.add(h.getDate());

        }

        if (day.getDayOfWeek().getValue() == 7 | holidayDates.contains(day)) {
            return HOLIDAY;
        } else {
            return this.ORDINARY_DAY;
        }

    }

}
