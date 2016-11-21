package com.manjesh.guicedemo.utils;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/18/2016.
 */
public class GuiceUtils {
    private static String dateFormat;

    @Inject
    public static void formatDate( @Named("dateFormat") String format ) {
        GuiceUtils.dateFormat = format;
    }

    public static Date parseDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.parse(date);
    }

}
