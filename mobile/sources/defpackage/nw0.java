package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: nw0  reason: default package */
public abstract class nw0 extends Binder implements IInterface {
    private static fx0 a = null;

    protected nw0(String str) {
        attachInterface(this, str);
    }

    /* access modifiers changed from: protected */
    public abstract boolean h0(int i, Parcel parcel, Parcel parcel2, int i2);

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z;
        if (i > 16777215) {
            z = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z = false;
        }
        if (z) {
            return true;
        }
        return h0(i, parcel, parcel2, i2);
    }
}
