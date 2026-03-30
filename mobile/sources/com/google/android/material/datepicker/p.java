package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

abstract class p {
    static AtomicReference<o> a = new AtomicReference<>();

    static o g() {
        o timeSource = a.get();
        return timeSource == null ? o.c() : timeSource;
    }

    private static TimeZone h() {
        return TimeZone.getTimeZone("UTC");
    }

    private static android.icu.util.TimeZone j() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static Calendar i() {
        Calendar today = g().a();
        today.set(11, 0);
        today.set(12, 0);
        today.set(13, 0);
        today.set(14, 0);
        today.setTimeZone(h());
        return today;
    }

    static Calendar k() {
        return l((Calendar) null);
    }

    static Calendar l(Calendar rawCalendar) {
        Calendar utc = Calendar.getInstance(h());
        if (rawCalendar == null) {
            utc.clear();
        } else {
            utc.setTimeInMillis(rawCalendar.getTimeInMillis());
        }
        return utc;
    }

    static Calendar c(Calendar rawCalendar) {
        Calendar rawCalendarInUtc = l(rawCalendar);
        Calendar utcCalendar = k();
        utcCalendar.set(rawCalendarInUtc.get(1), rawCalendarInUtc.get(2), rawCalendarInUtc.get(5));
        return utcCalendar;
    }

    static long a(long rawDate) {
        Calendar rawCalendar = k();
        rawCalendar.setTimeInMillis(rawDate);
        return c(rawCalendar).getTimeInMillis();
    }

    private static DateFormat b(String pattern, Locale locale) {
        DateFormat format = DateFormat.getInstanceForSkeleton(pattern, locale);
        format.setTimeZone(j());
        format.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return format;
    }

    private static java.text.DateFormat d(int style, Locale locale) {
        java.text.DateFormat format = java.text.DateFormat.getDateInstance(style, locale);
        format.setTimeZone(h());
        return format;
    }

    static DateFormat m(Locale locale) {
        return b("yMMMM", locale);
    }

    static DateFormat f(Locale locale) {
        return b("MMMMEEEEd", locale);
    }

    static DateFormat n(Locale locale) {
        return b("yMMMMEEEEd", locale);
    }

    static java.text.DateFormat e(Locale locale) {
        return d(0, locale);
    }
}
