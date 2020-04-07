package com.VyTrack.utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtilities {

    /**
     * This method returns current date as a String
     * Provide a format as a parameter
     * MM - to specify month like : 01, 02, 03...
     * MMM - Jan, Feb, Mar...
     * MMMM -
     * dd - to specify day , like 01, 02....23, 24...
     * yyyy - to specify year like: 2010, 2020...
     *
     * @param format for example MMM dd, yyyy - Mar 29, 2020
     * @return current date as a String
     */
    public static String getCurrentDate(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    /**
     * This method returns difference between end and start time
     * @param start time
     * @param end time
     * @param format like: h:m a
     * @return difference between end time and start time as a long
     */
    public static long getTimeDifference(String start, String end, String format){
        LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern(format));
        LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern(format));
        return ChronoUnit.HOURS.between(startTime, endTime);
    }
}
