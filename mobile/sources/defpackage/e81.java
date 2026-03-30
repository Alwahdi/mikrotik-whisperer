package defpackage;

import android.os.Parcel;

/* renamed from: e81  reason: default package */
public abstract class e81 extends e11 implements w71 {
    public e81() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                kr Q = Q();
                parcel2.writeNoException();
                a31.c(parcel2, Q);
                return true;
            case 2:
                int p = p();
                parcel2.writeNoException();
                parcel2.writeInt(p);
                return true;
            default:
                return false;
        }
    }
}
