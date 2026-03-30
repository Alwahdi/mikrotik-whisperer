package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;

public final class Status extends x implements ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new b();
    public static final Status a = new Status(0);
    public static final Status b = new Status(14);
    public static final Status c = new Status(8);
    public static final Status d = new Status(15);
    public static final Status e = new Status(16);
    private static final Status f = new Status(17);
    public static final Status g = new Status(18);

    /* renamed from: a  reason: collision with other field name */
    private final int f1381a;

    /* renamed from: a  reason: collision with other field name */
    private final PendingIntent f1382a;

    /* renamed from: a  reason: collision with other field name */
    private final String f1383a;

    /* renamed from: b  reason: collision with other field name */
    private final int f1384b;

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f1381a = i;
        this.f1384b = i2;
        this.f1383a = str;
        this.f1382a = pendingIntent;
    }

    public Status(int i) {
        this(i, (String) null);
    }

    public Status(int i, String str) {
        this(1, i, str, (PendingIntent) null);
    }

    public final String p() {
        return this.f1383a;
    }

    public final boolean r() {
        return this.f1382a != null;
    }

    public final int m() {
        return this.f1384b;
    }

    public final int hashCode() {
        return e40.b(Integer.valueOf(this.f1381a), Integer.valueOf(this.f1384b), this.f1383a, this.f1382a);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f1381a != status.f1381a || this.f1384b != status.f1384b || !e40.a(this.f1383a, status.f1383a) || !e40.a(this.f1382a, status.f1382a)) {
            return false;
        }
        return true;
    }

    public final String s() {
        String str = this.f1383a;
        if (str != null) {
            return str;
        }
        return la.a(this.f1384b);
    }

    public final String toString() {
        return e40.c(this).a("statusCode", s()).a("resolution", this.f1382a).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.h(parcel, 1, m());
        fi0.l(parcel, 2, p(), false);
        fi0.k(parcel, 3, this.f1382a, i, false);
        fi0.h(parcel, 1000, this.f1381a);
        fi0.b(parcel, a2);
    }
}
