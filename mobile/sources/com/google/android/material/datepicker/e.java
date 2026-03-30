package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.a;
import java.util.Arrays;

public class e implements a.c {
    public static final Parcelable.Creator<e> CREATOR = new a();
    private final long a;

    /* synthetic */ e(long x0, a x1) {
        this(x0);
    }

    private e(long point) {
        this.a = point;
    }

    public static e f(long point) {
        return new e(point);
    }

    class a implements Parcelable.Creator<e> {
        a() {
        }

        /* renamed from: a */
        public e createFromParcel(Parcel source) {
            return new e(source.readLong(), (a) null);
        }

        /* renamed from: b */
        public e[] newArray(int size) {
            return new e[size];
        }
    }

    public boolean g(long date) {
        return date >= this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.a);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o instanceof e) && this.a == ((e) o).a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.a)});
    }
}
