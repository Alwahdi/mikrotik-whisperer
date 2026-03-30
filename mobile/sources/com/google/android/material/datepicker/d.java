package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

abstract class d {
    static String f(long timeInMillis) {
        if (Build.VERSION.SDK_INT >= 24) {
            return p.m(Locale.getDefault()).format(new Date(timeInMillis));
        }
        return DateUtils.formatDateTime((Context) null, timeInMillis, 8228);
    }

    static String b(long timeInMillis) {
        return c(timeInMillis, Locale.getDefault());
    }

    static String c(long timeInMillis, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return p.f(locale).format(new Date(timeInMillis));
        }
        return p.e(locale).format(new Date(timeInMillis));
    }

    static String g(long timeInMillis) {
        return h(timeInMillis, Locale.getDefault());
    }

    static String h(long timeInMillis, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return p.n(locale).format(new Date(timeInMillis));
        }
        return p.e(locale).format(new Date(timeInMillis));
    }

    static String d(long timeInMillis) {
        if (i(timeInMillis)) {
            return b(timeInMillis);
        }
        return g(timeInMillis);
    }

    private static boolean i(long timeInMillis) {
        Calendar currentCalendar = p.i();
        Calendar calendarDate = p.k();
        calendarDate.setTimeInMillis(timeInMillis);
        return currentCalendar.get(1) == calendarDate.get(1);
    }

    static String a(Context context, long dayInMillis, boolean isToday, boolean isStartOfRange, boolean isEndOfRange) {
        String dayContentDescription = d(dayInMillis);
        if (isToday) {
            dayContentDescription = String.format(context.getString(sc0.mtrl_picker_today_description), new Object[]{dayContentDescription});
        }
        if (isStartOfRange) {
            return String.format(context.getString(sc0.mtrl_picker_start_date_description), new Object[]{dayContentDescription});
        } else if (!isEndOfRange) {
            return dayContentDescription;
        } else {
            return String.format(context.getString(sc0.mtrl_picker_end_date_description), new Object[]{dayContentDescription});
        }
    }

    static String e(Context context, int year) {
        if (p.i().get(1) == year) {
            return String.format(context.getString(sc0.mtrl_picker_navigate_to_current_year_description), new Object[]{Integer.valueOf(year)});
        }
        return String.format(context.getString(sc0.mtrl_picker_navigate_to_year_description), new Object[]{Integer.valueOf(year)});
    }
}
