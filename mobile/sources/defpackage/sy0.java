package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: sy0  reason: default package */
public abstract class sy0 implements IInterface {
    private final IBinder a;

    /* renamed from: a  reason: collision with other field name */
    private final String f5067a;

    protected sy0(IBinder iBinder, String str) {
        this.a = iBinder;
        this.f5067a = str;
    }

    public IBinder asBinder() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f5067a);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel b(int i, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }
}
