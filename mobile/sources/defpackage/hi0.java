package defpackage;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: hi0  reason: default package */
public abstract class hi0 {
    public static <T extends gi0> byte[] d(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <T extends gi0> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        y90.j(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T t = (gi0) creator.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }

    public static <T extends gi0> String f(T t) {
        return v5.c(d(t));
    }

    public static <T extends gi0> T c(String str, Parcelable.Creator<T> creator) {
        return a(v5.a(str), creator);
    }

    public static <T extends gi0> void e(T t, Intent intent, String str) {
        intent.putExtra(str, d(t));
    }

    public static <T extends gi0> T b(Intent intent, String str, Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return a(byteArrayExtra, creator);
    }
}
