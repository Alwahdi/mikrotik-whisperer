package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class w implements Parcelable {
    public static final Parcelable.Creator<w> CREATOR = new v();
    private Messenger a;

    /* renamed from: a  reason: collision with other field name */
    private f0 f2451a;

    public static final class a extends ClassLoader {
        /* access modifiers changed from: protected */
        public final Class<?> loadClass(String str, boolean z) {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            if (!FirebaseInstanceId.w()) {
                return w.class;
            }
            Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
            return w.class;
        }
    }

    public w(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.a = new Messenger(iBinder);
        } else {
            this.f2451a = new i0(iBinder);
        }
    }

    public final void i(Message message) {
        Messenger messenger = this.a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f2451a.W(message);
        }
    }

    private final IBinder f() {
        Messenger messenger = this.a;
        return messenger != null ? messenger.getBinder() : this.f2451a.asBinder();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return f().equals(((w) obj).f());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return f().hashCode();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f2451a.asBinder());
        }
    }
}
