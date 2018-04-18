package com.amr.core.util;

import android.content.Context;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import timber.log.Timber;

public class TimeUtil {

    private static final String HOUR_FORMAT_24 = "H:mm";
    private static final String HOUR_FORMAT_12 = "h:mm a";

    private final DateFormat hourFormatter;

    @Inject
    TimeUtil(Context context) {
        boolean is24HourFormat = android.text.format.DateFormat.is24HourFormat(context);
        String format = is24HourFormat ? HOUR_FORMAT_24 : HOUR_FORMAT_12;
        hourFormatter = new SimpleDateFormat(format, Locale.getDefault());
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public String formatHour(long timeStamp) {
        return hourFormatter.format(new Date(timeStamp));
    }

    public Date convertStringToDate2(String dateStr, String timeStr) {
        /*
        String iso8601 = dateStr.concat("T").concat(timeStr).concat("Z");
        return Instant.parse(iso8601)
                .toEpochMilli();*/
        String dataTime = dateStr+" "+timeStr;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse(dataTime);
        } catch (ParseException e) {
            Timber.d(e);
        }
        return date;
    }

    public Date convertStringToDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            Timber.d(e);
        }
        return date;
    }

    public String getTimeFromDate(String dateStr) {
        Date dt = convertStringToDate(dateStr);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
        String time1 = sdf.format(dt);
        return time1;
    }

}
