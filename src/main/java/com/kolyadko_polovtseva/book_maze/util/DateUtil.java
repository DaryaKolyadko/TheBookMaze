package com.kolyadko_polovtseva.book_maze.util;

import com.kolyadko_polovtseva.book_maze.exception.DateUtilException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by DaryaKolyadko on 10.12.2016.
 */
public class DateUtil {
    public static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final DateFormat dateFormat;

    static {
        dateFormat = new SimpleDateFormat(DATE_FORMAT);
    }

    public static Date parse(String dateString) {
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new DateUtilException(e);
        }
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}