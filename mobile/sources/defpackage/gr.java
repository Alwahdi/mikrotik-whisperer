package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: gr  reason: default package */
public interface gr extends IInterface {
    void D(int i, Bundle bundle);

    void F(int i, IBinder iBinder, Bundle bundle);

    void P(int i, IBinder iBinder, c11 c11);

    /* renamed from: gr$a */
    public static abstract class a extends e11 implements gr {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        /* access modifiers changed from: protected */
        public final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    F(parcel.readInt(), parcel.readStrongBinder(), (Bundle) a31.b(parcel, Bundle.CREATOR));
                    break;
                case 2:
                    D(parcel.readInt(), (Bundle) a31.b(parcel, Bundle.CREATOR));
                    break;
                case 3:
                    P(parcel.readInt(), parcel.readStrongBinder(), (c11) a31.b(parcel, c11.CREATOR));
                    break;
                default:
                    return false;
            }
            parcel2.writeNoException();
            return true;
        }
    }
}
