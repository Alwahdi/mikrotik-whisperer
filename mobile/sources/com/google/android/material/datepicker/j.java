package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class j implements Comparable<j>, Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new a();
    final int a;

    /* renamed from: a  reason: collision with other field name */
    final long f1737a;

    /* renamed from: a  reason: collision with other field name */
    private String f1738a;

    /* renamed from: a  reason: collision with other field name */
    private final Calendar f1739a;
    final int b;
    final int c;
    final int d;

    private j(Calendar rawCalendar) {
        rawCalendar.set(5, 1);
        Calendar c2 = p.c(rawCalendar);
        this.f1739a = c2;
        this.a = c2.get(2);
        this.b = c2.get(1);
        this.c = c2.getMaximum(7);
        this.d = c2.getActualMaximum(5);
        this.f1737a = c2.getTimeInMillis();
    }

    static j p(long timeInMillis) {
        Calendar calendar = p.k();
        calendar.setTimeInMillis(timeInMillis);
        return new j(calendar);
    }

    static j o(int year, int month) {
        Calendar calendar = p.k();
        calendar.set(1, year);
        calendar.set(2, month);
        return new j(calendar);
    }

    static j q() {
        return new j(p.i());
    }

    /* access modifiers changed from: package-private */
    public int r(int firstDayOfWeek) {
        int difference = this.f1739a.get(7) - (firstDayOfWeek > 0 ? firstDayOfWeek : this.f1739a.getFirstDayOfWeek());
        if (difference < 0) {
            return difference + this.c;
        }
        return difference;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof j)) {
            return false;
        }
        j that = (j) o;
        if (this.a == that.a && this.b == that.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)});
    }

    /* renamed from: i */
    public int compareTo(j other) {
        return this.f1739a.compareTo(other.f1739a);
    }

    /* access modifiers changed from: package-private */
    public int x(j other) {
        if (this.f1739a instanceof GregorianCalendar) {
            return ((other.b - this.b) * 12) + (other.a - this.a);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    /* access modifiers changed from: package-private */
    public long v() {
        return this.f1739a.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public long s(int day) {
        Calendar dayCalendar = p.c(this.f1739a);
        dayCalendar.set(5, day);
        return dayCalendar.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public int t(long date) {
        Calendar dayCalendar = p.c(this.f1739a);
        dayCalendar.setTimeInMillis(date);
        return dayCalendar.get(5);
    }

    /* access modifiers changed from: package-private */
    public j w(int months) {
        Calendar laterMonth = p.c(this.f1739a);
        laterMonth.add(2, months);
        return new j(laterMonth);
    }

    /* access modifiers changed from: package-private */
    public String u() {
        if (this.f1738a == null) {
            this.f1738a = d.f(this.f1739a.getTimeInMillis());
        }
        return this.f1738a;
    }

    class a implements Parcelable.Creator<j> {
        a() {
        }

        /* renamed from: a */
        public j createFromParcel(Parcel source) {
            return j.o(source.readInt(), source.readInt());
        }

        /* renamed from: b */
        public j[] newArray(int size) {
            return new j[size];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.b);
        dest.writeInt(this.a);
    }
}
