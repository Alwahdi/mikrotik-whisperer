package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();
    final int a;

    /* renamed from: a  reason: collision with other field name */
    private final b f2129a;
    int b;

    /* renamed from: b  reason: collision with other field name */
    private final b f2130b;
    int c;
    int d;
    int e;

    public e(int hour, int minute, int selection, int format) {
        this.b = hour;
        this.c = minute;
        this.d = selection;
        this.a = format;
        this.e = m(hour);
        this.f2129a = new b(59);
        this.f2130b = new b(format == 1 ? 23 : 12);
    }

    protected e(Parcel in) {
        this(in.readInt(), in.readInt(), in.readInt(), in.readInt());
    }

    private static int m(int hourOfDay) {
        return hourOfDay >= 12 ? 1 : 0;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d)});
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof e)) {
            return false;
        }
        e that = (e) o;
        if (this.b == that.b && this.c == that.c && this.a == that.a && this.d == that.d) {
            return true;
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.b);
        dest.writeInt(this.c);
        dest.writeInt(this.d);
        dest.writeInt(this.a);
    }

    class a implements Parcelable.Creator<e> {
        a() {
        }

        /* renamed from: a */
        public e createFromParcel(Parcel in) {
            return new e(in);
        }

        /* renamed from: b */
        public e[] newArray(int size) {
            return new e[size];
        }
    }

    public static String f(Resources resources, CharSequence text) {
        return i(resources, text, "%02d");
    }

    public static String i(Resources resources, CharSequence text, String format) {
        try {
            return String.format(resources.getConfiguration().locale, format, new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(text)))});
        } catch (NumberFormatException e2) {
            return null;
        }
    }
}
