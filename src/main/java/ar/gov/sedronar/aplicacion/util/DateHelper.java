package ar.gov.sedronar.aplicacion.util;


import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateHelper {
    public static Date getDateWithoutTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getTomorrowDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    /**
     * @param date Una fecha
     * @return Retorna el numero del mes, empezando a contar desde 1.
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static Date getSimpleDate(Date d) {
        String dateString = DateHelper.getDay(d) + "-" + DateHelper.getMonth(d) + "-" + DateHelper.getYear(d);
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Integer getDifferenceInMinutesBetween(Date fechaHasta, Date fechaDesde) {
        long diff = fechaHasta.getTime() - fechaDesde.getTime();
        Long diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diff);
        return diffMinutes != null ? diffMinutes.intValue() : null;
    }

    public static String getStringDate() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(now);
    }

    public static Integer getDifferenceInHoursBetween(String egreso, String ingreso) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date fechaDesde = null;
        Date fechaHasta = null;
        try {
            fechaDesde = sdf.parse(ingreso);
            fechaHasta = sdf.parse(egreso);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        long diff = fechaHasta.getTime() - fechaDesde.getTime();
        Long diffMinutes = TimeUnit.MILLISECONDS.toHours(diff);
        return diffMinutes != null ? diffMinutes.intValue() : null;
    }

    public static Integer getDifferenceInDaysBetween(Date fechaHasta, Date fechaDesde) {
        return daysBetweenUsingJoda(fechaHasta, fechaDesde);
    }

    public static int daysBetweenUsingJoda(Date d1, Date d2) {
        return Days.daysBetween(new LocalDate(d1.getTime()),
                new LocalDate(d2.getTime())).getDays();
    }

    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static Date getDateFromTime(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return cal.getTime();
    }
}
