package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;

/* renamed from: ei0  reason: default package */
public abstract class ei0 {

    /* renamed from: ei0$a */
    public static class a extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.lang.String r4, android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                int r1 = r1 + 41
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ei0.a.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    public static int l(Parcel parcel) {
        return parcel.readInt();
    }

    public static int h(int i) {
        return i & SupportMenu.USER_MASK;
    }

    public static int q(Parcel parcel, int i) {
        if ((i & SupportMenu.CATEGORY_MASK) != -65536) {
            return (i >> 16) & SupportMenu.USER_MASK;
        }
        return parcel.readInt();
    }

    public static void r(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + q(parcel, i));
    }

    private static void t(Parcel parcel, int i, int i2) {
        int q = q(parcel, i);
        if (q != i2) {
            String hexString = Integer.toHexString(q);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i2);
            sb.append(" got ");
            sb.append(q);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new a(sb.toString(), parcel);
        }
    }

    private static void u(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String hexString = Integer.toHexString(i2);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i3);
            sb.append(" got ");
            sb.append(i2);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new a(sb.toString(), parcel);
        }
    }

    public static int s(Parcel parcel) {
        int l = l(parcel);
        int q = q(parcel, l);
        int dataPosition = parcel.dataPosition();
        if (h(l) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(l));
            throw new a(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i = q + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i);
        throw new a(sb.toString(), parcel);
    }

    public static boolean i(Parcel parcel, int i) {
        t(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean j(Parcel parcel, int i) {
        int q = q(parcel, i);
        if (q == 0) {
            return null;
        }
        u(parcel, i, q, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static int n(Parcel parcel, int i) {
        t(parcel, i, 4);
        return parcel.readInt();
    }

    public static long o(Parcel parcel, int i) {
        t(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long p(Parcel parcel, int i) {
        int q = q(parcel, i);
        if (q == 0) {
            return null;
        }
        u(parcel, i, q, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static float k(Parcel parcel, int i) {
        t(parcel, i, 4);
        return parcel.readFloat();
    }

    public static String c(Parcel parcel, int i) {
        int q = q(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (q == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + q);
        return readString;
    }

    public static IBinder m(Parcel parcel, int i) {
        int q = q(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (q == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + q);
        return readStrongBinder;
    }

    public static <T extends Parcelable> T b(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int q = q(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (q == 0) {
            return null;
        }
        T t = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + q);
        return t;
    }

    public static Bundle a(Parcel parcel, int i) {
        int q = q(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (q == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + q);
        return readBundle;
    }

    public static ArrayList<String> d(Parcel parcel, int i) {
        int q = q(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (q == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + q);
        return createStringArrayList;
    }

    public static <T> T[] e(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int q = q(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (q == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + q);
        return createTypedArray;
    }

    public static <T> ArrayList<T> f(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int q = q(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (q == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + q);
        return createTypedArrayList;
    }

    public static void g(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Overread allowed size end=");
            sb.append(i);
            throw new a(sb.toString(), parcel);
        }
    }
}
