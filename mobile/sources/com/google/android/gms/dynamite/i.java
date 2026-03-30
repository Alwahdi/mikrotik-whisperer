package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.kr;

public final class i extends sy0 implements x71 {
    i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final kr O(kr krVar, String str, int i) {
        Parcel a = a();
        a31.c(a, krVar);
        a.writeString(str);
        a.writeInt(i);
        Parcel b = b(2, a);
        kr b2 = kr.a.b(b.readStrongBinder());
        b.recycle();
        return b2;
    }

    public final int e(kr krVar, String str, boolean z) {
        Parcel a = a();
        a31.c(a, krVar);
        a.writeString(str);
        a31.a(a, z);
        Parcel b = b(3, a);
        int readInt = b.readInt();
        b.recycle();
        return readInt;
    }

    public final kr d0(kr krVar, String str, int i) {
        Parcel a = a();
        a31.c(a, krVar);
        a.writeString(str);
        a.writeInt(i);
        Parcel b = b(4, a);
        kr b2 = kr.a.b(b.readStrongBinder());
        b.recycle();
        return b2;
    }

    public final int V(kr krVar, String str, boolean z) {
        Parcel a = a();
        a31.c(a, krVar);
        a.writeString(str);
        a31.a(a, z);
        Parcel b = b(5, a);
        int readInt = b.readInt();
        b.recycle();
        return readInt;
    }

    public final int C() {
        Parcel b = b(6, a());
        int readInt = b.readInt();
        b.recycle();
        return readInt;
    }
}
