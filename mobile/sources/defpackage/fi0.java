package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.List;

/* renamed from: fi0  reason: default package */
public abstract class fi0 {
    private static void s(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt(i | (i2 << 16));
    }

    private static int p(Parcel parcel, int i) {
        parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void r(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static int a(Parcel parcel) {
        return p(parcel, 20293);
    }

    public static void b(Parcel parcel, int i) {
        r(parcel, i);
    }

    public static void c(Parcel parcel, int i, boolean z) {
        s(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void d(Parcel parcel, int i, Boolean bool, boolean z) {
        if (bool != null) {
            s(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            s(parcel, i, 0);
        }
    }

    public static void h(Parcel parcel, int i, int i2) {
        s(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void i(Parcel parcel, int i, long j) {
        s(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void j(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            s(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            s(parcel, i, 0);
        }
    }

    public static void f(Parcel parcel, int i, float f) {
        s(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void l(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int p = p(parcel, i);
            parcel.writeString(str);
            r(parcel, p);
        } else if (z) {
            s(parcel, i, 0);
        }
    }

    public static void g(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int p = p(parcel, i);
            parcel.writeStrongBinder(iBinder);
            r(parcel, p);
        } else if (z) {
            s(parcel, i, 0);
        }
    }

    public static void k(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int p = p(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            r(parcel, p);
        } else if (z) {
            s(parcel, i, 0);
        }
    }

    public static void e(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int p = p(parcel, i);
            parcel.writeBundle(bundle);
            r(parcel, p);
        } else if (z) {
            s(parcel, i, 0);
        }
    }

    public static void m(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int p = p(parcel, i);
            parcel.writeStringList(list);
            r(parcel, p);
        } else if (z) {
            s(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void n(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int p = p(parcel, i);
            parcel.writeInt(r7);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    q(parcel, t, i2);
                }
            }
            r(parcel, p);
        } else if (z) {
            s(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void o(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int p = p(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    q(parcel, parcelable, 0);
                }
            }
            r(parcel, p);
        } else if (z) {
            s(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void q(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
