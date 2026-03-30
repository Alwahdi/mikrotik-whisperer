package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface a extends IInterface {
    void cancel(String str, int i, String str2);

    void cancelAll(String str);

    void notify(String str, int i, String str2, Notification notification);

    /* renamed from: android.support.v4.app.a$a  reason: collision with other inner class name */
    public static abstract class C0001a extends Binder implements a {
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        public C0001a() {
            attachInterface(this, "android.support.v4.app.INotificationSideChannel");
        }

        public static a asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (iin == null || !(iin instanceof a)) {
                return new C0002a(obj);
            }
            return (a) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface("android.support.v4.app.INotificationSideChannel");
            }
            switch (code) {
                case 1598968902:
                    reply.writeString("android.support.v4.app.INotificationSideChannel");
                    return true;
                default:
                    switch (code) {
                        case 1:
                            notify(data.readString(), data.readInt(), data.readString(), (Notification) b.c(data, Notification.CREATOR));
                            break;
                        case 2:
                            cancel(data.readString(), data.readInt(), data.readString());
                            break;
                        case 3:
                            cancelAll(data.readString());
                            break;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
                    return true;
            }
        }

        /* renamed from: android.support.v4.app.a$a$a  reason: collision with other inner class name */
        private static class C0002a implements a {
            private IBinder a;

            C0002a(IBinder remote) {
                this.a = remote;
            }

            public IBinder asBinder() {
                return this.a;
            }

            public void notify(String packageName, int id, String tag, Notification notification) {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    _data.writeString(packageName);
                    _data.writeInt(id);
                    _data.writeString(tag);
                    b.d(_data, notification, 0);
                    this.a.transact(1, _data, (Parcel) null, 1);
                } finally {
                    _data.recycle();
                }
            }

            public void cancel(String packageName, int id, String tag) {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    _data.writeString(packageName);
                    _data.writeInt(id);
                    _data.writeString(tag);
                    this.a.transact(2, _data, (Parcel) null, 1);
                } finally {
                    _data.recycle();
                }
            }

            public void cancelAll(String packageName) {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    _data.writeString(packageName);
                    this.a.transact(3, _data, (Parcel) null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }

    public static class b {
        /* access modifiers changed from: private */
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> c) {
            if (parcel.readInt() != 0) {
                return c.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void d(Parcel parcel, T value, int parcelableFlags) {
            if (value != null) {
                parcel.writeInt(1);
                value.writeToParcel(parcel, parcelableFlags);
                return;
            }
            parcel.writeInt(0);
        }
    }
}
