package ca.qc.cstj.android.tp2_android.helpers;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class DateParser {

    //public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:.sss'Z'");
    public static DateTimeFormatter formatter = ISODateTimeFormat.dateTime();

    public static DateTime ParseIso(String strDate) {
        return formatter.parseDateTime(strDate);
    }

    public static DateTime ParseToDate(String strDate) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        return formatter.parseDateTime(strDate);
    }

    public static String ParseToDate(DateTime date) {
        return date.toString("yyyy-MM-dd");
    }

    public static DateTime ParseToTime(String strDate) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("hh:mm");
        return formatter.parseDateTime(strDate);
    }

    public static String ParseToTime(DateTime date) {
        return date.toString("hh:mm");
    }
}
