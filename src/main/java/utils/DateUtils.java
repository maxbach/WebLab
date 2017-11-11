package utils;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.ISODateTimeFormat;

import javax.servlet.http.HttpServletRequest;

public class DateUtils {

    public static String getDateForUser(String date) {
        return DateTimeFormat.forPattern("dd.MM.yyyy HH.mm.ss")
                .print(ISODateTimeFormat.dateTime().parseDateTime(date));
    }
}
