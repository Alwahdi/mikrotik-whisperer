package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: tw0  reason: default package */
public abstract class tw0 implements IInterface {
    private final IBinder a;

    /* renamed from: a  reason: collision with other field name */
    private final String f5177a;

    protected tw0(IBinder iBinder, String str) {
        this.a = iBinder;
        this.f5177a = str;
    }

    public IBinder asBinder() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f5177a);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void b(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
