package defpackage;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: hr  reason: default package */
final class hr implements ir {
    private final IBinder a;

    hr(IBinder iBinder) {
        this.a = iBinder;
    }

    public final IBinder asBinder() {
        return this.a;
    }

    public final void j(gr grVar, gp gpVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(grVar != null ? grVar.asBinder() : null);
            if (gpVar != null) {
                obtain.writeInt(1);
                gpVar.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
