package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: u51  reason: default package */
public final class u51 extends x {
    public static final Parcelable.Creator<u51> CREATOR = new v51();
    private e71 a;

    /* renamed from: a  reason: collision with other field name */
    private String f5194a;

    /* renamed from: a  reason: collision with other field name */
    private List<String> f5195a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f5196a;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f5197b;

    public u51(String str, boolean z, String str2, boolean z2, e71 e71, List<String> list) {
        this.f5194a = str;
        this.f5196a = z;
        this.b = str2;
        this.f5197b = z2;
        this.a = e71 == null ? e71.p() : e71.m(e71);
        this.f5195a = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 2, this.f5194a, false);
        fi0.c(parcel, 3, this.f5196a);
        fi0.l(parcel, 4, this.b, false);
        fi0.c(parcel, 5, this.f5197b);
        fi0.k(parcel, 6, this.a, i, false);
        fi0.m(parcel, 7, this.f5195a, false);
        fi0.b(parcel, a2);
    }
}
