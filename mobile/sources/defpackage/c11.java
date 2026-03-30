package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: c11  reason: default package */
public final class c11 extends x {
    public static final Parcelable.Creator<c11> CREATOR = new y21();
    Bundle a;

    /* renamed from: a  reason: collision with other field name */
    nk[] f281a;

    c11(Bundle bundle, nk[] nkVarArr) {
        this.a = bundle;
        this.f281a = nkVarArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.e(parcel, 1, this.a, false);
        fi0.n(parcel, 2, this.f281a, i, false);
        fi0.b(parcel, a2);
    }
}
