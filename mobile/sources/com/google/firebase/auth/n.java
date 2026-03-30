package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.h;

public final class n implements Parcelable.Creator<h.a> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new h.a[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            ei0.h(l);
            ei0.r(parcel, l);
        }
        ei0.g(parcel, s);
        return new h.a();
    }
}
