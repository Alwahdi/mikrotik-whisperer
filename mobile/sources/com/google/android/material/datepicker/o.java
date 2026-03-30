package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

class o {
    private static final o a = new o((Long) null, (TimeZone) null);

    /* renamed from: a  reason: collision with other field name */
    private final Long f1751a;

    /* renamed from: a  reason: collision with other field name */
    private final TimeZone f1752a;

    private o(Long fixedTimeMs, TimeZone fixedTimeZone) {
        this.f1751a = fixedTimeMs;
        this.f1752a = fixedTimeZone;
    }

    static o c() {
        return a;
    }

    /* access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f1752a);
    }

    /* access modifiers changed from: package-private */
    public Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.f1751a;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }
}
