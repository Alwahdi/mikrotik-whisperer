package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new a();
    private final float a;

    /* renamed from: a  reason: collision with other field name */
    private final int f1385a;

    /* renamed from: a  reason: collision with other field name */
    private final long f1386a;

    /* renamed from: a  reason: collision with other field name */
    private final String f1387a;

    /* renamed from: a  reason: collision with other field name */
    private final List<String> f1388a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f1389a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private final long f1390b;

    /* renamed from: b  reason: collision with other field name */
    private final String f1391b;
    private final int c;

    /* renamed from: c  reason: collision with other field name */
    private final long f1392c;

    /* renamed from: c  reason: collision with other field name */
    private final String f1393c;
    private int d;

    /* renamed from: d  reason: collision with other field name */
    private long f1394d;

    /* renamed from: d  reason: collision with other field name */
    private final String f1395d;
    private final String e;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5, boolean z) {
        this.f1385a = i;
        this.f1386a = j;
        this.b = i2;
        this.f1387a = str;
        this.f1391b = str3;
        this.f1393c = str5;
        this.c = i3;
        this.f1394d = -1;
        this.f1388a = list;
        this.f1395d = str2;
        this.f1390b = j2;
        this.d = i4;
        this.e = str4;
        this.a = f;
        this.f1392c = j3;
        this.f1389a = z;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5, boolean z) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5, z);
    }

    public final long p() {
        return this.f1386a;
    }

    public final int m() {
        return this.b;
    }

    public final long r() {
        return this.f1394d;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.h(parcel, 1, this.f1385a);
        fi0.i(parcel, 2, p());
        fi0.l(parcel, 4, this.f1387a, false);
        fi0.h(parcel, 5, this.c);
        fi0.m(parcel, 6, this.f1388a, false);
        fi0.i(parcel, 8, this.f1390b);
        fi0.l(parcel, 10, this.f1391b, false);
        fi0.h(parcel, 11, m());
        fi0.l(parcel, 12, this.f1395d, false);
        fi0.l(parcel, 13, this.e, false);
        fi0.h(parcel, 14, this.d);
        fi0.f(parcel, 15, this.a);
        fi0.i(parcel, 16, this.f1392c);
        fi0.l(parcel, 17, this.f1393c, false);
        fi0.c(parcel, 18, this.f1389a);
        fi0.b(parcel, a2);
    }

    public final String s() {
        String str;
        String str2 = this.f1387a;
        int i = this.c;
        List<String> list = this.f1388a;
        String str3 = "";
        if (list == null) {
            str = str3;
        } else {
            str = TextUtils.join(",", list);
        }
        int i2 = this.d;
        String str4 = this.f1391b;
        if (str4 == null) {
            str4 = str3;
        }
        String str5 = this.e;
        if (str5 == null) {
            str5 = str3;
        }
        float f = this.a;
        String str6 = this.f1393c;
        if (str6 != null) {
            str3 = str6;
        }
        boolean z = this.f1389a;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 51 + String.valueOf(str).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str3).length());
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }
}
