package defpackage;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: vw0  reason: default package */
public final class vw0 extends x {
    public static final Parcelable.Creator<vw0> CREATOR = new mw0();
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private Intent f5420a;
    private int b;

    vw0(int i, int i2, Intent intent) {
        this.a = i;
        this.b = i2;
        this.f5420a = intent;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.h(parcel, 1, this.a);
        fi0.h(parcel, 2, this.b);
        fi0.k(parcel, 3, this.f5420a, i, false);
        fi0.b(parcel, a2);
    }
}
