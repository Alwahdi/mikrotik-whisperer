package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: dy0  reason: default package */
public final class dy0 extends x {
    public static final Parcelable.Creator<dy0> CREATOR = new by0();
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final ke0 f2830a;

    dy0(int i, ke0 ke0) {
        this.a = i;
        this.f2830a = ke0;
    }

    public dy0(ke0 ke0) {
        this(1, ke0);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.h(parcel, 1, this.a);
        fi0.k(parcel, 2, this.f2830a, i, false);
        fi0.b(parcel, a2);
    }
}
