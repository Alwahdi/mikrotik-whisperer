package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.kr;

public final class j extends sy0 implements o81 {
    j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final kr n(kr krVar, String str, int i, kr krVar2) {
        Parcel a = a();
        a31.c(a, krVar);
        a.writeString(str);
        a.writeInt(i);
        a31.c(a, krVar2);
        Parcel b = b(2, a);
        kr b2 = kr.a.b(b.readStrongBinder());
        b.recycle();
        return b2;
    }

    public final kr B(kr krVar, String str, int i, kr krVar2) {
        Parcel a = a();
        a31.c(a, krVar);
        a.writeString(str);
        a.writeInt(i);
        a31.c(a, krVar2);
        Parcel b = b(3, a);
        kr b2 = kr.a.b(b.readStrongBinder());
        b.recycle();
        return b2;
    }
}
