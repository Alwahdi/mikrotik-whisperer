package defpackage;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* renamed from: b61  reason: default package */
public final class b61 extends x {
    public static final Parcelable.Creator<b61> CREATOR = new f61();
    private long a;

    /* renamed from: a  reason: collision with other field name */
    private String f192a;

    /* renamed from: a  reason: collision with other field name */
    private List<u61> f193a;

    /* renamed from: a  reason: collision with other field name */
    private l71 f194a;

    /* renamed from: a  reason: collision with other field name */
    private z61 f195a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f196a;
    private long b;

    /* renamed from: b  reason: collision with other field name */
    private String f197b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f198b;
    private String c;
    private String d;
    private String e;
    private String f;

    public b61(String str, String str2, boolean z, String str3, String str4, z61 z61, String str5, String str6, long j, long j2, boolean z2, l71 l71, List<u61> list) {
        z61 z612;
        this.f192a = str;
        this.f197b = str2;
        this.f196a = z;
        this.c = str3;
        this.d = str4;
        if (z61 == null) {
            z612 = new z61();
        } else {
            z612 = z61.p(z61);
        }
        this.f195a = z612;
        this.e = str5;
        this.f = str6;
        this.a = j;
        this.b = j2;
        this.f198b = z2;
        this.f194a = l71;
        this.f193a = list == null ? t11.j() : list;
    }

    public final String m() {
        return this.f197b;
    }

    public final boolean p() {
        return this.f196a;
    }

    public final String r() {
        return this.f192a;
    }

    public final String s() {
        return this.c;
    }

    public final Uri t() {
        if (!TextUtils.isEmpty(this.d)) {
            return Uri.parse(this.d);
        }
        return null;
    }

    public final String u() {
        return this.f;
    }

    public final long v() {
        return this.a;
    }

    public final long w() {
        return this.b;
    }

    public final boolean x() {
        return this.f198b;
    }

    public final List<w61> y() {
        return this.f195a.m();
    }

    public final l71 z() {
        return this.f194a;
    }

    public final List<u61> A() {
        return this.f193a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 2, this.f192a, false);
        fi0.l(parcel, 3, this.f197b, false);
        fi0.c(parcel, 4, this.f196a);
        fi0.l(parcel, 5, this.c, false);
        fi0.l(parcel, 6, this.d, false);
        fi0.k(parcel, 7, this.f195a, i, false);
        fi0.l(parcel, 8, this.e, false);
        fi0.l(parcel, 9, this.f, false);
        fi0.i(parcel, 10, this.a);
        fi0.i(parcel, 11, this.b);
        fi0.c(parcel, 12, this.f198b);
        fi0.k(parcel, 13, this.f194a, i, false);
        fi0.o(parcel, 14, this.f193a, false);
        fi0.b(parcel, a2);
    }
}
