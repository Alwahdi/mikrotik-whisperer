package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: i01  reason: default package */
public final class i01 extends x {
    public static final Parcelable.Creator<i01> CREATOR = new n01();
    private final List<mz0> a;

    i01(List<mz0> list) {
        this.a = list == null ? t11.j() : list;
    }

    public static i01 p(List<ga1> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ga1 next : list) {
            if (next instanceof mz0) {
                arrayList.add((mz0) next);
            }
        }
        return new i01(arrayList);
    }

    public final List<ga1> m() {
        ArrayList arrayList = new ArrayList();
        for (mz0 add : this.a) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.o(parcel, 1, this.a, false);
        fi0.b(parcel, a2);
    }
}
