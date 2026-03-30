package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

final class v implements Parcelable.Creator<w> {
    v() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new w[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            return new w(readStrongBinder);
        }
        return null;
    }
}
