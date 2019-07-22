package com.flaregames.stackoverflow.utility;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * This is utility class to convert epochMillis to datetime in ISO-8601 format
 */
public final class DateConverter {

    /*
    This is done as to not allow object creation
     */
    private DateConverter() {

    }

    /**
     * This method converts the epochMillis to datetime in ISO-8601 calendar system, such as 2017-12-03T10:15:30
     */
    public static String convertToDate(String millisString) {

        LocalDateTime triggerTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(millisString)),
                        TimeZone.getDefault().toZoneId());
        return triggerTime.toString();

    }

}
